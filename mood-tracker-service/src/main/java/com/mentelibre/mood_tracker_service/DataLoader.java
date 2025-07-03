package com.mentelibre.mood_tracker_service.config;

import com.mentelibre.mood_tracker_service.model.EstadoAnimo;
import com.mentelibre.mood_tracker_service.repository.EstadoAnimoRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Profile("dev") // Se ejecuta solo con perfil 'dev'
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EstadoAnimoRepository estadoAnimoRepository;

    private final Faker faker = new Faker();
    private final Random random = new Random();

    private final String[] emociones = {
            "Feliz", "Triste", "Ansioso", "Enojado", "Motivado", "Agradecido", "Frustrado", "Conectado", "Cansado"
    };

    @Override
    public void run(String... args) {
        if (estadoAnimoRepository.count() > 0) return;

        for (long usuarioId = 1; usuarioId <= 5; usuarioId++) {
            for (int i = 0; i < 5; i++) {
                LocalDate fecha = LocalDate.now().minusDays(i);
                String estado = emociones[random.nextInt(emociones.length)];

                EstadoAnimo estadoAnimo = new EstadoAnimo();
                estadoAnimo.setUsuarioId(usuarioId);
                estadoAnimo.setEstado(estado);
                estadoAnimo.setFecha(fecha);

                estadoAnimoRepository.save(estadoAnimo);
            }
        }
    }
}
