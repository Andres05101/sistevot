package com.solucionesvirtual.sistevoto.controller;

import com.solucionesvirtual.sistevoto.domain.Pregunta;
import com.solucionesvirtual.sistevoto.service.*;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class HistorialController {
    private final PreguntaService preguntaService;
    private final VotoServices votoServices;
    private final RespuestaService respuestaService;

    @GetMapping("/historial")
    public String mostrarListaPreguntas(Model model) {
        List<Pregunta> preguntas = preguntaService.getPregunta();
        model.addAttribute("preguntas", preguntas);
        return "historial";
    }

    @GetMapping("/resultados/{id}")
    public String mostrarResultados(@PathVariable("id") Integer id, Model model) {
        Pregunta pregunta = preguntaService.getPreguntaPorId(id);
        LocalDateTime ahora = LocalDateTime.now();
        if (pregunta.getFechahora().isBefore(ahora)){
            model.addAttribute("tiempo", true);
            String enunciado = pregunta.getEnunciado();
            model.addAttribute("enunciado", enunciado);
            Map<String, Long> votos = votoServices.contarVotosPorRespuesta(id);
            model.addAttribute("votos", votos);
        }
        else{
            model.addAttribute("tiempo", false);
        }

        return "resultados";
    }
}