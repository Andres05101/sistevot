package com.solucionesvirtual.sistevoto.service;

import com.solucionesvirtual.sistevoto.domain.Tema;
import com.solucionesvirtual.sistevoto.repository.TemaRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TemaService {
    private TemaRepo temaRepo;

    public void crearTema(Tema tema) {
        temaRepo.save(tema);
    }
    public List<Tema>  getTemaPorAsamblea(Integer id_asamblea){
        return temaRepo.findByAsamblea(id_asamblea);
    }

}