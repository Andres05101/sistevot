package com.solucionesvirtual.sistevoto.repository;

import com.solucionesvirtual.sistevoto.domain.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespuestaRepo extends JpaRepository<Respuesta, Long> {
    public List<Respuesta> findByPregunta(Integer pregunta);

    public Respuesta findByIdRespuesta(Long idRespuesta);
}