package com.mentelibre.notifications_service.controller;

import com.mentelibre.notifications_service.model.Notificacion;
import com.mentelibre.notifications_service.service.NotificacionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
@Tag(name = "Notificaciones", description = "API para gestionar notificaciones del usuario")
public class NotificacionController {

    @Autowired
    private NotificacionService service;

    @PostMapping("/set")
    public EntityModel<Notificacion> crear(@RequestBody Map<String, String> datos) {
        Long usuarioId = Long.parseLong(datos.get("usuarioId"));
        String mensaje = datos.get("mensaje");

        Notificacion notificacion = service.crearNotificacion(usuarioId, mensaje);

        return EntityModel.of(notificacion,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(NotificacionController.class)
                        .obtenerPorId(notificacion.getId())).withSelfRel()
        );
    }

    @GetMapping("/send")
    public CollectionModel<EntityModel<Notificacion>> obtenerPorUsuario(@RequestParam Long usuarioId) {
        List<EntityModel<Notificacion>> lista = service.obtenerPorUsuario(usuarioId).stream()
                .map(n -> EntityModel.of(n,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(NotificacionController.class)
                                .obtenerPorId(n.getId())).withSelfRel()))
                .collect(Collectors.toList());

        return CollectionModel.of(lista,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(NotificacionController.class)
                        .obtenerPorUsuario(usuarioId)).withSelfRel());
    }

    @GetMapping
    public CollectionModel<EntityModel<Notificacion>> obtenerTodas() {
        List<EntityModel<Notificacion>> lista = service.obtenerTodas().stream()
                .map(n -> EntityModel.of(n,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(NotificacionController.class)
                                .obtenerPorId(n.getId())).withSelfRel()))
                .collect(Collectors.toList());

        return CollectionModel.of(lista,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(NotificacionController.class)
                        .obtenerTodas()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Notificacion> obtenerPorId(@PathVariable Long id) {
        Notificacion notificacion = service.obtenerPorId(id);
        return EntityModel.of(notificacion,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(NotificacionController.class)
                        .obtenerPorId(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(NotificacionController.class)
                        .obtenerPorUsuario(notificacion.getUsuarioId())).withRel("usuario-notificaciones"));
    }
}
