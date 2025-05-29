package com.mentelibre.mood_tracker_service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "estado_animo")
@Data
@NoArgsConstructor

public class EstadoAnimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;
    private String estado;
    private LocalDate fecha;
}
