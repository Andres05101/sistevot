package com.solucionesvirtual.sistevoto.repository;

import com.solucionesvirtual.sistevoto.domain.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemaRepo extends JpaRepository<Tema, Long> {
    public List<Tema> findByAsamblea(Integer asamblea);
}