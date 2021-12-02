package unmsm.edu.pe.airelimpio.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unmsm.edu.pe.airelimpio.models.Zona;
import unmsm.edu.pe.airelimpio.repositories.ZonaRepository;
import unmsm.edu.pe.airelimpio.services.ZonaService;

import java.util.Optional;

@Service
public class ZonaServiceImpl implements ZonaService {
    @Autowired
    ZonaRepository zonaRepository;

    @Override
    public Zona save(Zona zona) {
        return zonaRepository.save(zona);
    }

    @Override
    public Optional<Zona> findById(Integer id) {
        return zonaRepository.findById(id);
    }

    @Override
    public Iterable<Zona> findAll() {
        return zonaRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        zonaRepository.deleteById(id);
    }
}
