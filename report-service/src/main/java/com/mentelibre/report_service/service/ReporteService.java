package com.mentelibre.report_service.service;

import com.mentelibre.report_service.model.Reporte;
import com.mentelibre.report_service.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository repository;

    public Reporte generarReporte(Long usuarioId, String descripcion) {
        Reporte reporte = new Reporte();
        reporte.setUsuarioId(usuarioId);
        reporte.setDescripcion(descripcion);
        reporte.setFecha(LocalDate.now());
        return repository.save(reporte);
    }

    public List<Reporte> obtenerPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }
}
