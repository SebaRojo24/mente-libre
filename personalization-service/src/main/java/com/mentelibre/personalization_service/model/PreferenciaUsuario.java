package com.mentelibre.personalization_service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "preferencias")
@Data
@NoArgsConstructor
public class PreferenciaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;
    private String idioma;
    private String colorFondo;
    private String tamanoLetra;
}
