package com.controlAccesoInstYUni.application.service.impl;


import com.controlAccesoInstYUni.application.dto.docente.DocenteRequestDTO;
import com.controlAccesoInstYUni.application.dto.docente.DocenteResponseDTO;
import com.controlAccesoInstYUni.application.mapper.DocenteMapper;
import com.controlAccesoInstYUni.application.service.DocenteService;
import com.controlAccesoInstYUni.domain.entity.Docente;
import com.controlAccesoInstYUni.domain.repository.DocenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocenteServiceImpl implements DocenteService {
    private final DocenteRepository docenteRepository;
    private final DocenteMapper docenteMapper;

    @Override
    public List<DocenteResponseDTO> listar() {
        return docenteRepository.findAll().stream()
                .map(docenteMapper::toDto)
                .toList() ;
    }

    @Override
    public DocenteResponseDTO guardar(DocenteRequestDTO requestDTO) {
        Docente docente=docenteMapper.toEntity(requestDTO);
        return  docenteMapper.toDto(docenteRepository.save(docente));
    }

    @Override
    public DocenteResponseDTO obtenerDocentePorID(Long id) {
        return docenteRepository.findById(id)
                .map(docenteMapper::toDto)
                .orElseThrow(()->new RuntimeException("No existe docente con ID: " + id));
    }
}
