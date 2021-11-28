package unmsm.edu.pe.airelimpio.services;

import unmsm.edu.pe.airelimpio.models.Distrito;

import java.util.Optional;

public interface DistritoService {
    Distrito save(Distrito distrito);
    Optional<Distrito> findById(Integer id);
    Iterable<Distrito> findAll();
    void deleteById(Integer id);
}
