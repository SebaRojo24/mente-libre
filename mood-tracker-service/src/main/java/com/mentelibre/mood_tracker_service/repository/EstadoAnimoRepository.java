package com.mentelibre.mood_tracker_service.repository;

import com.mentelibre.mood_tracker_service.model.EstadoAnimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface EstadoAnimoRepository extends JpaRepository<EstadoAnimo, Long>{
    Optional<EstadoAnimo> findByUsuarioIdandFecha(Long usuarioId, LocalDate fecha);

}
