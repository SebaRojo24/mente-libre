package com.mentelibre.user_profile_service.controller;

import com.mentelibre.user_profile_service.model.PerfilUsuario;
import com.mentelibre.user_profile_service.service.PerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class PerfilUsuarioController {

    @Autowired
    private PerfilUsuarioService service;

    @PostMapping
    public PerfilUsuario crearPerfil(@RequestBody PerfilUsuario perfil) {
        return service.crearPerfil(perfil);
    }

    @GetMapping
    public List<PerfilUsuario> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public PerfilUsuario obtenerPorId(@PathVariable Long id) {
        return service.obtenerPerfilPorId(id)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));
    }
}
