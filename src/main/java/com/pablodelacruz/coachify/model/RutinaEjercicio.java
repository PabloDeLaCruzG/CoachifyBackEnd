package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class RutinaEjercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rutinaEjercicioID;

    @ManyToOne
    private Rutina rutina;

    @ManyToOne
    private Ejercicio ejercicio;

    @Enumerated(EnumType.STRING)
    private Date diaSemana;

    private int series;
    private int repeticiones;

    // Constructor por defecto
    public RutinaEjercicio() {
    }

    // Constructor con todos los campos
    public RutinaEjercicio(Rutina rutina, Ejercicio ejercicio, Date diaSemana, int series, int repeticiones) {
        this.rutina = rutina;
        this.ejercicio = ejercicio;
        this.diaSemana = diaSemana;
        this.series = series;
        this.repeticiones = repeticiones;
    }

    // Getters y setters

    public Long getRutinaEjercicioID() {
        return rutinaEjercicioID;
    }

    public void setRutinaEjercicioID(Long rutinaEjercicioID) {
        this.rutinaEjercicioID = rutinaEjercicioID;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public Date getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Date diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }
}
