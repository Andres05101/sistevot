package com.solucionesvirtual.sistevoto.repository;

import com.solucionesvirtual.sistevoto.domain.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PreguntaRepo extends JpaRepository<Pregunta, Integer> {

    @Query(value = "SELECT p FROM Pregunta p WHERE p.asamblea = (SELECT MAX(a.asamblea) FROM Asamblea a)")
    List<Pregunta> findByAsamblea();

    Pregunta findByPregunta(Integer preguntaId);
}