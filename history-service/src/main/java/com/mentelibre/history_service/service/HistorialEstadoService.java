package com.mentelibre.history_service.service;

import com.mentelibre.history_service.model.HistorialEstado;
import java.util.List;
import java.util.Optional;

public interface HistorialEstadoService {
    List<HistorialEstado> obtenerHistorial(Long usuarioId);
    HistorialEstado guardarHistorial(HistorialEstado historial);
    Optional<HistorialEstado> obtenerHistorialPorId(Long id);
    void eliminarHistorial(Long id);
    List<HistorialEstado> obtenerTodos();
}
