package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(indexes = {@Index(columnList = "clienteID")})
public class ComposicionCorporal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long composicionID;

    private double peso;
    private int altura;
    private double imc;
    private double porGraCor;
    private double cirCintura;
    private double cirCadera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clienteID")
    private Cliente cliente;

    // Constructor con todos los campos
    public ComposicionCorporal(double peso, int altura, double imc, double porGraCor, double cirCintura,
            double cirCadera, Cliente cliente) {
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
        this.porGraCor = porGraCor;
        this.cirCintura = cirCintura;
        this.cirCadera = cirCadera;
        this.cliente = cliente;
    }
}
