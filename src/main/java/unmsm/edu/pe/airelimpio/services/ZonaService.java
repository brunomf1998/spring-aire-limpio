package unmsm.edu.pe.airelimpio.services;

import unmsm.edu.pe.airelimpio.models.Zona;

import java.util.Optional;

public interface ZonaService {
    Zona save(Zona zona);
    Optional<Zona> findById(Integer id);
    Iterable<Zona> findAll();
    void deleteById(Integer id);
}
