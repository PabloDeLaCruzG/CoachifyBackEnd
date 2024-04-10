package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@Entity
public class Progresos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long progresoID;

    private Date fecha;
    private double peso;
    private double imc;
    private double porGraCor;
    private String otrasMedidas;

    @ManyToOne
    @JoinColumn(name = "clienteID") // Nombre de la columna en la tabla Progresos
    private Cliente cliente;

    // Constructor con todos los campos
    public Progresos(Date fecha, double peso, double imc, double porGraCor, String otrasMedidas, Cliente cliente) {
        this.fecha = fecha;
        this.peso = peso;
        this.imc = imc;
        this.porGraCor = porGraCor;
        this.otrasMedidas = otrasMedidas;
        this.cliente = cliente;
    }
}
