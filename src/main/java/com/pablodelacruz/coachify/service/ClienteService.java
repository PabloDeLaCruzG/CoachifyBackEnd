package com.pablodelacruz.coachify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablodelacruz.coachify.repository.ClienteRepository;
import com.pablodelacruz.coachify.model.Cliente;

import java.util.*;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getCliente(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long id, Cliente clienteDetails) {
        return clienteRepository.findById(id)
                .map(existingCliente -> {
                    existingCliente.setNombreCompleto(clienteDetails.getNombreCompleto());
                    existingCliente.setFechaNacimiento(clienteDetails.getFechaNacimiento());
                    existingCliente.setMail(clienteDetails.getMail());
                    existingCliente.setGenero(clienteDetails.getGenero());
                    existingCliente.setTelefono(clienteDetails.getTelefono());
                    existingCliente.setDireccion(clienteDetails.getDireccion());
                    existingCliente.setImg(clienteDetails.getImg());
                    return clienteRepository.save(existingCliente);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

}
