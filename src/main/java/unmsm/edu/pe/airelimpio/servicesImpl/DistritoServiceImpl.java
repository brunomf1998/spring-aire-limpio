package unmsm.edu.pe.airelimpio.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unmsm.edu.pe.airelimpio.models.Distrito;
import unmsm.edu.pe.airelimpio.repositories.DistritoRepository;
import unmsm.edu.pe.airelimpio.services.DistritoService;

import java.util.Optional;

@Service
public class DistritoServiceImpl implements DistritoService {
    @Autowired
    private DistritoRepository distritoRepository;

    @Override
    public Distrito save(Distrito distrito) {
        return distritoRepository.save(distrito);
    }

    @Override
    public Optional<Distrito> findById(Integer id) {
        return distritoRepository.findById(id);
    }

    @Override
    public Iterable<Distrito> findAll() {
        return distritoRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        distritoRepository.deleteById(id);
    }
}
