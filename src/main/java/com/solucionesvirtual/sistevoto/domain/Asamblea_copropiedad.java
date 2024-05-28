package com.solucionesvirtual.sistevoto.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@IdClass(AsambleaCopropiedadId.class)
@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name="asamblea_copropiedad")
public class Asamblea_copropiedad {
    @Id
    @Column(name = "id_asamblea")
    private int asamblea;
    @Id
    @Column(name = "id_copropiedad")
    private String copropiedad;

    public Asamblea_copropiedad() {

    }
}