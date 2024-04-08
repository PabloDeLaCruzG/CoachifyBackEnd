package com.pablodelacruz.coachify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablodelacruz.coachify.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
