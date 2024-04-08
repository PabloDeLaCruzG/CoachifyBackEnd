package com.pablodelacruz.coachify.dto;

import java.util.Date;

import com.pablodelacruz.coachify.enums.Genero;

public record ClienteDTO(Long clienteID, String nombreCompleto, Date fechaNacimiento, Genero genero, String direccion, String mail, String telefono)  {
    
}
