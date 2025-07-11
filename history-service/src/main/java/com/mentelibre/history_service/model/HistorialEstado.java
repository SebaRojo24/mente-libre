package com.mentelibre.history_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "historial_estado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private LocalDate fecha;

    // Constructor adicional sin id para facilitar creación antes de persistir
    public HistorialEstado(Long usuarioId, String estado, LocalDate fecha) {
        this.usuarioId = usuarioId;
        this.estado = estado;
        this.fecha = fecha;
    }
}
