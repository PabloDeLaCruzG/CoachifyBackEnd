package com.pablodelacruz.coachify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablodelacruz.coachify.model.Ejercicio;
import com.pablodelacruz.coachify.repository.EjercicioRepository;

@Service
public class EjercicioService {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    public List<Ejercicio> getAllEjercicios() {
        return ejercicioRepository.findAll();
    }

    public Optional<Ejercicio> getEjercicioById(Long id) {
        return ejercicioRepository.findById(id);
    }

    public Ejercicio createEjercicio(Ejercicio ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }

    /**
     * Updates an existing Ejercicio with the details provided in the ejercicioDetails parameter.
     *
     * @param id The ID of the Ejercicio to be updated.
     * @param ejercicioDetails The new details for the Ejercicio.
     * @return The updated Ejercicio, or null if it does not exist.
     */
    public Ejercicio updateEjercicio(Long id, Ejercicio ejercicioDetails) {
        // Get the Ejercicio by its ID
        Optional<Ejercicio> optionalEjercicio = ejercicioRepository.findById(id);

        // If the Ejercicio exists, update its details and save it
        if (optionalEjercicio.isPresent()) {
            Ejercicio ejercicio = optionalEjercicio.get();

            // Update the Ejercicio's details
            ejercicio.setNombreEjercicio(ejercicioDetails.getNombreEjercicio());
            ejercicio.setDescripcion(ejercicioDetails.getDescripcion());
            ejercicio.setImagenEjercicio(ejercicioDetails.getImagenEjercicio());

            // Save the updated Ejercicio
            return ejercicioRepository.save(ejercicio);
        } else {
            // If the Ejercicio does not exist, return null
            return null;
        }
    }


    public void deleteEjercicio(Long id) {
        ejercicioRepository.deleteById(id);
    }
}
