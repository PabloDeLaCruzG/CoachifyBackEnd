package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Objetivos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long objetivoID;

    private String objCorPla;
    private String objLarPla;
    private String objGen;
    private String nivelInicial;
    private String preferencias;
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "clienteID") // Nombre de la columna en la tabla Objetivos
    private Cliente cliente;

    // Constructor con todos los campos
    public Objetivos(String objCorPla, String objLarPla, String objGen, String nivelInicial, String preferencias,
            String observaciones, Cliente cliente) {
        this.objCorPla = objCorPla;
        this.objLarPla = objLarPla;
        this.objGen = objGen;
        this.nivelInicial = nivelInicial;
        this.preferencias = preferencias;
        this.observaciones = observaciones;
        this.cliente = cliente;
    }
}
