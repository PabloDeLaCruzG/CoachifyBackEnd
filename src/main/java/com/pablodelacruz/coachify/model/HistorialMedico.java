package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(indexes = {@Index(columnList = "clienteID")})
public class HistorialMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historialID;

    private String enfermedades;
    private String alergias;
    private String condiciones;
    private String restricciones;
    private String informesMedicos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clienteID")
    private Cliente cliente;

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
}
