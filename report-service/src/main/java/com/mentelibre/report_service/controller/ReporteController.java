package com.mentelibre.report_service.controller;

import com.mentelibre.report_service.model.Reporte;
import com.mentelibre.report_service.service.ReporteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "Reportes", description = "Operaciones relacionadas con los reportes de usuarios")
@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService service;

    @Operation(summary = "Crear un nuevo reporte", description = "Crea un reporte para un usuario específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reporte creado con éxito",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Reporte.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping("/user/{id}")
    public Reporte crear(
            @Parameter(description = "ID del usuario", required = true) @PathVariable Long id,
            @RequestBody Map<String, String> body) {
        String descripcion = body.get("descripcion");
        return service.generarReporte(id, descripcion);
    }

    @Operation(summary = "Obtener todos los reportes", description = "Devuelve una lista de todos los reportes registrados")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con éxito",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Reporte.class)))
    @GetMapping
    public List<Reporte> obtenerTodos() {
        return service.obtenerTodos();
    }

    @Operation(summary = "Obtener reportes por usuario", description = "Devuelve los reportes asociados a un usuario")
    @ApiResponse(responseCode = "200", description = "Reportes obtenidos con éxito",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Reporte.class)))
    @GetMapping("/user/{id}")
    public List<Reporte> obtener(@PathVariable Long id) {
        return service.obtenerPorUsuario(id);
    }

    @Operation(summary = "Obtener un reporte por ID", description = "Busca y devuelve un reporte específico por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reporte encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Reporte.class))),
            @ApiResponse(responseCode = "404", description = "Reporte no encontrado")
    })
    @GetMapping("/{id}")
    public Reporte obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
    }

    @Operation(summary = "Actualizar un reporte", description = "Actualiza la descripción de un reporte existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reporte actualizado correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Reporte.class))),
            @ApiResponse(responseCode = "404", description = "Reporte no encontrado")
    })
    @PutMapping("/{id}")
    public Reporte actualizar(
            @Parameter(description = "ID del reporte a actualizar", required = true) @PathVariable Long id,
            @RequestBody Map<String, String> body) {
        String nuevaDescripcion = body.get("descripcion");
        return service.actualizarReporte(id, nuevaDescripcion);
    }

    @Operation(summary = "Eliminar un reporte", description = "Elimina un reporte existente por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reporte eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Reporte no encontrado")
    })
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarReporte(id);
    }

    @Operation(summary = "Simular descarga de reportes", description = "Simula una descarga de reportes en formato PDF o JSON")
    @ApiResponse(responseCode = "200", description = "Simulación exitosa")
    @GetMapping("/download")
    public String descargar() {
        return "Simulando descarga de reportes (PDF/JSON).";
    }
}