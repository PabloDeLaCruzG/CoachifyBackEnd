package com.pablodelacruz.coachify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablodelacruz.coachify.model.Ejercicio;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Long> {
    
}
