package unmsm.edu.pe.airelimpio.controllers;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unmsm.edu.pe.airelimpio.models.Usuario;
import unmsm.edu.pe.airelimpio.services.UsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "{id}")
    public ResponseEntity<?> obtenerUsuarioPorId(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if(usuario.isPresent()) return ResponseEntity.ok(usuario);
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Usuario> obtenerUsuarios(){
        return StreamSupport.stream(usuarioService.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) {
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        if(!usuarioOptional.isPresent()) return ResponseEntity.notFound().build();

        if(usuario.getNombres() != null) usuarioOptional.get().setNombres(usuario.getNombres());
        if(usuario.getApellidos() != null) usuarioOptional.get().setApellidos(usuario.getApellidos());
        if(usuario.getEmail() != null) usuarioOptional.get().setEmail(usuario.getEmail());
        if(usuario.getPassword() != null) usuarioOptional.get().setPassword(usuario.getPassword());
        if(usuario.getDistrito() != null) usuarioOptional.get().setDistrito(usuario.getDistrito());

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioOptional.get()));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer id) {
        if(!usuarioService.findById(id).isPresent()) return ResponseEntity.notFound().build();
        usuarioService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
