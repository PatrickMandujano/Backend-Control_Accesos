package com.controlAccesoInstYUni.application.service.impl;

import com.controlAccesoInstYUni.application.dto.carrera.CarreraRequestDTO;
import com.controlAccesoInstYUni.application.dto.carrera.CarreraResponseDTO;
import com.controlAccesoInstYUni.application.dto.facultad.FacultadResponseDTO;
import com.controlAccesoInstYUni.application.mapper.CarreraMapper;
import com.controlAccesoInstYUni.application.mapper.FacultadMapper;
import com.controlAccesoInstYUni.application.service.CarreraService;
import com.controlAccesoInstYUni.application.service.FacultadService;
import com.controlAccesoInstYUni.domain.entity.Carrera;
import com.controlAccesoInstYUni.domain.entity.Facultad;
import com.controlAccesoInstYUni.domain.repository.CarreraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarreraServiceImpl implements CarreraService {
    private final CarreraRepository carreraRepository;
    private final CarreraMapper carreraMapper;
    private final FacultadService facultadService;
    private final FacultadMapper facultadMapper;
    @Override
    public List<CarreraResponseDTO> listar() {
        return carreraRepository.findAll().stream()
                .map(carreraMapper::toDto)
                .toList();
    }

    @Override
    public CarreraResponseDTO guardar(CarreraRequestDTO requestDTO) {
        FacultadResponseDTO facultadResponseDTO=facultadService.obtenerFacultadPorId(requestDTO.getFacultadId());
        Facultad facultad=facultadMapper.toEntityFacultad(facultadResponseDTO);
        Carrera carrera=carreraMapper.toEntity(requestDTO, facultad);
        return carreraMapper.toDto(carreraRepository.save(carrera));
    }

    @Override
    public CarreraResponseDTO listarPorId(Long id) {
        return carreraRepository.findById(id)
                .map(carreraMapper::toDto)
                .orElseThrow(() -> new RuntimeException("No hay carreras con el id : " + id));
    }

    @Override
    public List<CarreraResponseDTO> guardarCarreras(List<CarreraRequestDTO> requestDTO) {
        List<Carrera> carreras = requestDTO.stream()
                .map(dto -> {
                    FacultadResponseDTO facultadResponseDTO = facultadService.obtenerFacultadPorId(dto.getFacultadId());
                    Facultad facultad = facultadMapper.toEntityFacultad(facultadResponseDTO);
                    return carreraMapper.toEntity(dto, facultad);
                })
                .collect(Collectors.toList());

        List<Carrera> carrerasGuardadas = carreraRepository.saveAll(carreras);

        return carrerasGuardadas.stream()
                .map(carreraMapper::toDto)
                .collect(Collectors.toList());
    }
}
