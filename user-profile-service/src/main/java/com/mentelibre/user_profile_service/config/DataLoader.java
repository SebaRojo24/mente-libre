package com.mentelibre.user_profile_service.config;

import com.mentelibre.user_profile_service.model.PerfilUsuario;
import com.mentelibre.user_profile_service.service.PerfilUsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(PerfilUsuarioService service) {
        return args -> {
            if (service.obtenerTodos().isEmpty()) {
                service.crearPerfil(new PerfilUsuario( "Juan", "Pérez", 30, "Chile", "deportes, música"));
                service.crearPerfil(new PerfilUsuario("Ana", "García", 25, "Argentina", "cine, lectura"));
                service.crearPerfil(new PerfilUsuario("Luis", "Martínez", 28, "México", "viajes, tecnología"));
                // agrega más si quieres
            }
        };
    }
}
