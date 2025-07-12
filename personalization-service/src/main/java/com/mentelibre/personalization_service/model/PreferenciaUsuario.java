package com.mentelibre.personalization_service.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "preferencias")
@Data
@NoArgsConstructor
@AllArgsConstructor // <--- Añade esta línea
public class PreferenciaUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;
    private String idioma;
    private String colorFondo;
    private String tamanoLetra;
}
