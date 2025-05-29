package com.mentelibre.auth_service.service;

import com.mentelibre.auth_service.model.Usuario;
import com.mentelibre.auth_service.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Registrar usuario
    public Usuario registrarUsuario(Usuario usuario) {
        // si ya existe un usuario con el mismo email, lanza error
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("El correo ya está registrado");
        }
        // guarda el nuevo usuario en la base de datos
        return usuarioRepository.save(usuario);
    }
    // iniciar sesión
    public Usuario login(String email, String password) {
        // buscar usuario por email
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // comparar la contraseña
        if (!usuario.getPassword().equals(password)){
            throw new RuntimeException("Contraseña incorrecta");
        }
        return usuario;
    }
}
