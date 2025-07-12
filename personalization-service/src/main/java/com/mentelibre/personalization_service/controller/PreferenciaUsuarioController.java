package com.mentelibre.personalization_service.controller;

import com.mentelibre.personalization_service.model.PreferenciaUsuario;
import com.mentelibre.personalization_service.service.PreferenciaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/preferencias")
public class PreferenciaUsuarioController {

    @Autowired
    private PreferenciaUsuarioService service;

    // Endpoint para guardar o actualizar preferencias (ya existente)
    @PostMapping("/interface")
    public PreferenciaUsuario guardar(@RequestBody PreferenciaUsuario preferencia) {
        return service.guardarPreferencia(preferencia);
    }


    @GetMapping("/allSimple")
    public List<PreferenciaUsuario> obtenerTodasSimples() {
        return service.obtenerTodasSimples();
    }

    @GetMapping("/all")
    public PagedModel<EntityModel<PreferenciaUsuario>> obtenerTodasPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<PreferenciaUsuario> preferenciasPage = service.obtenerTodas(pageable);

        List<EntityModel<PreferenciaUsuario>> preferencias = preferenciasPage.stream()
                .map(preferencia -> EntityModel.of(preferencia,
                        WebMvcLinkBuilder.linkTo(methodOn(PreferenciaUsuarioController.class)
                                .obtenerPorUsuarioId(preferencia.getUsuarioId())).withSelfRel()))
                .toList();

        PagedModel<EntityModel<PreferenciaUsuario>> pagedModel = PagedModel.of(
                preferencias,
                new PagedModel.PageMetadata(preferenciasPage.getSize(),
                        preferenciasPage.getNumber(),
                        preferenciasPage.getTotalElements(),
                        preferenciasPage.getTotalPages()));

        // Link self
        pagedModel.add(WebMvcLinkBuilder.linkTo(
                methodOn(PreferenciaUsuarioController.class).obtenerTodas(page, size)).withSelfRel());

        return pagedModel;
    }

    // Método auxiliar para obtener por usuarioId, reutilizado para el self link
    @GetMapping("/interface")
    public PreferenciaUsuario obtenerPorUsuarioId(@RequestParam Long usuarioId) {
        return service.obtenerPorUsuario(usuarioId)
                .orElseThrow(() -> new RuntimeException("No se encontraron preferencias"));
    }
    @GetMapping("/all/paginado")
    public Page<PreferenciaUsuario> obtenerTodas(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.obtenerTodas(page, size);
    }
}
