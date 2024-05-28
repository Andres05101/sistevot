package com.solucionesvirtual.sistevoto.service;

import com.solucionesvirtual.sistevoto.domain.Voto;
import com.solucionesvirtual.sistevoto.repository.VotoRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class VotoServices {
    private VotoRepo votoRepo;
    private RespuestaService respuestaService;

    public void RegistrarVoto(Voto voto) {
        votoRepo.save(voto);
    }

    public Map<String, Long> contarVotosPorRespuesta(Integer pregunta) {
        List<Object[]> resultados = votoRepo.contarVotosPorRespuesta(pregunta);
        Map<String, Long> conteoVotos = new HashMap<>();
        for (Object[] resultado : resultados) {
            String enunciado = respuestaService.buscarTextoRespuestaPorId((Integer) resultado[0]);
            Long conteo = (Long) resultado[1];
            conteoVotos.put(enunciado, conteo);
        }
        return conteoVotos;
    }

}