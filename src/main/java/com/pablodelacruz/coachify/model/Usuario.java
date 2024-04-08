package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioID;

    private String mail;
    private String telefono;
    private String nombreUsuario;
    private String contrasena;

    // Constructor por defecto
    public Usuario() {
    }

    // Constructor con todos los campos
    public Usuario(String mail, String telefono, String nombreUsuario) {
        this.mail = mail;
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
    }

    // Getters y setters

    public Long getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Long usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
