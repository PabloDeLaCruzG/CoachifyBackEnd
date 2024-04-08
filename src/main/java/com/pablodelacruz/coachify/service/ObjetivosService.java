package com.pablodelacruz.coachify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablodelacruz.coachify.model.Objetivos;
import com.pablodelacruz.coachify.repository.ObjetivosRepository;

@Service
public class ObjetivosService {

    @Autowired
    private ObjetivosRepository objetivosRepository;

    public List<Objetivos> getAllObjetivos() {
        return objetivosRepository.findAll();
    }

    public Optional<Objetivos> getObjetivosById(Long id) {
        return objetivosRepository.findById(id);
    }

    public Objetivos createObjetivos(Objetivos objetivos) {
        return objetivosRepository.save(objetivos);
    }

    public Objetivos updateObjetivos(Long id, Objetivos objetivosDetails) {
        Optional<Objetivos> optionalObjetivos = objetivosRepository.findById(id);
        if (optionalObjetivos.isPresent()) {
            Objetivos objetivos = optionalObjetivos.get();
            objetivos.setObjCorPla(objetivosDetails.getObjCorPla());
            objetivos.setObjLarPla(objetivosDetails.getObjLarPla());
            objetivos.setObjGen(objetivosDetails.getObjGen());
            objetivos.setNivelInicial(objetivosDetails.getNivelInicial());
            objetivos.setPreferencias(objetivosDetails.getPreferencias());
            objetivos.setObservaciones(objetivosDetails.getObservaciones());
            objetivos.setCliente(objetivosDetails.getCliente());
            return objetivosRepository.save(objetivos);
        } else {
            // Manejo de error si los objetivos no existen
            return null;
        }
    }

    public void deleteObjetivos(Long id) {
        objetivosRepository.deleteById(id);
    }
}
