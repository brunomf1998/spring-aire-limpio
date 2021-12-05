package unmsm.edu.pe.airelimpio.services;

import unmsm.edu.pe.airelimpio.models.Historial;

import java.util.Optional;

public interface HistorialService {
    Historial save(Historial historial);
    Optional<Historial> findById(Integer id);
    Iterable<Historial> findAll();
}
