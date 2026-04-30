package com.controlAccesoInstYUni.application.mapper;

import com.controlAccesoInstYUni.application.dto.facultad.FacultadRequestDTO;
import com.controlAccesoInstYUni.application.dto.facultad.FacultadResponseDTO;
import com.controlAccesoInstYUni.domain.entity.Facultad;
import org.springframework.stereotype.Component;

@Component
public class FacultadMapper {
    public FacultadResponseDTO toDto(Facultad facultad){
        return FacultadResponseDTO.builder()
                .id(facultad.getId())
                .nomFacultad(facultad.getNomFacultad())
                .build();
    }

    public Facultad toEntity(FacultadRequestDTO requestDTO){
        return Facultad.builder()
                .nomFacultad(requestDTO.getNomFacultad())
                .build();
    }

    public Facultad toEntityFacultad(FacultadResponseDTO facultadResponseDTO){
        return Facultad.builder()
                .id(facultadResponseDTO.getId())
                .nomFacultad(facultadResponseDTO.getNomFacultad())
                .build();
    }
}
