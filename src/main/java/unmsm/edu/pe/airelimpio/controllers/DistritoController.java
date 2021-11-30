package unmsm.edu.pe.airelimpio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unmsm.edu.pe.airelimpio.models.Distrito;
import unmsm.edu.pe.airelimpio.services.DistritoService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "api/distritos")
public class DistritoController {
    @Autowired
    private DistritoService distritoService;

    @PostMapping(value = "crear")
    public ResponseEntity<?> crearDistrito(@RequestBody Distrito distrito) {
        return ResponseEntity.status(HttpStatus.CREATED).body(distritoService.save(distrito));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> obtenerDistritoPorId(@PathVariable Integer id) {
        Optional<Distrito> distrito = distritoService.findById(id);
        if(distrito.isPresent()) return ResponseEntity.ok(distrito.get());
        else return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Distrito> obtenerDistritos() {
        return StreamSupport.stream(distritoService.findAll().spliterator(), false)
                        .collect(Collectors.toList());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> actualizarDistrito(@RequestBody Distrito distrito, @PathVariable Integer id) {
        Optional<Distrito> distritoOptional = distritoService.findById(id);
        if(!distritoOptional.isPresent()) return ResponseEntity.notFound().build();

        if(distrito.getNombre() != null) distritoOptional.get().setNombre(distrito.getNombre());
        if(distrito.getCodigo() != null) distritoOptional.get().setCodigo(distrito.getCodigo());
        return ResponseEntity.status(HttpStatus.CREATED).body(distritoService.save(distritoOptional.get()));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> eliminarDistrito(@PathVariable Integer id) {
        if(!distritoService.findById(id).isPresent()) return ResponseEntity.notFound().build();
        distritoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
