package com.mentelibre.mood_tracker_service.controller;

import com.mentelibre.mood_tracker_service.dto.RegistroEstadoDTO;
import com.mentelibre.mood_tracker_service.model.EstadoAnimo;
import com.mentelibre.mood_tracker_service.service.EstadoAnimoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

@RestController
@RequestMapping("/moods")
public class EstadoAnimoController {

    @Autowired
    private EstadoAnimoService service;

    @Operation(summary = "Registrar estado de ánimo")
    @PostMapping("/registrar")
    public EstadoAnimo registrarEstado(@RequestBody RegistroEstadoDTO dto) {
        return service.registrarEstado(dto.getUsuarioId(), dto.getEstado());
    }

    @Operation(summary = "Obtener estado de ánimo de hoy")
    @GetMapping("/hoy")
    public ResponseEntity<EstadoAnimo> obtenerEstadoHoy(@RequestParam Long usuarioId) {
        return service.obtenerEstadoHoy(usuarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Listar todos los estados de un usuario")
    @GetMapping("/usuario/{usuarioId}")
    public List<EstadoAnimo> obtenerTodosPorUsuario(@PathVariable Long usuarioId) {
        return service.obtenerTodosPorUsuario(usuarioId);
    }

    @Operation(summary = "Obtener estado por ID con HATEOAS")
    @GetMapping("/{id}")
    public EntityModel<EstadoAnimo> obtenerPorId(@PathVariable Long id) {
        EstadoAnimo estado = service.obtenerPorId(id).orElseThrow();
        return EntityModel.of(estado,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EstadoAnimoController.class).obtenerPorId(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EstadoAnimoController.class).obtenerTodosPorUsuario(estado.getUsuarioId())).withRel("historial"));
    }

    @Operation(summary = "Actualizar estado")
    @PutMapping("/{id}")
    public EstadoAnimo actualizarEstado(@PathVariable Long id, @RequestBody EstadoAnimo actualizado) {
        return service.actualizar(id, actualizado);
    }

    @Operation(summary = "Eliminar estado")
    @DeleteMapping("/{id}")
    public void eliminarEstado(@PathVariable Long id) {
        service.eliminar(id);
    }
    @Operation(summary = "Ver todos los registros")
    @GetMapping("/todos")
    public CollectionModel<EntityModel<EstadoAnimo>> obtenerTodos() {
        List<EstadoAnimo> lista = service.obtenerTodos();

        List<EntityModel<EstadoAnimo>> recursos = lista.stream().map(estado ->
                EntityModel.of(estado,
                        WebMvcLinkBuilder.linkTo(
                                WebMvcLinkBuilder.methodOn(EstadoAnimoController.class).obtenerPorId(estado.getId())
                        ).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(
                                WebMvcLinkBuilder.methodOn(EstadoAnimoController.class).obtenerTodosPorUsuario(estado.getUsuarioId())
                        ).withRel("historial")
                )
        ).toList();

        return CollectionModel.of(recursos,
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(EstadoAnimoController.class).obtenerTodos()
                ).withSelfRel()
        );
    }
}
