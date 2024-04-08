package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;

@Entity
public class ComposicionCorporal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long composicionID;

    private double peso;
    private double altura;
    private double imc;
    private double porGraCor;
    private double cirCintura;
    private double cirCadera;

    @ManyToOne
    private Cliente cliente;

    // Constructor por defecto
    public ComposicionCorporal() {
    }

    // Constructor con todos los campos
    public ComposicionCorporal(double peso, double altura, double imc, double porGraCor, double cirCintura,
            double cirCadera, Cliente cliente) {
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
        this.porGraCor = porGraCor;
        this.cirCintura = cirCintura;
        this.cirCadera = cirCadera;
        this.cliente = cliente;
    }

    // Getters y setters

    public Long getComposicionID() {
        return composicionID;
    }

    public void setComposicionID(Long composicionID) {
        this.composicionID = composicionID;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getPorGraCor() {
        return porGraCor;
    }

    public void setPorGraCor(double porGraCor) {
        this.porGraCor = porGraCor;
    }

    public double getCirCintura() {
        return cirCintura;
    }

    public void setCirCintura(double cirCintura) {
        this.cirCintura = cirCintura;
    }

    public double getCirCadera() {
        return cirCadera;
    }

    public void setCirCadera(double cirCadera) {
        this.cirCadera = cirCadera;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
