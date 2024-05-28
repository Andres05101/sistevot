package com.solucionesvirtual.sistevoto.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
public class AsambleaCopropiedadId implements Serializable {

    private int asamblea;
    private String copropiedad;


    public AsambleaCopropiedadId() {

    }
}