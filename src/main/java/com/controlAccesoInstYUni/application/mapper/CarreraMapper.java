package com.controlAccesoInstYUni.application.mapper;

import com.controlAccesoInstYUni.application.dto.carrera.CarreraRequestDTO;
import com.controlAccesoInstYUni.application.dto.carrera.CarreraResponseDTO;
import com.controlAccesoInstYUni.domain.entity.Carrera;
import com.controlAccesoInstYUni.domain.entity.Facultad;
import org.springframework.stereotype.Component;

@Component
public class CarreraMapper {
    public CarreraResponseDTO toDto(Carrera carrera){
        return CarreraResponseDTO.builder()
                .id(carrera.getId())
                .nomCarrera(carrera.getNomCarrera())
                .nomFacutad(carrera.getFacultad().getNomFacultad())
                .build();
    }

    public Carrera toEntity(CarreraRequestDTO dto, Facultad facultad){
        return Carrera.builder()
                .nomCarrera(dto.getNomCarrera())
                .facultad(facultad)
                .build();
    }
    public Carrera toEntityResponse(CarreraResponseDTO carreraResponseDTO){
        return Carrera.builder()
                .id(carreraResponseDTO.getId())
                .nomCarrera(carreraResponseDTO.getNomCarrera())

                .build();
    }
}
