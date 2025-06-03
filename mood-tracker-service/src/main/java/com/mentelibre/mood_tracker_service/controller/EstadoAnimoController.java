package com.mentelibre.mood_tracker_service.controller;

import com.mentelibre.mood_tracker_service.model.EstadoAnimo;
import com.mentelibre.mood_tracker_service.service.EstadoAnimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/moods")
public class EstadoAnimoController {

    @Autowired
    private EstadoAnimoService service;

    @PostMapping("/registrar")
    public EstadoAnimo registrarEstado(@RequestBody Map<String, String> datos) {
        Long usuarioId = Long.parseLong(datos.get("usuarioId"));
        String estado = datos.get("estado");
        return service.registrarEstado(usuarioId, estado);
    }

    @GetMapping("/hoy")
    public EstadoAnimo obtenerEstadoHoy(@RequestParam Long usuarioId) {
        return service.obtenerEstadoHoy(usuarioId)
                .orElseThrow(() -> new RuntimeException("No se encontró estado para hoy"));
    }
    @GetMapping("/usuario/{usuarioId}")
    public List<EstadoAnimo> obtenerTodosPorUsuario(@PathVariable Long usuarioId) {
        return service.obtenerTodosPorUsuario(usuarioId);
    }
}
