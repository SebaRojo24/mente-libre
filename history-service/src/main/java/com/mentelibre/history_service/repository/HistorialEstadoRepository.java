package com.mentelibre.history_service.repository;

import com.mentelibre.history_service.model.HistorialEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialEstadoRepository extends JpaRepository<HistorialEstado, Long> {

    // Busca todos los registros de historial para un usuario específico
    List<HistorialEstado> findByUsuarioId(Long usuarioId);
}
