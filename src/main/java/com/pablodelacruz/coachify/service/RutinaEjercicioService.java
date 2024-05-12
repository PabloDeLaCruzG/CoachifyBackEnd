package com.pablodelacruz.coachify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablodelacruz.coachify.model.RutinaEjercicio;
import com.pablodelacruz.coachify.repository.RutinaEjercicioRepository;

@Service
public class RutinaEjercicioService {

    @Autowired
    private RutinaEjercicioRepository rutinaEjercicioRepository;

    public List<RutinaEjercicio> getAllRutinaEjercicios() {
        return rutinaEjercicioRepository.findAll();
    }

    public Optional<RutinaEjercicio> getRutinaEjercicioById(Long id) {
        return rutinaEjercicioRepository.findById(id);
    }

    public RutinaEjercicio createRutinaEjercicio(RutinaEjercicio rutinaEjercicio) {
        return rutinaEjercicioRepository.save(rutinaEjercicio);
    }

    public RutinaEjercicio updateRutinaEjercicio(Long id, RutinaEjercicio rutinaEjercicioDetails) {
        Optional<RutinaEjercicio> optionalRutinaEjercicio = rutinaEjercicioRepository.findById(id);
        if (optionalRutinaEjercicio.isPresent()) {
            RutinaEjercicio rutinaEjercicio = optionalRutinaEjercicio.get();
            rutinaEjercicio.setRutinaID(rutinaEjercicioDetails.getRutinaID());
            rutinaEjercicio.setImg(rutinaEjercicioDetails.getImg());
            rutinaEjercicio.setDiaSemana(rutinaEjercicioDetails.getDiaSemana());
            rutinaEjercicio.setNombre(rutinaEjercicioDetails.getNombre());
            rutinaEjercicio.setSeries(rutinaEjercicioDetails.getSeries());
            rutinaEjercicio.setRepeticiones(rutinaEjercicioDetails.getRepeticiones());
            return rutinaEjercicioRepository.save(rutinaEjercicio);
        } else {
            // Manejo de error si la relación rutina-ejercicio no existe
            return null;
        }
    }

    public void deleteRutinaEjercicio(Long id) {
        rutinaEjercicioRepository.deleteById(id);
    }

    public List<RutinaEjercicio> getEjerciciosByRutinaID(Long rutinaID) {
        return rutinaEjercicioRepository.findByRutinaID_RutinaID(rutinaID);
    }
}
