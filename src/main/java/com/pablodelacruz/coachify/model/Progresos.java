package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;
import java.util.*;

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
    private Cliente cliente;

    // Constructor por defecto
    public Progresos() {
    }

    // Constructor con todos los campos
    public Progresos(Date fecha, double peso, double imc, double porGraCor, String otrasMedidas, Cliente cliente) {
        this.fecha = fecha;
        this.peso = peso;
        this.imc = imc;
        this.porGraCor = porGraCor;
        this.otrasMedidas = otrasMedidas;
        this.cliente = cliente;
    }

    // Getters y setters

    public Long getProgresoID() {
        return progresoID;
    }

    public void setProgresoID(Long progresoID) {
        this.progresoID = progresoID;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
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

    public String getOtrasMedidas() {
        return otrasMedidas;
    }

    public void setOtrasMedidas(String otrasMedidas) {
        this.otrasMedidas = otrasMedidas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
