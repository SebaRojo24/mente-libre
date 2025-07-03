package com.mentelibre.auth_service;

import com.mentelibre.auth_service.model.Usuario;
import com.mentelibre.auth_service.repository.UsuarioRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Profile("test") // Solo se ejecuta si activas el perfil "dev"
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(new Locale("es"));

        for (int i = 0; i < 10; i++) {
            String rawPassword = faker.internet().password(6, 12);

            Usuario usuario = new Usuario();
            usuario.setEmail(faker.internet().emailAddress());
            usuario.setPassword(passwordEncoder.encode(rawPassword));

            usuarioRepository.save(usuario);

            System.out.println("👤 Usuario generado → Email: " + usuario.getEmail() + " | Password: " + rawPassword);
        }

        System.out.println("✅ Se insertaron usuarios de prueba en la base de datos.");
    }
}
