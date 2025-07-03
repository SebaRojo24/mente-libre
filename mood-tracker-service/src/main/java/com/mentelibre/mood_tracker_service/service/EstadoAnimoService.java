package com.mentelibre.mood_tracker_service.service;

import com.mentelibre.mood_tracker_service.model.EstadoAnimo;
import com.mentelibre.mood_tracker_service.repository.EstadoAnimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoAnimoService {

    @Autowired
    private EstadoAnimoRepository repository;

    public EstadoAnimo registrarEstado(Long usuarioId, String estado) {
        LocalDate hoy = LocalDate.now();
        if (repository.findByUsuarioIdAndFecha(usuarioId, hoy).isPresent()) {
            throw new RuntimeException("Ya existe un estado registrado para hoy");
        }
        return repository.save(new EstadoAnimo(null, usuarioId, estado, hoy));
    }

    public Optional<EstadoAnimo> obtenerEstadoHoy(Long usuarioId) {
        return repository.findByUsuarioIdAndFecha(usuarioId, LocalDate.now());
    }

    public List<EstadoAnimo> obtenerTodosPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public Optional<EstadoAnimo> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public EstadoAnimo actualizar(Long id, EstadoAnimo actualizado) {
        EstadoAnimo existente = repository.findById(id).orElseThrow();
        existente.setEstado(actualizado.getEstado());
        existente.setFecha(actualizado.getFecha());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
    public List<EstadoAnimo> obtenerTodos() {
        return repository.findAll();
    }
}
