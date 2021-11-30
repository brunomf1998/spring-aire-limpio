package unmsm.edu.pe.airelimpio.services;

import unmsm.edu.pe.airelimpio.models.Sensor;

import java.util.Optional;

public interface SensorService {
    Sensor save(Sensor sensor);
    Optional<Sensor> findById(Integer id);
    Iterable<Sensor> findAll();
    void deleteById(Integer id);
}
