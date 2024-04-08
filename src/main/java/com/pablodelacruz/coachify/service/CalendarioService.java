package com.pablodelacruz.coachify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pablodelacruz.coachify.model.Calendario;
import com.pablodelacruz.coachify.repository.CalendarioRepository;

@Service
public class CalendarioService {

    @Autowired
    private CalendarioRepository calendarioRepository;

    public List<Calendario> getAllCalendarios() {
        return calendarioRepository.findAll();
    }

    public Optional<Calendario> getCalendarioById(Long id) {
        return calendarioRepository.findById(id);
    }

    public Calendario createCalendario(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    public Calendario updateCalendario(Long id, Calendario calendarioDetails) {
        Optional<Calendario> optionalCalendario = calendarioRepository.findById(id);
        if (optionalCalendario.isPresent()) {
            Calendario calendario = optionalCalendario.get();
            calendario.setNombreCita(calendarioDetails.getNombreCita());
            calendario.setDescripcion(calendarioDetails.getDescripcion());
            calendario.setFechaInicio(calendarioDetails.getFechaInicio());
            calendario.setFechaFin(calendarioDetails.getFechaFin());
            calendario.setHoraInicio(calendarioDetails.getHoraInicio());
            calendario.setHoraFin(calendarioDetails.getHoraFin());
            calendario.setCliente(calendarioDetails.getCliente());
            return calendarioRepository.save(calendario);
        } else {
            // Manejo de error si el evento del calendario no existe
            return null;
        }
    }

    public void deleteCalendario(Long id) {
        calendarioRepository.deleteById(id);
    }
}
