package com.mentelibre.mood_tracker_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistroEstadoDTO {
    @NotNull
    private Long usuarioId;

    @NotBlank
    private String estado;
}
