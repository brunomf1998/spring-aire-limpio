package unmsm.edu.pe.airelimpio.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unmsm.edu.pe.airelimpio.models.Sensor;
import unmsm.edu.pe.airelimpio.repositories.SensorRepository;
import unmsm.edu.pe.airelimpio.services.SensorService;

import java.util.Optional;

@Service
public class SensorServiceImpl implements SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    @Override
    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public Optional<Sensor> findById(Integer id) {
        return sensorRepository.findById(id);
    }

    @Override
    public Iterable<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        sensorRepository.deleteById(id);
    }
}
