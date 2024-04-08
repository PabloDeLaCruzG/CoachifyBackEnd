package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;

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
    private Cliente cliente;

    // Constructor por defecto
    public Objetivos() {
    }

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

    // Getters y setters

    public Long getObjetivoID() {
        return objetivoID;
    }

    public void setObjetivoID(Long objetivoID) {
        this.objetivoID = objetivoID;
    }

    public String getObjCorPla() {
        return objCorPla;
    }

    public void setObjCorPla(String objCorPla) {
        this.objCorPla = objCorPla;
    }

    public String getObjLarPla() {
        return objLarPla;
    }

    public void setObjLarPla(String objLarPla) {
        this.objLarPla = objLarPla;
    }

    public String getObjGen() {
        return objGen;
    }

    public void setObjGen(String objGen) {
        this.objGen = objGen;
    }

    public String getNivelInicial() {
        return nivelInicial;
    }

    public void setNivelInicial(String nivelInicial) {
        this.nivelInicial = nivelInicial;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
