package com.solucionesvirtual.sistevoto.domain;

import jakarta.persistence.*;


@Entity()
@Table(name="tema")
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_tema")
    Long tema;
    @Basic
    Integer asamblea;
    String texto_tema;

    public Tema() {
    }

    public Tema(Long tema, Integer asamblea, String texto_tema) {
        this.tema = tema;
        this.asamblea = asamblea;
        this.texto_tema = texto_tema;
    }

    public Long getTema() {
        return tema;
    }

    public void setTema(Long tema) {
        this.tema = tema;
    }

    public Integer getAsamblea() {
        return asamblea;
    }

    public void setAsamblea(Integer asamblea) {
        this.asamblea = asamblea;
    }

    public String getTexto_tema() {
        return texto_tema;
    }

    public void setTexto_tema(String texto_tema) {
        this.texto_tema = texto_tema;
    }
}