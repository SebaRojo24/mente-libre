package com.mentelibre.report_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mentelibre.report_service.controller.ReporteController;
import com.mentelibre.report_service.model.Reporte;
import com.mentelibre.report_service.service.ReporteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReporteController.class)
public class ReporteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReporteService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCrearReporte() throws Exception {
        Reporte mockReporte = new Reporte();
        mockReporte.setId(1L);
        mockReporte.setUsuarioId(1L);
        mockReporte.setDescripcion("Reporte falso");
        mockReporte.setFecha(LocalDate.now());

        Mockito.when(service.generarReporte(eq(1L), eq("Reporte falso"))).thenReturn(mockReporte);

        mockMvc.perform(post("/reportes/user/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"descripcion\":\"Reporte falso\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.usuarioId").value(1L))
                .andExpect(jsonPath("$.descripcion").value("Reporte falso"));
    }

    @Test
    void testObtenerTodos() throws Exception {
        Reporte r = new Reporte();
        r.setId(1L);
        r.setUsuarioId(1L);
        r.setDescripcion("Desc");
        r.setFecha(LocalDate.now());

        Mockito.when(service.obtenerTodos()).thenReturn(List.of(r));

        mockMvc.perform(get("/reportes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].descripcion").value("Desc"));
    }

    @Test
    void testObtenerPorId() throws Exception {
        Reporte r = new Reporte();
        r.setId(5L);
        r.setUsuarioId(2L);
        r.setDescripcion("Detalle");
        r.setFecha(LocalDate.now());

        Mockito.when(service.obtenerPorId(5L)).thenReturn(Optional.of(r));

        mockMvc.perform(get("/reportes/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(5L));
    }

    @Test
    void testActualizarReporte() throws Exception {
        Reporte r = new Reporte();
        r.setId(7L);
        r.setUsuarioId(1L);
        r.setDescripcion("Actualizado");
        r.setFecha(LocalDate.now());

        Mockito.when(service.actualizarReporte(eq(7L), eq("Actualizado"))).thenReturn(r);

        mockMvc.perform(put("/reportes/7")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"descripcion\":\"Actualizado\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.descripcion").value("Actualizado"));
    }

    @Test
    void testEliminarReporte() throws Exception {
        mockMvc.perform(delete("/reportes/8"))
                .andExpect(status().isOk());

        Mockito.verify(service).eliminarReporte(8L);
    }
}
