package com.solucionesvirtual.sistevoto.domain;

import jakarta.persistence.*;

@Entity
@Table(name="respuesta")
public class Respuesta {
    @Id
    @Column(name="id_respuesta")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idRespuesta;
    Integer pregunta;
    String opcion;

    public Respuesta() {
    }

    public Respuesta(Long idRespuesta, Integer pregunta, String opcion) {
        this.idRespuesta = idRespuesta;
        this.pregunta = pregunta;
        this.opcion = opcion;
    }

    public Long getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Long idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Integer getPregunta() {
        return pregunta;
    }

    public void setPregunta(Integer id_pregunta) {
        this.pregunta = id_pregunta;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
}