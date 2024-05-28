package com.pablodelacruz.coachify.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(indexes = {@Index(columnList = "clienteID")})
public class Pesos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pesoID;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente clienteID;

    private double peso;
    private Date fecha;
    
    public Pesos(double peso, Date fecha, Cliente clienteID) {
        this.clienteID = clienteID;
        this.peso = peso;
        this.fecha = fecha;
    }
}
