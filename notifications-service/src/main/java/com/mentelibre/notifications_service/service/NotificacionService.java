package com.mentelibre.notifications_service.service;

import com.mentelibre.notifications_service.model.Notificacion;
import com.mentelibre.notifications_service.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository repository;

    public Notificacion crearNotificacion(Long usuarioId, String mensaje) {
        Notificacion notificacion = new Notificacion();
        notificacion.setUsuarioId(usuarioId);
        notificacion.setMensaje(mensaje);
        notificacion.setFechaHora(LocalDateTime.now());
        notificacion.setEnviada(false);

        return repository.save(notificacion);
    }

    public List<Notificacion> obtenerPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }
    public List<Notificacion> obtenerTodas() {
        return repository.findAll();
    }
    public Notificacion obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada con ID: " + id));
    }
}
