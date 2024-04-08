package com.pablodelacruz.coachify.dto;

import java.time.LocalDate;

public record RutinaDTO(Long rutinaID, LocalDate fechaInicio, LocalDate fechaFin, String notas, Long clienteID) {
    
}
