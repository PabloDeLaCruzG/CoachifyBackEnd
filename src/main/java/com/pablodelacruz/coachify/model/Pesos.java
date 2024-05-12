package com.pablodelacruz.coachify.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;;

@Data
@NoArgsConstructor
@Entity
public class Pesos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pesoID;

    @ManyToOne
    private Cliente clienteID;

    private double peso;
    private Date fecha;
    
    public Pesos(double peso, Date fecha, Cliente clienteID) {
        this.clienteID = clienteID;
        this.peso = peso;
        this.fecha = fecha;
    }
}
