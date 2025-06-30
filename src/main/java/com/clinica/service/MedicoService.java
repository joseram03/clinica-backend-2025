package com.clinica.service;

import com.clinica.model.Medico;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MedicoService {

    @PersistenceContext(unitName = "clinicaPU")
    private EntityManager em;

    public void crear(Medico medico) {
        em.persist(medico);
    }

    public void actualizar(Medico medico) {
        em.merge(medico);
    }

    public void eliminar(Long id) {
        Medico medico = em.find(Medico.class, id);
        if (medico != null) {
            em.remove(medico);
        }
    }

    public Medico buscarPorId(Long id) {
        return em.find(Medico.class, id);
    }

    public List<Medico> listar() {
        return em.createQuery("SELECT m FROM Medico m", Medico.class).getResultList();
    }

    public Medico login(String username, String password) {
        List<Medico> lista = em.createQuery(
                        "SELECT m FROM Medico m WHERE m.username = :user AND m.password = :pass", Medico.class)
                .setParameter("user", username)
                .setParameter("pass", password)
                .getResultList();
        return lista.isEmpty() ? null : lista.get(0);
    }
}
