package com.clinica.resource;

import com.clinica.model.Paciente;
import com.clinica.service.PacienteService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("pacientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PacienteResource {

    @Inject
    private PacienteService pacienteService;

    @POST
    public void crear(Paciente p) {
        pacienteService.crear(p);
    }

    @PUT
    public void actualizar(Paciente p) {
        pacienteService.actualizar(p);
    }

    @DELETE
    @Path("{id}")
    public void eliminar(@PathParam("id") Long id) {
        pacienteService.eliminar(id);
    }

    @GET
    public List<Paciente> listar() {
        return pacienteService.listar();
    }

    @GET
    @Path("{id}")
    public Paciente obtener(@PathParam("id") Long id) {
        return pacienteService.buscarPorId(id);
    }
}
