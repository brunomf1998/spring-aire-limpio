package unmsm.edu.pe.airelimpio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unmsm.edu.pe.airelimpio.models.Zona;

@Repository
public interface ZonaRepository extends JpaRepository<Zona, Integer> {

}
