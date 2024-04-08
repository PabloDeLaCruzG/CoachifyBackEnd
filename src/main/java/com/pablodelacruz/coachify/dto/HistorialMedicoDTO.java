package com.pablodelacruz.coachify.dto;

public record HistorialMedicoDTO(Long historialID, String enfermedades, String alergias, String condiciones, String restricciones, String informesMedicos, Long clienteID) {
    
}
