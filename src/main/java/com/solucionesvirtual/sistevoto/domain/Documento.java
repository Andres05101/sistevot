package com.solucionesvirtual.sistevoto.domain;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table(name="documento")
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_documento")
    Long documento;
    @Basic
    Integer asamblea;
    String nombre;
    @Lob
    byte[] contenido;

    public Documento() {
    }

    public Documento(Long documento, Integer asamblea, byte[] contenido, String nombre) {
        this.documento = documento;
        this.asamblea = asamblea;
        this.contenido = contenido;
        this.nombre = nombre;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public Integer getAsamblea() {
        return asamblea;
    }

    public void setAsamblea(Integer asamblea) {
        this.asamblea = asamblea;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}