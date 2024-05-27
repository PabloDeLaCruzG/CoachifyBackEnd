package com.pablodelacruz.coachify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pablodelacruz.coachify.model.Calendario;
import com.pablodelacruz.coachify.service.CalendarioService;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioController {

    @Autowired
    CalendarioService calendarioService; 

    @GetMapping()
    public ResponseEntity<?> getAllCalendarios() {
        try {
            return new ResponseEntity<>(calendarioService.getAllCalendarios(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{calendarioID}")
    public ResponseEntity<?> getCalendarioById(@PathVariable("calendarioID") Long id) {
        try {
            return new ResponseEntity<>(calendarioService.getCalendarioById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createCalendario(@RequestBody Calendario calendario) {
        try {
            return new ResponseEntity<>(calendarioService.createCalendario(calendario), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{calendarioID}")
    public ResponseEntity<?> updateCalendario(@PathVariable("calendarioID") String id,
            @RequestBody Calendario calendarioDetails) {
        try {
            Long calendarioId = Long.parseLong(id); // Convertir a Long
            return new ResponseEntity<>(calendarioService.updateCalendario(calendarioId, calendarioDetails),
                    HttpStatus.OK);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("ID de calendario no válido: " + id, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{calendarioID}")
    public ResponseEntity<?> deleteCalendario(@PathVariable("calendarioID") Long id) {
        try {
            calendarioService.deleteCalendario(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
