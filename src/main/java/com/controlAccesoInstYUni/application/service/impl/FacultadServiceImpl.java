package com.controlAccesoInstYUni.application.service.impl;

import com.controlAccesoInstYUni.application.dto.facultad.FacultadRequestDTO;
import com.controlAccesoInstYUni.application.dto.facultad.FacultadResponseDTO;
import com.controlAccesoInstYUni.application.mapper.FacultadMapper;
import com.controlAccesoInstYUni.application.service.FacultadService;
import com.controlAccesoInstYUni.domain.entity.Facultad;
import com.controlAccesoInstYUni.domain.entity.Usuario;
import com.controlAccesoInstYUni.domain.repository.FacultadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FacultadServiceImpl implements FacultadService {
    private final FacultadRepository repository;
    private final FacultadMapper mapper;
    @Override
    public List<FacultadResponseDTO> listar() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public FacultadResponseDTO guardar(FacultadRequestDTO requestDto) {
        Facultad facultad=mapper.toEntity(requestDto);
        return mapper.toDto(repository.save(facultad));
    }

    @Override
    public FacultadResponseDTO obtenerFacultadPorId(Long id) {
        return repository.findById(id).
                map(mapper::toDto).orElseThrow(()-> new RuntimeException("No existe la facultad con ID : " + id));
    }

    @Override
    public List<FacultadResponseDTO> guardarFacultades(List<FacultadRequestDTO> requestDTO) {
        List<Facultad> facultades = requestDTO.stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());

        List<Facultad> facultadesGuardadas = repository.saveAll(facultades);

        return facultadesGuardadas.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
