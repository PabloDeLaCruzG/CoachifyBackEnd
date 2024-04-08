package com.pablodelacruz.coachify.dto;

import java.time.LocalDate;

public record ProgresosDTO(Long progresoID, LocalDate fecha, double peso, double imc, double porGraCor, String otrasMedidas, Long clienteID) {
    
}
