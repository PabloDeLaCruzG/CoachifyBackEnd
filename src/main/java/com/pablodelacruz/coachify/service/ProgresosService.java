package com.pablodelacruz.coachify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablodelacruz.coachify.model.Progresos;
import com.pablodelacruz.coachify.repository.ProgresosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProgresosService {

    @Autowired
    private ProgresosRepository progresosRepository;

    public List<Progresos> getAllProgresos() {
        return progresosRepository.findAll();
    }

    public Optional<Progresos> getProgresosById(Long id) {
        return progresosRepository.findById(id);
    }

    public Progresos createProgresos(Progresos progresos) {
        return progresosRepository.save(progresos);
    }

    public Progresos updateProgresos(Long id, Progresos progresosDetails) {
        Optional<Progresos> optionalProgresos = progresosRepository.findById(id);
        if (optionalProgresos.isPresent()) {
            Progresos progresos = optionalProgresos.get();
            progresos.setFecha(progresosDetails.getFecha());
            progresos.setPeso(progresosDetails.getPeso());
            progresos.setImc(progresosDetails.getImc());
            progresos.setPorGraCor(progresosDetails.getPorGraCor());
            progresos.setOtrasMedidas(progresosDetails.getOtrasMedidas());
            progresos.setCliente(progresosDetails.getCliente());
            return progresosRepository.save(progresos);
        } else {
            // Manejo de error si el progreso no existe
            return null;
        }
    }

    public void deleteProgresos(Long id) {
        progresosRepository.deleteById(id);
    }
}
