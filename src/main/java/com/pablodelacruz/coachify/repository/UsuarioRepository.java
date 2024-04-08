package com.pablodelacruz.coachify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablodelacruz.coachify.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
