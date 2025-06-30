package com.clinica.service;

import com.clinica.model.FichaClinica;
import javax.persistence.TypedQuery;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class FichaClinicaService {

    @PersistenceContext(unitName = "clinicaPU")
    private EntityManager em;

    public void crear(FichaClinica ficha) {
        if (ficha.getFecha() == null) {
            ficha.setFecha(LocalDate.now());
        }
        em.persist(ficha);
    }

    public FichaClinica buscarPorId(Long id) {
        return em.find(FichaClinica.class, id);
    }

    public List<FichaClinica> listar() {
        return em.createQuery("SELECT f FROM FichaClinica f", FichaClinica.class).getResultList();
    }

    public List<FichaClinica> filtrar(String texto, String especialidad, Long pacienteId, Long medicoId) {
        String q = "SELECT f FROM FichaClinica f WHERE 1=1 ";
        if (texto != null && !texto.isEmpty()) {
            q += "AND (LOWER(f.motivoConsulta) LIKE LOWER(:txt) OR LOWER(f.diagnostico) LIKE LOWER(:txt) OR LOWER(f.tratamiento) LIKE LOWER(:txt)) ";
        }
        if (especialidad != null && !especialidad.isEmpty()) {
            q += "AND LOWER(f.medico.especialidad) = LOWER(:esp) ";
        }
        if (pacienteId != null) {
            q += "AND f.paciente.id = :pid ";
        }
        if (medicoId != null) {
            q += "AND f.medico.id = :mid ";
        }

        TypedQuery<FichaClinica> query = em.createQuery(q, FichaClinica.class);
        if (texto != null && !texto.isEmpty()) query.setParameter("txt", "%" + texto + "%");
        if (especialidad != null && !especialidad.isEmpty()) query.setParameter("esp", especialidad);
        if (pacienteId != null) query.setParameter("pid", pacienteId);
        if (medicoId != null) query.setParameter("mid", medicoId);
        return query.getResultList();
    }
}