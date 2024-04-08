package com.pablodelacruz.coachify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablodelacruz.coachify.model.HistorialMedico;

public interface HistorialMedicoRepositoy extends JpaRepository<HistorialMedico, Long>{
    
}
