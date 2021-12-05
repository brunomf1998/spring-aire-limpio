package unmsm.edu.pe.airelimpio.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unmsm.edu.pe.airelimpio.models.Historial;
import unmsm.edu.pe.airelimpio.repositories.HistorialRepository;
import unmsm.edu.pe.airelimpio.services.HistorialService;

import java.util.Optional;

@Service
public class HistorialServiceImpl implements HistorialService {
    @Autowired
    HistorialRepository historialRepository;

    @Override
    public Historial save(Historial historial) {
        return historialRepository.save(historial);
    }

    @Override
    public Optional<Historial> findById(Integer id) {
        return historialRepository.findById(id);
    }

    @Override
    public Iterable<Historial> findAll() {
        return historialRepository.findAll();
    }
}
