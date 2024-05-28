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
    
    public Rutina updateRutina(Long id, Rutina rutinaDetails) {
        Optional<Rutina> optionalRutina = rutinaRepository.findById(id);
        if (optionalRutina.isPresent()) {
            Rutina rutina = optionalRutina.get();
            rutina.setNombre(rutinaDetails.getNombre());
            rutina.setFechaInicio(rutinaDetails.getFechaInicio());
            rutina.setFechaFin(rutinaDetails.getFechaFin());
            rutina.setNotas(rutinaDetails.getNotas());
            rutina.setClienteID(rutinaDetails.getClienteID());
            return rutinaRepository.save(rutina);
        } else {
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
