package com.solucionesvirtual.sistevoto.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="asamblea")
public class Asamblea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_asamblea")
    Integer asamblea;
    @Basic
    LocalDate fecha;
    public Asamblea() {
    }
    public Asamblea(Integer asamblea, LocalDate fecha) {
        this.asamblea = asamblea;
        this.fecha = fecha;
    }
    public int getAsamblea() {
        return asamblea;
    }
    public void setAsamblea(Integer asamblea) {
        this.asamblea = asamblea;
    }
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}