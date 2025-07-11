package com.mentelibre.history_service.service.impl;

import com.mentelibre.history_service.model.HistorialEstado;
import com.mentelibre.history_service.repository.HistorialEstadoRepository;
import com.mentelibre.history_service.service.HistorialEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialEstadoServiceImpl implements HistorialEstadoService {

    private final HistorialEstadoRepository historialEstadoRepository;

    @Autowired
    public HistorialEstadoServiceImpl(HistorialEstadoRepository historialEstadoRepository) {
        this.historialEstadoRepository = historialEstadoRepository;
    }

    @Override
    public List<HistorialEstado> obtenerHistorial(Long usuarioId) {
        return historialEstadoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public HistorialEstado guardarHistorial(HistorialEstado historial) {
        return historialEstadoRepository.save(historial);
    }

    @Override
    public Optional<HistorialEstado> obtenerHistorialPorId(Long id) {
        return historialEstadoRepository.findById(id);
    }

    @Override
    public void eliminarHistorial(Long id) {
        historialEstadoRepository.deleteById(id);
    }

    @Override
    public List<HistorialEstado> obtenerTodos() {
        return historialEstadoRepository.findAll();
    }
}
