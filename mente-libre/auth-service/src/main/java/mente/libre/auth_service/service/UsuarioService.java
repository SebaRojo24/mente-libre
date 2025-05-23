package mente.libre.auth_service.service;

import mente.libre.auth_service.model.Usuario;
import mente.libre.auth_service.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registrarUsuario(Usuario usuario){
        if(usuarioRepository.existsByEmail(usuario.getEmail())){
            throw new RuntimeException("El email ya existe");
        }
        return usuarioRepository.save(usuario);
    }
}
