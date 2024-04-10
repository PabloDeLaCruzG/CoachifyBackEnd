package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;
import lombok.*;

import com.pablodelacruz.coachify.enums.DiaSemana;

@Data
@NoArgsConstructor
// Indica que es una entidad
@Entity
public class RutinaEjercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rutinaEjercicioID;

    @ManyToOne
    @JoinColumn(name = "rutina_id") // Nombre de la columna en la tabla Rutinas
    private Rutina rutina;

    @ManyToOne
    @JoinColumn(name = "ejercicio_id") // Nombre de la columna en la tabla Ejercicios
    private Ejercicio ejercicio;

    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;

    private int series;
    private int repeticiones;

    // Constructor con todos los campos
    public RutinaEjercicio(Rutina rutina, Ejercicio ejercicio, DiaSemana diaSemana, int series, int repeticiones) {
        this.rutina = rutina;
        this.ejercicio = ejercicio;
        this.diaSemana = diaSemana;
        this.series = series;
        this.repeticiones = repeticiones;
    }
}