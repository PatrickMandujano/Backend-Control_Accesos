package com.controlAccesoInstYUni.application.service;

import com.controlAccesoInstYUni.application.dto.estudiante.EstudianteRequestDTO;
import com.controlAccesoInstYUni.application.dto.estudiante.EstudianteResponseDTO;

import java.util.List;

public interface EstudianteService {
    List<EstudianteResponseDTO> listar();
    EstudianteResponseDTO guardar(EstudianteRequestDTO requestDTO);
    EstudianteResponseDTO obtenerEstudiantePorID(Long id);
}
