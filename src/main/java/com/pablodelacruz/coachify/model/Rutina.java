package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(indexes = {@Index(columnList = "clienteID")})
public class Rutina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rutinaID;

    private String nombre;

    private Date fechaInicio;
    private Date fechaFin;
    private String notas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clienteID")
    private Cliente clienteID;

    // Constructor con todos los campos
    public Rutina(String nombre, Date fechaInicio, Date fechaFin, String notas, Cliente clienteID) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.notas = notas;
        this.clienteID = clienteID;
    }
}
