package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@Entity
public class Rutina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rutinaID;

    private Date fechaInicio;
    private Date fechaFin;
    private String notas;

    @ManyToOne
    @JoinColumn(name = "clienteID") // Nombre de la columna en la tabla Rutinas
    private Cliente cliente;

    // Constructor con todos los campos
    public Rutina(Date fechaInicio, Date fechaFin, String notas, Cliente cliente) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.notas = notas;
        this.cliente = cliente;
    }
}
