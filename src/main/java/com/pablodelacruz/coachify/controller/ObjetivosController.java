package com.pablodelacruz.coachify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pablodelacruz.coachify.model.Objetivos;
import com.pablodelacruz.coachify.service.ObjetivosService;

@RestController
@RequestMapping("/api/objetivos")
public class ObjetivosController {
    
    @Autowired
    ObjetivosService objetivosService;

    @GetMapping()
    public ResponseEntity<?> getAllObjetivos() {
        try {
            return new ResponseEntity<>(objetivosService.getAllObjetivos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{objetivoID}")
    public ResponseEntity<?> getObjetivoById(@PathVariable("objetivoID") Long id) {
        try {
            return new ResponseEntity<>(objetivosService.getObjetivosById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createObjetivo(@RequestBody Objetivos objetivo) {
        try {
            return new ResponseEntity<>(objetivosService.createObjetivos(objetivo), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{objetivoID}")
    public ResponseEntity<?> updateObjetivo(@PathVariable("objetivoID") Long id, @RequestBody Objetivos objetivoDetails) {
        try {
            return new ResponseEntity<>(objetivosService.updateObjetivos(id, objetivoDetails), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{objetivoID}")
    public ResponseEntity<?> deleteObjetivo(@PathVariable("objetivoID") Long id) {
        try {
            objetivosService.deleteObjetivos(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cliente/{clienteID}")
    public ResponseEntity<?> getObjetivosByClienteId(@PathVariable("clienteID") Long clienteID) {
        try {
            return new ResponseEntity<>(objetivosService.getObjetivosByClienteId(clienteID), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
