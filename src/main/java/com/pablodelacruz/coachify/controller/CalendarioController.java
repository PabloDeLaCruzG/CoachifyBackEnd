package com.pablodelacruz.coachify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pablodelacruz.coachify.model.Calendario;
import com.pablodelacruz.coachify.service.CalendarioService;

/**
 * REST controller for managing Calendario entities.
 */
@RestController
@RequestMapping("/api/calendario")
public class CalendarioController {

    @Autowired
    CalendarioService calendarioService; // Inject the CalendarioService

    /**
     * GET /api/calendario : get all Calendario entities.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of Calendario
     *         entities, or status 500 (Internal Server Error) with the error
     *         message.
     */
    @GetMapping()
    public ResponseEntity<?> getAllCalendarios() {
        try {
            return new ResponseEntity<>(calendarioService.getAllCalendarios(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * GET /api/calendario/{calendarioID} : get the "calendarioID" Calendario
     * entity.
     *
     * @param id the id of the Calendario entity
     * @return the ResponseEntity with status 200 (OK) and the Calendario entity, or
     *         status 404 (Not Found) if the Calendario is null, or status 500
     *         (Internal Server Error) with the error message.
     */
    @GetMapping("/{calendarioID}")
    public ResponseEntity<?> getCalendarioById(@PathVariable("calendarioID") Long id) {
        try {
            return new ResponseEntity<>(calendarioService.getCalendarioById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * POST /api/calendario : create a new Calendario entity.
     *
     * @param calendario the Calendario entity to create
     * @return the ResponseEntity with status 201 (Created) and the newly created
     *         Calendario entity, or status 400 (Bad Request) if the Calendario has
     *         already an ID, or status 500 (Internal Server Error) with the error
     *         message.
     */
    @PostMapping()
    public ResponseEntity<?> createCalendario(@RequestBody Calendario calendario) {
        try {
            return new ResponseEntity<>(calendarioService.createCalendario(calendario), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * PUT /api/calendario/{calendarioID} : updates the "calendarioID" Calendario
     * entity.
     *
     * @param id                the id of the Calendario entity to update
     * @param calendarioDetails the Calendario entity with the new data
     * @return the ResponseEntity with status 200 (OK) and the updated Calendario
     *         entity, or status 400 (Bad Request) if the Calendario entity is not
     *         valid, or status 500 (Internal Server Error) with the error message.
     */
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

    /**
     * DELETE /api/calendario/{calendarioID} : delete the "calendarioID" Calendario
     * entity.
     *
     * @param id the id of the Calendario entity to delete
     * @return the ResponseEntity with status 200 (OK) and the deleted Calendario
     *         entity, or status 400 (Bad Request) if the Calendario entity is not
     *         valid, or status 500 (Internal Server Error) with the error message.
     */
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
