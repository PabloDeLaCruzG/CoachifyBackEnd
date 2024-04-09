package com.pablodelacruz.coachify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pablodelacruz.coachify.model.Ejercicio;
import com.pablodelacruz.coachify.service.EjercicioService;

@RestController
@RequestMapping("/api/ejercicios")
public class EjercicioController {
    

    @Autowired
    EjercicioService ejercicioService;
    
    @GetMapping()
    public ResponseEntity<?> getAllEjercicios() {
        try {
            return new ResponseEntity<>(ejercicioService.getAllEjercicios(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{ejercicioID}")
    public ResponseEntity<?> getEjercicioById(@PathVariable("ejercicioID") Long id) {
        try {
            return new ResponseEntity<>(ejercicioService.getEjercicioById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createEjercicio(@RequestBody Ejercicio ejercicio) {
        try {
            return new ResponseEntity<>(ejercicioService.createEjercicio(ejercicio), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{ejercicioID}")
    public ResponseEntity<?> updateEjercicio(@PathVariable("ejercicioID") Long id, @RequestBody Ejercicio ejercicioDetails) {
        try {
            return new ResponseEntity<>(ejercicioService.updateEjercicio(id, ejercicioDetails), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{ejercicioID}")
    public ResponseEntity<?> deleteEjercicio(@PathVariable("ejercicioID") Long id) {
        try {
            ejercicioService.deleteEjercicio(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
