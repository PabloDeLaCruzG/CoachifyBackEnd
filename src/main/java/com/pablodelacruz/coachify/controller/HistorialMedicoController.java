package com.pablodelacruz.coachify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pablodelacruz.coachify.model.HistorialMedico;
import com.pablodelacruz.coachify.service.HistorialMedicoService;

@RestController
@RequestMapping("/api/historialMedico")
public class HistorialMedicoController {
    
    @Autowired
    HistorialMedicoService historialMedicoService;

    @GetMapping()
    public ResponseEntity<?> getHistorialesMedicos() {
        try {
            return new ResponseEntity<>(historialMedicoService.getAllHistorialMedico(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{historialMedicoID}")
    public ResponseEntity<?> getHistorialMedicoById(@PathVariable("historialMedicoID") Long id) {
        try {
            return new ResponseEntity<>(historialMedicoService.getHistorialMedicoById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createHistorialMedico(@RequestBody HistorialMedico historialMedico) {
        try {
            return new ResponseEntity<>(historialMedicoService.createHistorialMedico(historialMedico), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{historialMedicoID}")
    public ResponseEntity<?> updateHistorialMedico(@PathVariable("historialMedicoID") Long id, @RequestBody HistorialMedico historialMedicoDetails) {
        try {
            return new ResponseEntity<>(historialMedicoService.updateHistorialMedico(id, historialMedicoDetails), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{historialMedicoID}")
    public ResponseEntity<?> deleteHistorialMedico(@PathVariable("historialMedicoID") Long id) {
        try {
            historialMedicoService.deleteHistorialMedico(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
