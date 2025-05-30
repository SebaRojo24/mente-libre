package com.mentelibre.user_profile_service.service;

import com.mentelibre.user_profile_service.model.PerfilUsuario;
import com.mentelibre.user_profile_service.repository.PerfilUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilUsuarioService {

    @Autowired
    private PerfilUsuarioRepository repository;

    public PerfilUsuario crearPerfil(PerfilUsuario perfil) {
        return repository.save(perfil);
    }

    public Optional<PerfilUsuario> obtenerPerfilPorId(Long id) {
        return repository.findById(id);
    }

    public List<PerfilUsuario> obtenerTodos() {
        return repository.findAll();
    }

    public void eliminarPerfil(Long id) {
        repository.deleteById(id);
    }
}
