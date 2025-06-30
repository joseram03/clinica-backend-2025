package com.clinica.service;

import com.clinica.model.Paciente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PacienteService {

    @PersistenceContext(unitName = "clinicaPU")
    private EntityManager em;

    public void crear(Paciente paciente) {
        em.persist(paciente);
    }

    public void actualizar(Paciente paciente) {
        em.merge(paciente);
    }

    public void eliminar(Long id) {
        Paciente paciente = em.find(Paciente.class, id);
        if (paciente != null) {
            em.remove(paciente);
        }
    }

    public Paciente buscarPorId(Long id) {
        return em.find(Paciente.class, id);
    }

    public List<Paciente> listar() {
        return em.createQuery("SELECT p FROM Paciente p", Paciente.class).getResultList();
    }
}