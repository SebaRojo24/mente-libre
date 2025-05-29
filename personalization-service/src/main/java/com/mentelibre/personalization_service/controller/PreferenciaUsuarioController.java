package com.mentelibre.personalization_service.controller;

import com.mentelibre.personalization_service.model.PreferenciaUsuario;
import com.mentelibre.personalization_service.service.PreferenciaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/preferencias")
public class PreferenciaUsuarioController {

    @Autowired
    private PreferenciaUsuarioService service;

    @PostMapping("/interface")
    public PreferenciaUsuario guardar(@RequestBody PreferenciaUsuario preferencia) {
        return service.guardarPreferencia(preferencia);
    }

    @GetMapping("/interface")
    public PreferenciaUsuario obtener(@RequestParam Long usuarioId) {
        return service.obtenerPorUsuario(usuarioId)
                .orElseThrow(() -> new RuntimeException("No se encontraron preferencias"));
    }
}
