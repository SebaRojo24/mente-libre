package com.mentelibre.report_service.config;

import com.mentelibre.report_service.model.Reporte;
import com.mentelibre.report_service.repository.ReporteRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Profile("dev") // Solo se ejecuta con perfil 'dev'
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ReporteRepository reporteRepository;

    @Override
    public void run(String... args) {
        Faker faker = new Faker();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            Reporte reporte = new Reporte();
            reporte.setUsuarioId((long) random.nextInt(1, 10)); // 1 a 10
            reporte.setDescripcion(faker.lorem().sentence());
            reporte.setFecha(LocalDate.now().minusDays(random.nextInt(30))); // Últimos 30 días
            reporteRepository.save(reporte);
        }

        System.out.println("✅ Datos de prueba insertados correctamente");
    }
}
