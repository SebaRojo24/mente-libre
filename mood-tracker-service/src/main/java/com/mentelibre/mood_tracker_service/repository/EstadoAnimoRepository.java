package com.mentelibre.mood_tracker_service.repository;

import com.mentelibre.mood_tracker_service.model.EstadoAnimo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EstadoAnimoRepository extends JpaRepository<EstadoAnimo, Long> {
    Optional<EstadoAnimo> findByUsuarioIdAndFecha(Long usuarioId, LocalDate fecha);
    List<EstadoAnimo> findByUsuarioId(Long usuarioId);
    List<EstadoAnimo> findByUsuarioIdAndFechaBetween(Long usuarioId, LocalDate desde, LocalDate hasta);
}
