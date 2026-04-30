package com.controlAccesoInstYUni.application.service.impl;

import com.controlAccesoInstYUni.application.dto.carrera.CarreraResponseDTO;
import com.controlAccesoInstYUni.application.dto.estudiante.EstudianteRequestDTO;
import com.controlAccesoInstYUni.application.dto.estudiante.EstudianteResponseDTO;
import com.controlAccesoInstYUni.application.mapper.CarreraMapper;
import com.controlAccesoInstYUni.application.mapper.EstudianteMapper;
import com.controlAccesoInstYUni.application.service.CarreraService;
import com.controlAccesoInstYUni.application.service.EstudianteService;
import com.controlAccesoInstYUni.domain.entity.Carrera;
import com.controlAccesoInstYUni.domain.entity.Estudiante;
import com.controlAccesoInstYUni.domain.repository.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudianteRepository estudianteRepository;
    private final EstudianteMapper estudianteMapper;
    private final CarreraService carreraService;
    private final CarreraMapper carreraMapper;
    @Override
    public List<EstudianteResponseDTO> listar() {
        return estudianteRepository.findAll().stream()
                .map(estudianteMapper::toDto)
                .toList();
    }

    @Override
    public EstudianteResponseDTO guardar(EstudianteRequestDTO requestDTO) {
        CarreraResponseDTO carreraResponseDTO=carreraService.listarPorId(requestDTO.getIdCarrera());
        Carrera carrera=carreraMapper.toEntityResponse(carreraResponseDTO);
        Estudiante estudiante=estudianteMapper.toEntity(requestDTO, carrera);
        return estudianteMapper.toDto(estudianteRepository.save(estudiante));
    }

    @Override
    public EstudianteResponseDTO obtenerEstudiantePorID(Long id) {
        return estudianteRepository.findById(id)
                .map(estudianteMapper::toDto)
                .orElseThrow(()->new RuntimeException("No existe estudiante con ID: " + id));
    }
}
