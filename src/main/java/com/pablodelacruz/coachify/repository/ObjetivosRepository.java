package com.pablodelacruz.coachify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablodelacruz.coachify.model.Objetivos;

public interface ObjetivosRepository extends JpaRepository<Objetivos, Long> {
    
    Objetivos findByCliente_clienteID(Long clienteID);
}
