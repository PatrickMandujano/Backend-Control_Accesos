package com.controlAccesoInstYUni.application.mapper;

import com.controlAccesoInstYUni.application.dto.docente.DocenteRequestDTO;
import com.controlAccesoInstYUni.application.dto.docente.DocenteResponseDTO;
import com.controlAccesoInstYUni.domain.entity.Docente;
import org.springframework.stereotype.Component;

@Component
public class DocenteMapper {
    public DocenteResponseDTO toDto(Docente docente){
        return DocenteResponseDTO.builder()
                .idUsuario(docente.getUsuario().getId())
                .codigoInstitucional(docente.getUsuario().getCodigoInstitucional())
                .nombres(docente.getUsuario().getNombres())
                .apellidos(docente.getUsuario().getApellidos())
                .dni(docente.getUsuario().getDni())
                .emailInst(docente.getUsuario().getEmailInst())
                .estado(docente.getUsuario().getEstado())
                .especialidad(docente.getEspecialidad())
                .build();
    }

    public Docente toEntity(DocenteRequestDTO requestDTO){
        return Docente.builder()
                .id(requestDTO.getIdUsuario())
                .especialidad(requestDTO.getEspecialidad())
                .build();
    }
}
