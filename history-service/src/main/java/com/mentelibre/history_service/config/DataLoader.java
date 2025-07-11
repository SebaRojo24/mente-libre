package com.mentelibre.history_service.config;

import com.mentelibre.history_service.model.HistorialEstado;
import com.mentelibre.history_service.repository.HistorialEstadoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader {

    private final HistorialEstadoRepository repository;

    public DataLoader(HistorialEstadoRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void loadData() {
        // Crea instancias con usuarioId, estado, fecha
        HistorialEstado h1 = new HistorialEstado(1L, "activo", LocalDate.of(2023, 1, 10));
        HistorialEstado h2 = new HistorialEstado(1L, "inactivo", LocalDate.of(2023, 3, 15));
        HistorialEstado h3 = new HistorialEstado(2L, "activo", LocalDate.of(2023, 2, 20));

        // Guarda en la base de datos
        repository.save(h1);
        repository.save(h2);
        repository.save(h3);
    }
}
