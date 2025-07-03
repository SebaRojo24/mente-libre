package com.mentelibre.auth_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mentelibre.auth_service.model.Usuario;
import com.mentelibre.auth_service.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthController.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @Autowired
    private ObjectMapper objectMapper;

    private Usuario usuarioEjemplo;

    @BeforeEach
    void setUp() {
        usuarioEjemplo = new Usuario(1L, "correo@ejemplo.com", "hashed123");
    }

    @Test
    void testRegistrar() throws Exception {
        Usuario entrada = new Usuario(null, "correo@ejemplo.com", "123456");

        Mockito.when(usuarioService.registrarUsuario(Mockito.any(Usuario.class)))
                .thenReturn(usuarioEjemplo);

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(entrada)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.email").value("correo@ejemplo.com"));
    }

    @Test
    void testLogin() throws Exception {
        Usuario entrada = new Usuario(null, "correo@ejemplo.com", "123456");

        Mockito.when(usuarioService.login("correo@ejemplo.com", "123456"))
                .thenReturn(usuarioEjemplo);

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(entrada)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.email").value("correo@ejemplo.com"));
    }

    @Test
    void testObtenerTodos() throws Exception {
        List<Usuario> lista = Arrays.asList(
                new Usuario(1L, "uno@correo.com", "pass1"),
                new Usuario(2L, "dos@correo.com", "pass2")
        );

        Mockito.when(usuarioService.obtenerTodos()).thenReturn(lista);

        mockMvc.perform(get("/auth/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].email").value("uno@correo.com"));
    }

    @Test
    void testObtenerPorId() throws Exception {
        Mockito.when(usuarioService.obtenerPorId(1L)).thenReturn(usuarioEjemplo);

        mockMvc.perform(get("/auth/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.email").value("correo@ejemplo.com"));
    }

    @Test
    void testActualizar() throws Exception {
        Usuario actualizado = new Usuario(1L, "nuevo@correo.com", "nuevaClave");

        Mockito.when(usuarioService.actualizarUsuario(Mockito.eq(1L), Mockito.any(Usuario.class)))
                .thenReturn(actualizado);

        mockMvc.perform(put("/auth/usuarios/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(actualizado)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("nuevo@correo.com"));
    }

    @Test
    void testEliminar() throws Exception {
        Mockito.doNothing().when(usuarioService).eliminarUsuario(1L);

        mockMvc.perform(delete("/auth/usuarios/1"))
                .andExpect(status().isOk());
    }
}