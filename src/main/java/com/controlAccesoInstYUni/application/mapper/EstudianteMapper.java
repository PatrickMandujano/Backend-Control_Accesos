package com.controlAccesoInstYUni.application.mapper;

import com.controlAccesoInstYUni.application.dto.estudiante.EstudianteRequestDTO;
import com.controlAccesoInstYUni.application.dto.estudiante.EstudianteResponseDTO;
import com.controlAccesoInstYUni.domain.entity.Carrera;
import com.controlAccesoInstYUni.domain.entity.Estado;
import com.controlAccesoInstYUni.domain.entity.Estudiante;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper {
    public EstudianteResponseDTO toDto(Estudiante estudiante){
        return EstudianteResponseDTO.builder()
                .idUsuario(estudiante.getUsuario().getId())
                .nombres(estudiante.getUsuario().getNombres())
                .apellidos(estudiante.getUsuario().getApellidos())
                .dni(estudiante.getUsuario().getDni())
                .emailInst(estudiante.getUsuario().getEmailInst())
                .nomCarrera(estudiante.getCarrera().getNomCarrera())
                .nomFacultad(estudiante.getCarrera().getFacultad().getNomFacultad())
                .anoIngreso(estudiante.getAnoIngreso())
                .estado(estudiante.getUsuario().getEstado())
                .build();
    }

    public Estudiante toEntity(EstudianteRequestDTO requestDTO, Carrera carrera){
        return Estudiante.builder()
                .id(requestDTO.getIdUsuario())
                .carrera(carrera)
                .anoIngreso(requestDTO.getAnoIngreso())
                .build();
    }
}
