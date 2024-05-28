package com.solucionesvirtual.sistevoto.repository;

import com.solucionesvirtual.sistevoto.domain.Asamblea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
@Repository
public interface AsambleaRepo extends JpaRepository<Asamblea, Integer> {
    Optional<Asamblea> findByFecha(LocalDate fecha);

}