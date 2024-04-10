package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.sql.Time;

@Data
@NoArgsConstructor
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
    @JoinColumn(name = "clienteID") // Nombre de la columna en la tabla Calendario
    private Cliente cliente;

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
}