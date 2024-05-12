package com.pablodelacruz.coachify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pablodelacruz.coachify.model.Cliente;
import com.pablodelacruz.coachify.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    

    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public ResponseEntity<?> getClientes() {
        try {
            return new ResponseEntity<>(clienteService.getClientes(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @GetMapping("/{clienteID}")
    public ResponseEntity<?> getClienteById(@PathVariable("clienteID") Long id) {
        try {
            return new ResponseEntity<>(clienteService.getCliente(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createCliente(@RequestBody Cliente cliente) {
        try {
            return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{clienteID}")
    public ResponseEntity<?> updateCliente(@PathVariable("clienteID") Long id, @RequestBody Cliente clienteDetails) {
        try {
            return new ResponseEntity<>(clienteService.updateCliente(id, clienteDetails), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{clienteID}")
    public ResponseEntity<?> deleteCliente(@PathVariable("clienteID") Long id) {
        try {
            clienteService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
