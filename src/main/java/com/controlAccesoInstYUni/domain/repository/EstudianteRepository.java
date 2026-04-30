package com.controlAccesoInstYUni.domain.repository;

import com.controlAccesoInstYUni.domain.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
