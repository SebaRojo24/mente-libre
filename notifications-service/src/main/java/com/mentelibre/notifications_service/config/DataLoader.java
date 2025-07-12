package com.mentelibre.notifications_service.config;

import com.mentelibre.notifications_service.model.Notificacion;
import com.mentelibre.notifications_service.repository.NotificacionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final NotificacionRepository repository;

    public DataLoader(NotificacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Limpia la tabla para evitar duplicados si quieres
        repository.deleteAll();

        // Crear notificaciones de ejemplo
        Notificacion n1 = new Notificacion();
        n1.setUsuarioId(1L);
        n1.setMensaje("Bienvenido a Mente Libre!");
        n1.setFechaHora(LocalDateTime.now().minusDays(2));
        n1.setEnviada(true);

        Notificacion n2 = new Notificacion();
        n2.setUsuarioId(2L);
        n2.setMensaje("Recuerda completar tu perfil.");
        n2.setFechaHora(LocalDateTime.now().minusHours(5));
        n2.setEnviada(false);

        Notificacion n3 = new Notificacion();
        n3.setUsuarioId(1L);
        n3.setMensaje("Nueva actualización disponible.");
        n3.setFechaHora(LocalDateTime.now());
        n3.setEnviada(false);

        // Guardar en la BD
        repository.save(n1);
        repository.save(n2);
        repository.save(n3);

        System.out.println("DataLoader: Datos de notificaciones precargados.");
    }
}
