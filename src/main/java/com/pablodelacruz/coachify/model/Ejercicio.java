package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ejercicioID;

    private String nombreEjercicio;
    private String descripcion;
    private String imagenEjercicio;

    // Constructor con todos los campos
    public Ejercicio(String nombreEjercicio, String descripcion, String imagenEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
        this.descripcion = descripcion;
        this.imagenEjercicio = imagenEjercicio;
    }
}