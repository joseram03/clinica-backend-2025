package com.clinica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class FichaClinica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private String motivoConsulta;
    private String diagnostico;
    private String tratamiento;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    // Getters y Setters

    public FichaClinica() {
    }

    public FichaClinica(Long id, LocalDate fecha, String motivoConsulta, String diagnostico, String tratamiento, Paciente paciente, Medico medico) {
        this.id = id;
        this.fecha = fecha;
        this.motivoConsulta = motivoConsulta;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.paciente = paciente;
        this.medico = medico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    // ...
}
