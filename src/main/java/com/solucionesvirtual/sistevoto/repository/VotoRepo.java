package com.solucionesvirtual.sistevoto.repository;

import com.solucionesvirtual.sistevoto.domain.Pregunta;
import com.solucionesvirtual.sistevoto.domain.Respuesta;
import com.solucionesvirtual.sistevoto.domain.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VotoRepo extends JpaRepository<Voto, Integer> {
    @Query("SELECT v.respuesta, COUNT(v) FROM Voto v WHERE v.pregunta = :pregunta GROUP BY v.respuesta")
    List<Object[]> contarVotosPorRespuesta(@Param("pregunta") Integer pregunta);
}