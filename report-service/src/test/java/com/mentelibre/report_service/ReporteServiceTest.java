package com.mentelibre.report_service;

import com.mentelibre.report_service.model.Reporte;
import com.mentelibre.report_service.repository.ReporteRepository;
import com.mentelibre.report_service.service.ReporteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReporteServiceTest {

    @Mock
    private ReporteRepository repository;

    @InjectMocks
    private ReporteService service;

    @Test
    void testGenerarReporte() {
        Reporte fake = new Reporte();
        fake.setUsuarioId(1L);
        fake.setDescripcion("Descripción de prueba");
        fake.setFecha(LocalDate.now());

        when(repository.save(any(Reporte.class))).thenReturn(fake);

        Reporte resultado = service.generarReporte(1L, "Descripción de prueba");

        assertNotNull(resultado);
        assertEquals(1L, resultado.getUsuarioId());
        assertEquals("Descripción de prueba", resultado.getDescripcion());
    }

    @Test
    void testObtenerTodos() {
        when(repository.findAll()).thenReturn(List.of(new Reporte()));

        List<Reporte> reportes = service.obtenerTodos();

        assertNotNull(reportes);
        assertEquals(1, reportes.size());
    }

    @Test
    void testObtenerPorUsuario() {
        when(repository.findByUsuarioId(2L)).thenReturn(List.of(new Reporte()));

        List<Reporte> result = service.obtenerPorUsuario(2L);

        assertEquals(1, result.size());
    }

    @Test
    void testObtenerPorIdExistente() {
        Reporte reporte = new Reporte();
        reporte.setId(5L);
        when(repository.findById(5L)).thenReturn(Optional.of(reporte));

        Optional<Reporte> resultado = service.obtenerPorId(5L);

        assertTrue(resultado.isPresent());
        assertEquals(5L, resultado.get().getId());
    }

    @Test
    void testActualizarReporte() {
        Reporte reporte = new Reporte();
        reporte.setId(10L);
        reporte.setDescripcion("Vieja");

        when(repository.findById(10L)).thenReturn(Optional.of(reporte));
        when(repository.save(any(Reporte.class))).thenReturn(reporte);

        Reporte actualizado = service.actualizarReporte(10L, "Nueva");

        assertEquals("Nueva", actualizado.getDescripcion());
    }

    @Test
    void testEliminarReporte() {
        Long id = 99L;

        service.eliminarReporte(id);

        verify(repository, times(1)).deleteById(id);
    }
}
