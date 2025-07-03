package com.mentelibre.auth_service;

import com.mentelibre.auth_service.model.Usuario;
import com.mentelibre.auth_service.repository.UsuarioRepository;
import com.mentelibre.auth_service.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registrarUsuario_deberiaGuardarUsuario() {
        Usuario usuario = new Usuario(null, "test@correo.com", "password123");

        when(usuarioRepository.existsByEmail(usuario.getEmail())).thenReturn(false);
        when(passwordEncoder.encode(usuario.getPassword())).thenReturn("hashed123");
        when(usuarioRepository.save(any(Usuario.class))).thenAnswer(i -> i.getArgument(0));

        Usuario resultado = usuarioService.registrarUsuario(usuario);

        assertEquals("test@correo.com", resultado.getEmail());
        assertEquals("hashed123", resultado.getPassword());
        verify(usuarioRepository).save(any(Usuario.class));
    }

    @Test
    void login_deberiaRetornarUsuarioSiCredencialesSonCorrectas() {
        String rawPassword = "password123";
        String hashedPassword = "hashed123";

        Usuario usuario = new Usuario(1L, "correo@dominio.com", hashedPassword);

        when(usuarioRepository.findByEmail(usuario.getEmail())).thenReturn(Optional.of(usuario));
        when(passwordEncoder.matches(rawPassword, hashedPassword)).thenReturn(true);

        Usuario resultado = usuarioService.login(usuario.getEmail(), rawPassword);

        assertEquals(usuario.getEmail(), resultado.getEmail());
    }

    @Test
    void login_conPasswordIncorrecta_deberiaLanzarExcepcion() {
        Usuario usuario = new Usuario(1L, "correo@dominio.com", "hashed123");

        when(usuarioRepository.findByEmail(usuario.getEmail())).thenReturn(Optional.of(usuario));
        when(passwordEncoder.matches("wrongPass", "hashed123")).thenReturn(false);

        assertThrows(RuntimeException.class, () ->
                usuarioService.login(usuario.getEmail(), "wrongPass"));
    }
}
