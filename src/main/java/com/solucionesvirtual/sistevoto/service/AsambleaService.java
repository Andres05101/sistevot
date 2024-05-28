package com.solucionesvirtual.sistevoto.service;

import com.solucionesvirtual.sistevoto.domain.Asamblea;
import com.solucionesvirtual.sistevoto.repository.AsambleaRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AsambleaService {
    private AsambleaRepo asambleaRepo;

    public Optional<Asamblea> getAsambleaHoy(){
        LocalDate hoy = LocalDate.now();
        Optional<Asamblea> asamblea=asambleaRepo.findByFecha(hoy);
        return asamblea;
    }
    public void crearAsamblea(Asamblea asamblea){
        asambleaRepo.save(asamblea);
    }

    public List<Asamblea> getAsambleas(){
        return asambleaRepo.findAll();
    }

}