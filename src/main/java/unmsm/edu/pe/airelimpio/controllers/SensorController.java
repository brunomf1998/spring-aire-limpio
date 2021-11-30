package unmsm.edu.pe.airelimpio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unmsm.edu.pe.airelimpio.models.Sensor;
import unmsm.edu.pe.airelimpio.services.SensorService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "api/sensores")
public class SensorController {
    @Autowired
    private SensorService sensorService;

    @PostMapping(value = "crear")
    public ResponseEntity<?> crearSensor(@RequestBody Sensor sensor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sensorService.save(sensor));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> obtenerSensorPorId(@PathVariable Integer id) {
        Optional<Sensor> sensor = sensorService.findById(id);
        if(sensor.isPresent()) return ResponseEntity.ok(sensor.get());
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Sensor> obtenerSensores() {
        return StreamSupport.stream(sensorService.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> actualizarSensor(@RequestBody Sensor sensor, @PathVariable Integer id) {
        Optional<Sensor> sensorOptional = sensorService.findById(id);
        if(!sensorOptional.isPresent()) return ResponseEntity.notFound().build();

        if(sensor.getModelo() != null) sensorOptional.get().setModelo(sensor.getModelo());

        return ResponseEntity.status(HttpStatus.CREATED).body(sensorOptional.get());
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> eliminarSensor(@PathVariable Integer id) {
        if(!sensorService.findById(id).isPresent()) return ResponseEntity.notFound().build();
        sensorService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
