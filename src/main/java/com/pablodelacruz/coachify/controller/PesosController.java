package com.pablodelacruz.coachify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablodelacruz.coachify.model.Cliente;
import com.pablodelacruz.coachify.model.Pesos;
import com.pablodelacruz.coachify.service.ClienteService;
import com.pablodelacruz.coachify.service.PesosService;

@RestController
@RequestMapping("/api/pesos")
public class PesosController {
    
    @Autowired
    PesosService pesosService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping()
    public ResponseEntity<?> getPesos() {
        try {
            return new ResponseEntity<>(pesosService.getPesos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{pesoID}")
    public ResponseEntity<?> getPesoById(@PathVariable("pesoID") Long id) {
        try {
            return new ResponseEntity<>(pesosService.getPeso(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createPeso(@RequestBody Pesos peso) {
        try {
            return new ResponseEntity<>(pesosService.save(peso), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{pesoID}")
    public ResponseEntity<?> updatePeso(@PathVariable("pesoID") Long id, @RequestBody Pesos pesoDetails) {
        try {
            return new ResponseEntity<>(pesosService.updatePeso(id, pesoDetails), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{pesoID}")
    public ResponseEntity<?> deletePeso(@PathVariable("pesoID") Long id) {
        try {
            pesosService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cliente/{clienteID}")
    public ResponseEntity<?> getPesosByClienteID(@PathVariable("clienteID") Long clienteID) {
        Cliente cliente = clienteService.getCliente(clienteID).orElse(null);
        if (cliente != null) {
            List<Pesos> pesos = pesosService.getPesosByClienteID(cliente);
            return new ResponseEntity<>(pesos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
