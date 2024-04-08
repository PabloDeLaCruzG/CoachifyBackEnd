package com.pablodelacruz.coachify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablodelacruz.coachify.model.ComposicionCorporal;
import com.pablodelacruz.coachify.repository.ComposicionCorporalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ComposicionCorporalService {

    @Autowired
    private ComposicionCorporalRepository composicionCorporalRepository;

    public List<ComposicionCorporal> getAllComposicionCorporal() {
        return composicionCorporalRepository.findAll();
    }

    public Optional<ComposicionCorporal> getComposicionCorporalById(Long id) {
        return composicionCorporalRepository.findById(id);
    }

    public ComposicionCorporal createComposicionCorporal(ComposicionCorporal composicionCorporal) {
        return composicionCorporalRepository.save(composicionCorporal);
    }

    public ComposicionCorporal updateComposicionCorporal(Long id, ComposicionCorporal composicionCorporalDetails) {
        Optional<ComposicionCorporal> optionalComposicionCorporal = composicionCorporalRepository.findById(id);
        if (optionalComposicionCorporal.isPresent()) {
            ComposicionCorporal composicionCorporal = optionalComposicionCorporal.get();
            composicionCorporal.setPeso(composicionCorporalDetails.getPeso());
            composicionCorporal.setAltura(composicionCorporalDetails.getAltura());
            composicionCorporal.setImc(composicionCorporalDetails.getImc());
            composicionCorporal.setPorGraCor(composicionCorporalDetails.getPorGraCor());
            composicionCorporal.setCirCintura(composicionCorporalDetails.getCirCintura());
            composicionCorporal.setCirCadera(composicionCorporalDetails.getCirCadera());
            composicionCorporal.setCliente(composicionCorporalDetails.getCliente());
            return composicionCorporalRepository.save(composicionCorporal);
        } else {
            // Manejo de error si la composición corporal no existe
            return null;
        }
    }

    public void deleteComposicionCorporal(Long id) {
        composicionCorporalRepository.deleteById(id);
    }
}
