package com.clinica.resource;

import com.clinica.model.FichaClinica;
import com.clinica.service.FichaClinicaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("fichas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FichaClinicaResource {

    @Inject
    private FichaClinicaService fichaClinicaService;

    @POST
    public void crear(FichaClinica ficha) {
        fichaClinicaService.crear(ficha);
    }

    @GET
    @Path("{id}")
    public FichaClinica obtener(@PathParam("id") Long id) {
        return fichaClinicaService.buscarPorId(id);
    }

    @GET
    public List<FichaClinica> listar() {
        return fichaClinicaService.listar();
    }

    @GET
    @Path("filtrar")
    public List<FichaClinica> filtrar(@QueryParam("texto") String texto,
                                      @QueryParam("especialidad") String especialidad,
                                      @QueryParam("pacienteId") Long pacienteId,
                                      @QueryParam("medicoId") Long medicoId) {
        return fichaClinicaService.filtrar(texto, especialidad, pacienteId, medicoId);
    }
}
