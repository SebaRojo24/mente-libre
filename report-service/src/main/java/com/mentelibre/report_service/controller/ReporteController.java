package com.mentelibre.report_service.controller;

import com.mentelibre.report_service.model.Reporte;
import com.mentelibre.report_service.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService service;

    @PostMapping("/user/{id}")
    public Reporte crear(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String descripcion = body.get("descripcion");
        return service.generarReporte(id, descripcion);
    }

    @GetMapping("/user/{id}")
    public List<Reporte> obtener(@PathVariable Long id) {
        return service.obtenerPorUsuario(id);
    }

    @GetMapping("/download")
    public String descargar() {
        return "Simulando descarga de reportes (PDF/JSON).";
    }
}
