package com.pablodelacruz.coachify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pablodelacruz.coachify.model.ComposicionCorporal;
import com.pablodelacruz.coachify.service.ComposicionCorporalService;

@RestController
@RequestMapping("/api/composicioncorporal")
public class ComposicionCorporalController {
    
    @Autowired
    ComposicionCorporalService composicionCorporalService;

    @GetMapping()
    public ResponseEntity<?> getAllComposicionCorporal() {
        try {
            return new ResponseEntity<>(composicionCorporalService.getAllComposicionCorporal(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{composicioncorporalID}")
    public ResponseEntity<?> getComposicionCorporalById(@PathVariable("composicioncorporalID") Long id) {
        try {
            return new ResponseEntity<>(composicionCorporalService.getComposicionCorporalById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{composicioncorporalID}")
    public ResponseEntity<?> updateComposicionCorporal(@PathVariable("composicioncorporalID") Long id, @RequestBody ComposicionCorporal composicionCorporalDetails) {
        try {
            return new ResponseEntity<>(composicionCorporalService.updateComposicionCorporal(id, composicionCorporalDetails), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{composicioncorporalID}")
    public ResponseEntity<?> deleteComposicionCorporal(@PathVariable("composicioncorporalID") Long id) {
        try {
            composicionCorporalService.deleteComposicionCorporal(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
