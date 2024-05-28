package com.solucionesvirtual.sistevoto.service;

import com.solucionesvirtual.sistevoto.domain.Copropiedad;
import com.solucionesvirtual.sistevoto.repository.CopropiedadRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CopropiedadService {
    private final CopropiedadRepo copropiedadRepo;
    public void crearperson(Copropiedad persona){
        copropiedadRepo.save(persona);
    }
    public TipoUser login(String usuario, String contrasenia){
       Copropiedad copropiedad = copropiedadRepo. findByCopropiedadAndContrasenia(usuario, contrasenia);
        TipoUser tipoUser = new TipoUser(copropiedad.getCopropiedad(),copropiedad.getAdministrador(),copropiedad.getAdministrador());
    return tipoUser;
    }
    public Copropiedad buscarCopropiedad(String usuario){
        Optional<Copropiedad> persona = copropiedadRepo.findByCopropiedad(usuario);
        return persona.orElse(null);
    }
    public int contarTodo(){
        return copropiedadRepo.contarTodo();
    }

}