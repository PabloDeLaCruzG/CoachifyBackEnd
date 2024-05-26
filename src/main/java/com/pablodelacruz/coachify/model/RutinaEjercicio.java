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
    @JoinColumn(name = "rutinaID") // Nombre de la columna en la tabla Rutinas
    private Rutina rutinaID;

    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;

    private String nombre;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String img;

    private int series;
    private int repeticiones;

    // Constructor con todos los campos
    public RutinaEjercicio(Rutina rutinaID, String img, DiaSemana diaSemana, String nombre, int series, int repeticiones) {
        this.nombre = nombre;
        this.rutinaID = rutinaID;
        this.img = img;
        this.diaSemana = diaSemana;
        this.series = series;
        this.repeticiones = repeticiones;
    }
}