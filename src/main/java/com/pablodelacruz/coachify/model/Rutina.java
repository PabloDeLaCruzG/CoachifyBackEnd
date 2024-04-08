package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Rutina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rutinaID;

    private Date fechaInicio;
    private Date fechaFin;
    private String notas;

    @ManyToOne
    private Cliente cliente;

    // Constructor por defecto
    public Rutina() {
    }

    // Constructor con todos los campos
    public Rutina(Date fechaInicio, Date fechaFin, String notas, Cliente cliente) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.notas = notas;
        this.cliente = cliente;
    }

    // Getters y setters

    public Long getRutinaID() {
        return rutinaID;
    }

    public void setRutinaID(Long rutinaID) {
        this.rutinaID = rutinaID;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
