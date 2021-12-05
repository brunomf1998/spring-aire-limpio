package unmsm.edu.pe.airelimpio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unmsm.edu.pe.airelimpio.models.Historial;
import unmsm.edu.pe.airelimpio.services.HistorialService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "api/historial")
public class HistorialController {
    @Autowired
    HistorialService historialService;

    @PostMapping(value = "crear")
    public ResponseEntity<?> crearHistorial(@RequestBody Historial historial) {
        return ResponseEntity.status(HttpStatus.CREATED).body(historialService.save(historial));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> obtenerHistorialPorId(@PathVariable Integer id) {
        Optional<Historial> historial = historialService.findById(id);
        if(historial.isPresent()) return ResponseEntity.ok(historial.get());
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Historial> obtenerHistorial() {
        return StreamSupport.stream(historialService.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
