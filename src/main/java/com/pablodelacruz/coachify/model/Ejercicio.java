package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;

@Entity
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ejercicioID;

    private String nombreEjercicio;
    private String descripcion;
    private String imagenEjercicio;

    // Constructor por defecto
    public Ejercicio() {
    }

    // Constructor con todos los campos
    public Ejercicio(String nombreEjercicio, String descripcion, String imagenEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
        this.descripcion = descripcion;
        this.imagenEjercicio = imagenEjercicio;
    }

    // Getters y setters

    public Long getEjercicioID() {
        return ejercicioID;
    }

    public void setEjercicioID(Long ejercicioID) {
        this.ejercicioID = ejercicioID;
    }

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenEjercicio() {
        return imagenEjercicio;
    }

    public void setImagenEjercicio(String imagenEjercicio) {
        this.imagenEjercicio = imagenEjercicio;
    }
}
