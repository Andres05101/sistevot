package com.solucionesvirtual.sistevoto.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="propietario")
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_propietario")
    private Long propietario;
    @Basic
    private String nombre;
    private Long cedula;
}