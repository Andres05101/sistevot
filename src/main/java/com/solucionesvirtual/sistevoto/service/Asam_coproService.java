package com.solucionesvirtual.sistevoto.service;

import com.solucionesvirtual.sistevoto.domain.Asamblea_copropiedad;
import com.solucionesvirtual.sistevoto.repository.Asam_CoproRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Asam_coproService {
    private Asam_CoproRepo asamCoproRepo;

    public void registrarAsistencia(Asamblea_copropiedad asambleaCopropiedad){
        asamCoproRepo.save(asambleaCopropiedad);
    }
    public boolean registroAsambleaHoy(int asamblea, String copropiedad){
        return asamCoproRepo.existsByAsambleaAndAndCopropiedad(asamblea,copropiedad);
    }
    public int contarPorAsamblea(int asamblea){
        return asamCoproRepo.contarporAsamblea(asamblea);
    }

}