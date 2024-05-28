package com.solucionesvirtual.sistevoto.repository;


import com.solucionesvirtual.sistevoto.domain.Copropiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CopropiedadRepo extends JpaRepository<Copropiedad,String> {
    @Query("SELECT COUNT(c) FROM Copropiedad c")
    int contarTodo();
    Optional<Copropiedad> findByCopropiedad(String copropiedad);
    public Copropiedad findByCopropiedadAndContrasenia(String copropiedad, String contrasenia);
}