package com.mentelibre.personalization_service.service;

import com.mentelibre.personalization_service.model.PreferenciaUsuario;
import com.mentelibre.personalization_service.repository.PreferenciaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;


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
    public List<PreferenciaUsuario> obtenerTodas() {
        return repository.findAll();
    }
    public Page<PreferenciaUsuario> obtenerTodas(Pageable pageable) {
        return repository.findAll(pageable);
    }
    public List<PreferenciaUsuario> obtenerTodasSimples() {
        return repository.findAll();
    }
    public Page<PreferenciaUsuario> obtenerTodas(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }
}
