package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;

@Entity
public class HistorialMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historialID;

    private String enfermedades;
    private String alergias;
    private String condiciones;
    private String restricciones;
    private String informesMedicos;

    @ManyToOne
    private Cliente cliente;

    // Constructor por defecto
    public HistorialMedico() {
    }

    // Constructor con todos los campos
    public HistorialMedico(String enfermedades, String alergias, String condiciones, String restricciones,
            String informesMedicos, Cliente cliente) {
        this.enfermedades = enfermedades;
        this.alergias = alergias;
        this.condiciones = condiciones;
        this.restricciones = restricciones;
        this.informesMedicos = informesMedicos;
        this.cliente = cliente;
    }

    // Getters y setters

    public Long getHistorialID() {
        return historialID;
    }

    public void setHistorialID(Long historialID) {
        this.historialID = historialID;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }

    public String getInformesMedicos() {
        return informesMedicos;
    }

    public void setInformesMedicos(String informesMedicos) {
        this.informesMedicos = informesMedicos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
