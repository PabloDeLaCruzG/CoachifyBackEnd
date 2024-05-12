package com.pablodelacruz.coachify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablodelacruz.coachify.model.HistorialMedico;

import java.util.List;

public interface HistorialMedicoRepository extends JpaRepository<HistorialMedico, Long>{
    
    HistorialMedico findByCliente_clienteID(Long clienteID);

}
