package unmsm.edu.pe.airelimpio.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unmsm.edu.pe.airelimpio.models.Usuario;
import unmsm.edu.pe.airelimpio.repositories.UsuarioRepository;
import unmsm.edu.pe.airelimpio.services.UsuarioService;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Iterable<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
