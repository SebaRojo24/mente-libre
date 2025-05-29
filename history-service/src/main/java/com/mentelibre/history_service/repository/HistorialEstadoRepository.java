package com.mentelibre.history_service.repository;

import com.mentelibre.history_service.model.HistorialEstado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistorialEstadoRepository extends JpaRepository<HistorialEstado, Long> {
    List<HistorialEstado> findByUsuarioId(Long usuarioId);
}
