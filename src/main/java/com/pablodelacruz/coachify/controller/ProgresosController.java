package com.pablodelacruz.coachify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pablodelacruz.coachify.model.Progresos;
import com.pablodelacruz.coachify.service.ProgresosService;

@RestController
@RequestMapping("/api/progresos")
public class ProgresosController {
    
    @Autowired
    ProgresosService progresosService;

    @GetMapping()
    public ResponseEntity<?> getAllProgresos() {
        try {
            return new ResponseEntity<>(progresosService.getAllProgresos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{progresosID}")
    public ResponseEntity<?> getProgresosById(@PathVariable("progresosID") Long id) {
        try {
            return new ResponseEntity<>(progresosService.getProgresosById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createProgresos(@RequestBody Progresos progresos) {
        try {
            return new ResponseEntity<>(progresosService.createProgresos(progresos), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{progresosID}")
    public ResponseEntity<?> updateProgresos(@PathVariable("progresosID") Long id, @RequestBody Progresos progresosDetails) {
        try {
            return new ResponseEntity<>(progresosService.updateProgresos(id, progresosDetails), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{progresosID}")
    public ResponseEntity<?> deleteProgresos(@PathVariable("progresosID") Long id) {
        try {
            progresosService.deleteProgresos(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
