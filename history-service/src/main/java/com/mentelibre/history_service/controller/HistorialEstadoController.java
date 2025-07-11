package com.mentelibre.history_service.controller;

import com.mentelibre.history_service.model.HistorialEstado;
import com.mentelibre.history_service.service.HistorialEstadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historial")
@Tag(name = "Historial Estado", description = "API para gestionar el historial de estados administrativos de pacientes")
public class HistorialEstadoController {

    private final HistorialEstadoService service;

    @Autowired
    public HistorialEstadoController(HistorialEstadoService service) {
        this.service = service;
    }

    @Operation(summary = "Crear un nuevo estado en el historial")
    @PostMapping
    public ResponseEntity<EntityModel<HistorialEstado>> crear(@RequestBody HistorialEstado historial) {
        HistorialEstado creado = service.guardarHistorial(historial);

        EntityModel<HistorialEstado> recurso = EntityModel.of(creado,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HistorialEstadoController.class)
                                .obtenerPorId(creado.getId()))
                        .withSelfRel());

        return ResponseEntity.created(
                URI.create("/historial/" + creado.getId())
        ).body(recurso);
    }

    @Operation(summary = "Obtener el historial completo de un usuario")
    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<HistorialEstado>>> listarPorUsuario(@RequestParam Long usuarioId) {
        List<EntityModel<HistorialEstado>> estados = service.obtenerHistorial(usuarioId).stream()
                .map(historial -> EntityModel.of(historial,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HistorialEstadoController.class)
                                        .obtenerPorId(historial.getId()))
                                .withSelfRel()))
                .collect(Collectors.toList());

        CollectionModel<EntityModel<HistorialEstado>> coleccion = CollectionModel.of(estados,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HistorialEstadoController.class)
                                .listarPorUsuario(usuarioId))
                        .withSelfRel());

        return ResponseEntity.ok(coleccion);
    }

    @Operation(summary = "Obtener un estado del historial por ID")
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<HistorialEstado>> obtenerPorId(@PathVariable Long id) {
        Optional<HistorialEstado> historialOpt = service.obtenerHistorialPorId(id);

        return historialOpt.map(historial -> EntityModel.of(historial,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HistorialEstadoController.class)
                                .obtenerPorId(id)).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HistorialEstadoController.class)
                                .listarPorUsuario(historial.getUsuarioId())).withRel("historial-usuario")))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Actualizar un estado del historial por ID")
    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<HistorialEstado>> actualizar(@PathVariable Long id, @RequestBody HistorialEstado actualizado) {
        Optional<HistorialEstado> historialExistente = service.obtenerHistorialPorId(id);

        if (historialExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Copiar los campos actualizados (excepto el id)
        HistorialEstado historial = historialExistente.get();
        historial.setUsuarioId(actualizado.getUsuarioId());
        historial.setEstado(actualizado.getEstado());
        historial.setFecha(actualizado.getFecha());

        HistorialEstado guardado = service.guardarHistorial(historial);

        EntityModel<HistorialEstado> recurso = EntityModel.of(guardado,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HistorialEstadoController.class)
                                .obtenerPorId(guardado.getId()))
                        .withSelfRel());

        return ResponseEntity.ok(recurso);
    }

    @Operation(summary = "Eliminar un estado del historial por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Optional<HistorialEstado> historialExistente = service.obtenerHistorialPorId(id);

        if (historialExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.eliminarHistorial(id);
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Obtener todos los historiales de todos los usuarios")
    @GetMapping("/todos")
    public ResponseEntity<CollectionModel<EntityModel<HistorialEstado>>> listarTodos() {
        List<EntityModel<HistorialEstado>> historiales = service.obtenerTodos().stream()
                .map(historial -> EntityModel.of(historial,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HistorialEstadoController.class)
                                        .obtenerPorId(historial.getId()))
                                .withSelfRel()))
                .collect(Collectors.toList());

        CollectionModel<EntityModel<HistorialEstado>> coleccion = CollectionModel.of(historiales,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HistorialEstadoController.class)
                                .listarTodos())
                        .withSelfRel());

        return ResponseEntity.ok(coleccion);
    }
}
