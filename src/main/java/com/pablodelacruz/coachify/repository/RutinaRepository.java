package com.pablodelacruz.coachify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablodelacruz.coachify.model.Rutina;

public interface RutinaRepository extends JpaRepository<Rutina, Long> {
    
}
