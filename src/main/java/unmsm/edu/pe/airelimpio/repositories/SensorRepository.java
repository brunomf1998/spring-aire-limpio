package unmsm.edu.pe.airelimpio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unmsm.edu.pe.airelimpio.models.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {

}
