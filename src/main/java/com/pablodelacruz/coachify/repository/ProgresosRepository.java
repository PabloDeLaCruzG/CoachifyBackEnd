package com.pablodelacruz.coachify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablodelacruz.coachify.model.Progresos;
public interface ProgresosRepository extends JpaRepository<Progresos, Long>{
    
}
