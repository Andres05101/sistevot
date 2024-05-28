package com.solucionesvirtual.sistevoto.model;

import com.solucionesvirtual.sistevoto.domain.Asamblea;
import com.solucionesvirtual.sistevoto.service.AsambleaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class ObtenerDatos {
    private final AsambleaService asambleaService;

    public Integer asambleaHoy(){
        Optional<Asamblea> asamblea = asambleaService.getAsambleaHoy();
        Integer asambleaId;
        if(asamblea.isPresent()){
            Asamblea asambleaGetId = asamblea.get();
            asambleaId = asambleaGetId.getAsamblea();
        }else {
            asambleaId = 0;
        }

        return asambleaId;
    }

}