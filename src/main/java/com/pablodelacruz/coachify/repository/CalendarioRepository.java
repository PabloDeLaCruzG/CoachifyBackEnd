package com.pablodelacruz.coachify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablodelacruz.coachify.model.Calendario;

public interface CalendarioRepository extends JpaRepository<Calendario, Long>{
    
}
