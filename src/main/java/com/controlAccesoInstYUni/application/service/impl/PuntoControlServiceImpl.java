
package com.controlAccesoInstYUni.application.service.impl;

import com.controlAccesoInstYUni.application.dto.puntoControl.PuntoControlRequestDTO;
import com.controlAccesoInstYUni.application.dto.puntoControl.PuntoControlResponseDTO;
import com.controlAccesoInstYUni.application.mapper.PuntoControlMapper;
import com.controlAccesoInstYUni.application.service.PuntoControlService;
import com.controlAccesoInstYUni.domain.entity.PuntoControl;
import com.controlAccesoInstYUni.domain.entity.Usuario;
import com.controlAccesoInstYUni.domain.repository.PuntoControlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PuntoControlServiceImpl implements PuntoControlService {
private final PuntoControlRepository puntoControlRepository;
private final PuntoControlMapper puntoControlMapper;
    @Override
    public List<PuntoControlResponseDTO> listarPuntosControl() {
        return puntoControlRepository.findAll().stream()
                .map(puntoControlMapper::toDto)
                .toList();
    }

    @Override
    public PuntoControlResponseDTO guardar(PuntoControlRequestDTO requestDTO) {
        PuntoControl puntoControl=puntoControlMapper.toEntity(requestDTO);
        return puntoControlMapper.toDto(puntoControlRepository.save(puntoControl));
    }

    @Override
    public PuntoControlResponseDTO obtenerPuntoControlPorId(Long id) {
        return puntoControlRepository.findById(id)
                .map(puntoControlMapper::toDto)
                .orElseThrow(()->new RuntimeException("Punto control no existente"));

    }

    @Override
    public void eliminar(Long id) {
        if(!puntoControlRepository.existsById(id)){
            throw new RuntimeException("No existe punto de control con ID : " + id);
        }
        puntoControlRepository.deleteById(id);
    }

    @Override
    public List<PuntoControlResponseDTO> guardarPuntosControl(List<PuntoControlRequestDTO> requestDTO) {
        List<PuntoControl> puntosControl = requestDTO.stream()
                .map(puntoControlMapper::toEntity)
                .collect(Collectors.toList());

        List<PuntoControl> puntosControlGuardados = puntoControlRepository.saveAll(puntosControl);

        return puntosControlGuardados.stream()
                .map(puntoControlMapper::toDto)
                .collect(Collectors.toList());
    }
    }


