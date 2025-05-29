package com.mentelibre.notifications_service.controller;

import com.mentelibre.notifications_service.model.Notificacion;
import com.mentelibre.notifications_service.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService service;

    @PostMapping("/set")
    public Notificacion crear(@RequestBody Map<String, String> datos) {
        Long usuarioId = Long.parseLong(datos.get("usuarioId"));
        String mensaje = datos.get("mensaje");

        return service.crearNotificacion(usuarioId, mensaje);
    }

    @GetMapping("/send")
    public List<Notificacion> obtener(@RequestParam Long usuarioId) {
        return service.obtenerPorUsuario(usuarioId);
    }
}
