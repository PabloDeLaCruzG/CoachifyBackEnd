package com.pablodelacruz.coachify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pablodelacruz.coachify.model.Usuario;
import com.pablodelacruz.coachify.service.UsuarioService;

/**
 * Controller for handling requests related to Usuario objects.
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService; // Service used to interact with the Usuario objects in the database.

    /**
     * Get all Usuario objects.
     * @return ResponseEntity with the list of Usuario objects or an error message.
     */
    @GetMapping()
    public ResponseEntity<?> getUsuarios() {
        try {
            return new ResponseEntity<>(usuarioService.getAllUsuarios(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get a Usuario object by its ID.
     * @param id ID of the Usuario object to retrieve.
     * @return ResponseEntity with the Usuario object or an error message.
     */
    @GetMapping("/{usuarioID}")
    public ResponseEntity<?> getUsuario(@PathVariable("usuarioID") Long id) {
        try {
            return new ResponseEntity<>(usuarioService.getUsuarioById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Create a new Usuario object.
     * @param usuario Usuario object to create.
     * @return ResponseEntity with the created Usuario object or an error message.
     */
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Usuario usuario) {
        try {
            return new ResponseEntity<>(usuarioService.createUsuario(usuario), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update a Usuario object.
     * @param id ID of the Usuario object to update.
     * @param usuarioDetails New data for the Usuario object.
     * @return ResponseEntity with the updated Usuario object or an error message.
     */
    @PutMapping("/{usuarioID}")
    public ResponseEntity<?> update(@PathVariable("usuarioID") Long id, @RequestBody Usuario usuarioDetails) {
        try {
            return new ResponseEntity<>(usuarioService.updateUsuario(id, usuarioDetails), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete a Usuario object by its ID.
     * @param id ID of the Usuario object to delete.
     * @return ResponseEntity with an empty body or an error message.
     */
    @DeleteMapping("/{usuarioID}")
    public ResponseEntity<?> delete(@PathVariable("usuarioID") Long id) {
        try {
            usuarioService.deleteUsuario(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
