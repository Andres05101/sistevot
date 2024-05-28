package com.solucionesvirtual.sistevoto.repository;

import com.solucionesvirtual.sistevoto.domain.AsambleaCopropiedadId;
import com.solucionesvirtual.sistevoto.domain.Asamblea_copropiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Asam_CoproRepo extends JpaRepository<Asamblea_copropiedad, AsambleaCopropiedadId> {
    boolean existsByAsambleaAndAndCopropiedad(int asamblea, String copropiedad);
    @Query("SELECT COUNT(ac) FROM Asamblea_copropiedad ac WHERE ac.asamblea = :idAsamblea")
    int contarporAsamblea(int idAsamblea);
    @Query("SELECT ac FROM Asamblea_copropiedad ac WHERE ac.asamblea = :idAsamblea")
    List<Asamblea_copropiedad> findByAsamblea(int idAsamblea);
}