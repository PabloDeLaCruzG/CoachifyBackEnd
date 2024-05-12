package com.pablodelacruz.coachify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablodelacruz.coachify.model.Cliente;
import com.pablodelacruz.coachify.model.Rutina;
import com.pablodelacruz.coachify.repository.RutinaRepository;

@Service
public class RutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;

    public List<Rutina> getAllRutinas() {
        return rutinaRepository.findAll();
    }

    public Optional<Rutina> getRutinaById(Long id) {
        return rutinaRepository.findById(id);
    }

    public Rutina createRutina(Rutina rutina) {
        return rutinaRepository.save(rutina);
    }

    /**
     * This method updates a Rutina (workout) based on the provided ID and Rutina details.
     * If a Rutina with the provided ID exists, it updates the fields: fechaInicio, fechaFin, notas and cliente
     * with the values from the provided Rutina details.
     * If a Rutina with the provided ID does not exist, it returns null.
     *
     * @param id The ID of the Rutina to update
     * @param rutinaDetails The new details for the Rutina
     * @return The updated Rutina, or null if the Rutina does not exist
     */
    public Rutina updateRutina(Long id, Rutina rutinaDetails) {
        // Find the Rutina with the provided ID
        Optional<Rutina> optionalRutina = rutinaRepository.findById(id);
        // If the Rutina exists
        if (optionalRutina.isPresent()) {
            // Get the Rutina
            Rutina rutina = optionalRutina.get();
            // Update the fields with the new details
            rutina.setNombre(rutinaDetails.getNombre());
            rutina.setFechaInicio(rutinaDetails.getFechaInicio());
            rutina.setFechaFin(rutinaDetails.getFechaFin());
            rutina.setNotas(rutinaDetails.getNotas());
            rutina.setClienteID(rutinaDetails.getClienteID());
            // Save the updated Rutina and return it
            return rutinaRepository.save(rutina);
        } else {
            // If the Rutina does not exist, return null
            return null;
        }
    }

    public void deleteRutina(Long id) {
        rutinaRepository.deleteById(id);
    }

    public List<Rutina> getRutinasByClienteID(Cliente clienteID) {
        return rutinaRepository.findAllByClienteID(clienteID);
    }
}
