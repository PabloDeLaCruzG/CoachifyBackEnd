package com.pablodelacruz.coachify.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    
    String username;
    String password;
    String mail;
    String nombreCompleto;
    String telefono;
    String pais;

}
