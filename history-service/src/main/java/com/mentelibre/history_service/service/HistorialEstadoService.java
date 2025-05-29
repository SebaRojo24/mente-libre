package com.mentelibre.history_service.service;

import com.mentelibre.history_service.model.HistorialEstado;
import com.mentelibre.history_service.repository.HistorialEstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialEstadoService {

    @Autowired
    private HistorialEstadoRepository repository;

    public List<HistorialEstado> obtenerHistorial(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public HistorialEstado guardarHistorial(HistorialEstado historial) {
        return repository.save(historial);
    }
}
