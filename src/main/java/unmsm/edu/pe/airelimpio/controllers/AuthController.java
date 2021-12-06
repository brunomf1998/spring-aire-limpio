package unmsm.edu.pe.airelimpio.controllers;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unmsm.edu.pe.airelimpio.models.Usuario;
import unmsm.edu.pe.airelimpio.services.UsuarioService;
import unmsm.edu.pe.airelimpio.utils.JWTUtil;

@RestController
@RequestMapping(path = "api/auth")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping(value = "signup")
    public ResponseEntity<?> signUp(@RequestBody Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    @PostMapping(value = "login")
    public ResponseEntity<?> logIn(@RequestBody Usuario usuario) {
        Usuario usuarioLogueado = usuarioService.getUserByCredentials(usuario.getEmail(), usuario.getPassword());
        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
            return ResponseEntity.ok(tokenJwt);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
