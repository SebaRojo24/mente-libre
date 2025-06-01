package com.mentelibre.history_service.controller;

import com.mentelibre.history_service.model.HistorialEstado;
import com.mentelibre.history_service.service.HistorialEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historial")
public class HistorialEstadoController {

    @Autowired
    private HistorialEstadoService service;

    @GetMapping("/moods")
    public List<HistorialEstado> obtenerHistorial(@RequestParam Long usuarioId) {
        return service.obtenerHistorial(usuarioId);
    }
    @PostMapping("/moods")
    public HistorialEstado regitrar(@RequestBody HistorialEstado historial) {
        return service.guardarHistorial(historial);
    }
}
