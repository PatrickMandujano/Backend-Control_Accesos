package com.controlAccesoInstYUni.application.mapper;

import com.controlAccesoInstYUni.application.dto.puntoControl.PuntoControlRequestDTO;
import com.controlAccesoInstYUni.application.dto.puntoControl.PuntoControlResponseDTO;
import com.controlAccesoInstYUni.domain.entity.PuntoControl;
import org.springframework.stereotype.Component;

@Component
public class PuntoControlMapper {
    public PuntoControlResponseDTO toDto(PuntoControl puntoControl){
        return PuntoControlResponseDTO.builder()
                .id(puntoControl.getId())
                .nombre(puntoControl.getNombre())
                .tipoPuntoControl(puntoControl.getTipoPuntoControl())
                .build();
    }

    public PuntoControl toEntity(PuntoControlRequestDTO requestDTO){
        return PuntoControl.builder()
                .nombre(requestDTO.getNombre())
                .tipoPuntoControl(requestDTO.getTipoPuntoControl())
                .build();
    }
}
