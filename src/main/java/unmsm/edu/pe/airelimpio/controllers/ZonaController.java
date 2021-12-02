package unmsm.edu.pe.airelimpio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unmsm.edu.pe.airelimpio.models.Zona;
import unmsm.edu.pe.airelimpio.services.ZonaService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "api/zonas")
public class ZonaController {
    @Autowired
    private ZonaService zonaService;

    @PostMapping(value = "crear")
    public ResponseEntity<?> crearZona(@RequestBody Zona zona) {
        return ResponseEntity.status(HttpStatus.CREATED).body(zonaService.save(zona));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> obtenerZonaPorId(@PathVariable Integer id) {
        Optional<Zona> zona = zonaService.findById(id);
        if(zona.isPresent()) return ResponseEntity.ok(zona);
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Zona> obtenerZonas(){
        return StreamSupport.stream(zonaService.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> actualizarZona(@RequestBody Zona zona, @PathVariable Integer id) {
        Optional<Zona> zonaOptional = zonaService.findById(id);
        if(!zonaOptional.isPresent()) return ResponseEntity.notFound().build();

        if(zona.getCoordX() != null) zonaOptional.get().setCoordX(zona.getCoordX());
        if(zona.getCoordY() != null) zonaOptional.get().setCoordY(zona.getCoordY());
        if(zona.getMedida() != null) zonaOptional.get().setMedida(zona.getMedida());
        if(zona.getFechaMedida() != null) zonaOptional.get().setFechaMedida(zona.getFechaMedida());
        if(zona.getSensor() != null) zonaOptional.get().setSensor(zona.getSensor());
        if(zona.getDistrito() != null) zonaOptional.get().setDistrito(zona.getDistrito());

        return ResponseEntity.status(HttpStatus.CREATED).body(zonaService.save(zonaOptional.get()));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> eliminarZona(@PathVariable Integer id) {
        if(!zonaService.findById(id).isPresent()) return ResponseEntity.notFound().build();
        zonaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
