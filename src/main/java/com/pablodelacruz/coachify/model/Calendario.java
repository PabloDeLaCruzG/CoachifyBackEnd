package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;
import java.util.*;
import java.sql.Time;

@Entity
public class Calendario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventoID;

    private String nombreCita;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private Time horaInicio;
    private Time horaFin;

    @ManyToOne
    private Cliente cliente;

    // Constructor por defecto
    public Calendario() {
    }

    // Constructor con todos los campos
    public Calendario(String nombreCita, String descripcion, Date fechaInicio, Date fechaFin, Time horaInicio,
            Time horaFin, Cliente cliente) {
        this.nombreCita = nombreCita;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.cliente = cliente;
    }

    // Getters y setters

    public Long getEventoID() {
        return eventoID;
    }

    public void setEventoID(Long eventoID) {
        this.eventoID = eventoID;
    }

    public String getNombreCita() {
        return nombreCita;
    }

    public void setNombreCita(String nombreCita) {
        this.nombreCita = nombreCita;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
