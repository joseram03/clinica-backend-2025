package com.clinica.resource;

import com.clinica.model.Medico;
import com.clinica.service.MedicoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("medicos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicoResource {

    @Inject
    private MedicoService medicoService;

    @POST
    @Path("crear")
    public void crear(Medico m) {
        medicoService.crear(m);
    }

    @PUT
    public void actualizar(Medico m) {
        medicoService.actualizar(m);
    }

    @DELETE
    @Path("{id}")
    public void eliminar(@PathParam("id") Long id) {
        medicoService.eliminar(id);
    }

    @GET
    public List<Medico> listar() {
        return medicoService.listar();
    }

    @GET
    @Path("{id}")
    public Medico obtener(@PathParam("id") Long id) {
        return medicoService.buscarPorId(id);
    }

    @POST
    @Path("login")
    public Medico login(Medico credenciales) {
        return medicoService.login(credenciales.getUsername(), credenciales.getPassword());
    }
}
