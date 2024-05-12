package com.pablodelacruz.coachify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pablodelacruz.coachify.model.RutinaEjercicio;
import com.pablodelacruz.coachify.service.RutinaEjercicioService;

@RestController
@RequestMapping("/api/ejercicios")
public class RutinaEjercicioController {
    
    @Autowired
    RutinaEjercicioService rutinaEjercicioService;

    @GetMapping()
    public ResponseEntity<?> getAllRutinaEjercicios() {
        try {
            return new ResponseEntity<>(rutinaEjercicioService.getAllRutinaEjercicios(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{rutinaEjercicioID}")
    public ResponseEntity<?> getRutinaEjercicioById(@PathVariable("rutinaEjercicioID") Long id) {
        try {
            return new ResponseEntity<>(rutinaEjercicioService.getRutinaEjercicioById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createRutinaEjercicio(@RequestBody RutinaEjercicio rutinaEjercicio) {
        try {
            return new ResponseEntity<>(rutinaEjercicioService.createRutinaEjercicio(rutinaEjercicio), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{rutinaEjercicioID}")
    public ResponseEntity<?> updateRutinaEjercicio(@PathVariable("rutinaEjercicioID") Long id, @RequestBody RutinaEjercicio rutinaEjercicioDetails) {
        try {
            return new ResponseEntity<>(rutinaEjercicioService.updateRutinaEjercicio(id, rutinaEjercicioDetails), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{rutinaEjercicioID}")
    public ResponseEntity<?> deleteRutinaEjercicio(@PathVariable("rutinaEjercicioID") Long id) {
        try {
            rutinaEjercicioService.deleteRutinaEjercicio(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
