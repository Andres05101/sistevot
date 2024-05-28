package com.solucionesvirtual.sistevoto.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="pregunta")
public class Pregunta {
    @Id
    @Column(name="id_pregunta")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer pregunta;
    @Basic
    Integer asamblea;
    String enunciado;

    LocalDateTime fechahora;


    public Pregunta() {
    }

    public Pregunta(Integer pregunta, Integer asamblea, String enunciado , LocalDateTime fechahora) {
        this.pregunta = pregunta;
        this.asamblea = asamblea;
        this.enunciado = enunciado;
        this.fechahora = fechahora;
    }

    public Integer getPregunta() {
        return pregunta;
    }

    public void setPregunta(Integer pregunta) {
        this.pregunta = pregunta;
    }

    public Integer getAsamblea() {
        return asamblea;
    }

    public void setAsamblea(Integer id_asamblea) {
        this.asamblea = id_asamblea;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public LocalDateTime getFechahora() {
        return fechahora;
    }

    public void setFechahora(LocalDateTime fechahora) {
        this.fechahora = fechahora;
    }
}