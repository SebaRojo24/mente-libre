package com.mentelibre.personalization_service.config;

import com.mentelibre.personalization_service.model.PreferenciaUsuario;
import com.mentelibre.personalization_service.repository.PreferenciaUsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(PreferenciaUsuarioRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new PreferenciaUsuario(null, 1L, "es", "blanco", "14px"));
                repository.save(new PreferenciaUsuario(null, 2L, "en", "negro", "16px"));
                repository.save(new PreferenciaUsuario(null, 3L, "fr", "azul", "12px"));
            }
        };
    }
}
