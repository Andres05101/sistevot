package com.solucionesvirtual.sistevoto.repository;

import com.solucionesvirtual.sistevoto.domain.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentoRepo extends JpaRepository<Documento, Long> {
    public Documento findByDocumento(long id);
    List<Documento> findByAsamblea(int asamblea);
}