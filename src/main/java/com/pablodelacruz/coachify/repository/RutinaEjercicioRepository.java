package com.pablodelacruz.coachify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablodelacruz.coachify.model.RutinaEjercicio;

public interface RutinaEjercicioRepository extends JpaRepository<RutinaEjercicio, Long>{

    List<RutinaEjercicio> findByRutinaID_RutinaID(Long rutinaID);
    
}
