package com.solucionesvirtual.sistevoto.service;

import com.solucionesvirtual.sistevoto.domain.Respuesta;
import com.solucionesvirtual.sistevoto.repository.RespuestaRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RespuestaService {
    private RespuestaRepo respuestaRepo;

    public void crearRespuesta(Respuesta respuesta) {
        respuestaRepo.save(respuesta);
    }

    public List<Respuesta> listarRespuestas(Integer pregunta) {
        return respuestaRepo.findByPregunta(pregunta);
    }

    public String buscarTextoRespuestaPorId(Integer id_integer) {
        Long id = id_integer.longValue();
        Respuesta respuesta = respuestaRepo.findByIdRespuesta(id);
        return respuesta.getOpcion();
    }
}