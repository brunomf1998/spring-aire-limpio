package unmsm.edu.pe.airelimpio.services;

import unmsm.edu.pe.airelimpio.models.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Usuario save(Usuario usuario);
    Optional<Usuario> findById(Integer id);
    Iterable<Usuario> findAll();
    void deleteById(Integer id);
}
