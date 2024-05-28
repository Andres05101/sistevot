package com.solucionesvirtual.sistevoto.service;

import com.solucionesvirtual.sistevoto.domain.Pregunta;
import com.solucionesvirtual.sistevoto.repository.PreguntaRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PreguntaService {
    private PreguntaRepo preguntaRepo;


    public void crearPregunta(Pregunta pregunta) {
        preguntaRepo.save(pregunta);
    }

    public Pregunta getPreguntaPorId(Integer id) {
        return preguntaRepo.findByPregunta(id);
    }

    public List<Pregunta> getPregunta() {
        return preguntaRepo.findByAsamblea();
    }
}