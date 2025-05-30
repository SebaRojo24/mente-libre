package com.mentelibre.mood_tracker_service.service;

import com.mentelibre.mood_tracker_service.model.EstadoAnimo;
import com.mentelibre.mood_tracker_service.repository.EstadoAnimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import com.mentelibre.mood_tracker_service.model.EstadoAnimo;
import com.mentelibre.mood_tracker_service.repository.EstadoAnimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoAnimoService {

    @Autowired
    private EstadoAnimoRepository repository;

    public EstadoAnimo registrarEstado(Long usuarioId, String estado) {
        LocalDate hoy = LocalDate.now();

        Optional<EstadoAnimo> existente = repository.findByUsuarioIdAndFecha(usuarioId, hoy);
        if (existente.isPresent()) {
            throw new RuntimeException("Ya existe un estado registrado para hoy");
        }

        EstadoAnimo nuevo = new EstadoAnimo();
        nuevo.setUsuarioId(usuarioId);
        nuevo.setEstado(estado);
        nuevo.setFecha(hoy);

        return repository.save(nuevo);
    }

    public Optional<EstadoAnimo> obtenerEstadoHoy(Long usuarioId) {
        return repository.findByUsuarioIdAndFecha(usuarioId, LocalDate.now());
    }
    public List<EstadoAnimo> obtenerTodosPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }
}
