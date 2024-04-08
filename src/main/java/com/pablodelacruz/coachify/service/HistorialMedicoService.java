package com.pablodelacruz.coachify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablodelacruz.coachify.model.HistorialMedico;
import com.pablodelacruz.coachify.repository.HistorialMedicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialMedicoService {

    @Autowired
    private HistorialMedicoRepository historialMedicoRepository;

    public List<HistorialMedico> getAllHistorialMedico() {
        return historialMedicoRepository.findAll();
    }

    public Optional<HistorialMedico> getHistorialMedicoById(Long id) {
        return historialMedicoRepository.findById(id);
    }

    public HistorialMedico createHistorialMedico(HistorialMedico historialMedico) {
        return historialMedicoRepository.save(historialMedico);
    }

    public HistorialMedico updateHistorialMedico(Long id, HistorialMedico historialMedicoDetails) {
        Optional<HistorialMedico> optionalHistorialMedico = historialMedicoRepository.findById(id);
        if (optionalHistorialMedico.isPresent()) {
            HistorialMedico historialMedico = optionalHistorialMedico.get();
            historialMedico.setEnfermedades(historialMedicoDetails.getEnfermedades());
            historialMedico.setAlergias(historialMedicoDetails.getAlergias());
            historialMedico.setCondiciones(historialMedicoDetails.getCondiciones());
            historialMedico.setRestricciones(historialMedicoDetails.getRestricciones());
            historialMedico.setInformesMedicos(historialMedicoDetails.getInformesMedicos());
            historialMedico.setCliente(historialMedicoDetails.getCliente());
            return historialMedicoRepository.save(historialMedico);
        } else {
            // Manejo de error si el historial médico no existe
            return null;
        }
    }

    public void deleteHistorialMedico(Long id) {
        historialMedicoRepository.deleteById(id);
    }
}
