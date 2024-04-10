package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioID;

    private String mail;
    private String telefono;
    private String nombreUsuario;
    private String contrasena;

    // Constructor con todos los campos
    public Usuario(String mail, String telefono, String nombreUsuario) {
        this.mail = mail;
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
    }
}
