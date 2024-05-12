package com.pablodelacruz.coachify.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pablodelacruz.coachify.model.Cliente;
import com.pablodelacruz.coachify.model.Pesos;

public interface PesosRepository extends JpaRepository<Pesos, Long> {
    
    List<Pesos> findAllByClienteID(Cliente clienteId);
}
