package com.pablodelacruz.coachify.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record CalendarioDTO(Long eventoID, String nombreCita, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, LocalTime horaInicio, LocalTime horaFin, Long clienteID) {
    
}
