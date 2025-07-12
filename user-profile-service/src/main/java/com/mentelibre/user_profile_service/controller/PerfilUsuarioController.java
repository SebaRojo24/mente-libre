package com.mentelibre.user_profile_service.controller;

import com.mentelibre.user_profile_service.model.PerfilUsuario;
import com.mentelibre.user_profile_service.service.PerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/profiles")
public class PerfilUsuarioController {

    @Autowired
    private PerfilUsuarioService service;

    @PostMapping
    public EntityModel<PerfilUsuario> crearPerfil(@RequestBody PerfilUsuario perfil) {
        PerfilUsuario creado = service.crearPerfil(perfil);
        return EntityModel.of(creado,
                linkTo(methodOn(PerfilUsuarioController.class).obtenerPorId(creado.getId())).withSelfRel(),
                linkTo(methodOn(PerfilUsuarioController.class).obtenerTodos()).withRel("perfiles"));
    }

    @GetMapping
    public CollectionModel<EntityModel<PerfilUsuario>> obtenerTodos() {
        List<EntityModel<PerfilUsuario>> perfiles = service.obtenerTodos().stream()
                .map(perfil -> EntityModel.of(perfil,
                        linkTo(methodOn(PerfilUsuarioController.class).obtenerPorId(perfil.getId())).withSelfRel()))
                .collect(Collectors.toList());

        return CollectionModel.of(perfiles,
                linkTo(methodOn(PerfilUsuarioController.class).obtenerTodos()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<PerfilUsuario> obtenerPorId(@PathVariable Long id) {
        PerfilUsuario perfil = service.obtenerPerfilPorId(id)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        return EntityModel.of(perfil,
                linkTo(methodOn(PerfilUsuarioController.class).obtenerPorId(id)).withSelfRel(),
                linkTo(methodOn(PerfilUsuarioController.class).obtenerTodos()).withRel("perfiles"));
    }

    @PutMapping("/{id}")
    public EntityModel<PerfilUsuario> actualizarPerfil(@PathVariable Long id, @RequestBody PerfilUsuario perfilActualizado) {
        PerfilUsuario perfilExistente = service.obtenerPerfilPorId(id)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        perfilExistente.setNombre(perfilActualizado.getNombre());
        perfilExistente.setApellido(perfilActualizado.getApellido());
        perfilExistente.setEdad(perfilActualizado.getEdad());
        perfilExistente.setPais(perfilActualizado.getPais());
        perfilExistente.setPreferencias(perfilActualizado.getPreferencias());

        PerfilUsuario actualizado = service.crearPerfil(perfilExistente);

        return EntityModel.of(actualizado,
                linkTo(methodOn(PerfilUsuarioController.class).obtenerPorId(actualizado.getId())).withSelfRel(),
                linkTo(methodOn(PerfilUsuarioController.class).obtenerTodos()).withRel("perfiles"));
    }

    @DeleteMapping("/{id}")
    public void eliminarPerfil(@PathVariable Long id) {
        service.obtenerPerfilPorId(id)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));
        service.eliminarPerfil(id);
    }
}
