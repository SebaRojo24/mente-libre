package com.mentelibre.mood_tracker_service;

import com.mentelibre.mood_tracker_service.model.EstadoAnimo;
import com.mentelibre.mood_tracker_service.service.EstadoAnimoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EstadoAnimoServiceTest {

    @Autowired
    private EstadoAnimoService service;

    @Test
    public void testRegistrarEstado() {
        EstadoAnimo estado = service.registrarEstado(999L, "Agradecido");
        assertNotNull(estado.getId());
        assertEquals("Agradecido", estado.getEstado());
    }
}
