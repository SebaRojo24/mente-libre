package com.mentelibre.personalization_service.service;

import com.mentelibre.personalization_service.model.PreferenciaUsuario;
import com.mentelibre.personalization_service.repository.PreferenciaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PreferenciaUsuarioService {

    @Autowired
    private PreferenciaUsuarioRepository repository;

    public PreferenciaUsuario guardarPreferencia(PreferenciaUsuario preferencia) {
        return repository.save(preferencia);
    }

    public Optional<PreferenciaUsuario> obtenerPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }
}
