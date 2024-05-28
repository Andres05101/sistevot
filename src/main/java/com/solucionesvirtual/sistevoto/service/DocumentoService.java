package com.solucionesvirtual.sistevoto.service;

import com.solucionesvirtual.sistevoto.domain.Documento;
import com.solucionesvirtual.sistevoto.repository.DocumentoRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DocumentoService {
    private final DocumentoRepo documentoRepo;

    public Documento save(Documento documento) {
        return documentoRepo.save(documento);
    }

    public Documento findById(Long id) {
        return documentoRepo.findByDocumento(id);
    }

    public List<Documento> getDocumentoPorAsamblea(Integer idAsamblea) {
        return documentoRepo.findByAsamblea(idAsamblea);
    }
}