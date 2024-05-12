package com.pablodelacruz.coachify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablodelacruz.coachify.model.Cliente;
import com.pablodelacruz.coachify.model.Pesos;
import com.pablodelacruz.coachify.repository.PesosRepository;

import java.util.*;

@Service
public class PesosService {
    
    @Autowired
    PesosRepository pesosRepository;

    public List<Pesos> getPesos() {
        return pesosRepository.findAll();
    }

    public Optional<Pesos> getPeso(Long id) {
        return pesosRepository.findById(id);
    }

    public Pesos save(Pesos peso) {
        return pesosRepository.save(peso);
    }

    public Pesos updatePeso(Long id, Pesos pesoDetails) {
        return pesosRepository.findById(id)
                .map(existingPeso -> {
                    existingPeso.setPeso(pesoDetails.getPeso());
                    existingPeso.setFecha(pesoDetails.getFecha());
                    return pesosRepository.save(existingPeso);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        pesosRepository.deleteById(id);
    }

    public List<Pesos> getPesosByClienteID(Cliente clienteID) {
        return pesosRepository.findAllByClienteID(clienteID);
    }
}
