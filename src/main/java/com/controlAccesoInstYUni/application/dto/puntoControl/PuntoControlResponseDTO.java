package com.controlAccesoInstYUni.application.dto.puntoControl;

import com.controlAccesoInstYUni.domain.entity.TipoPuntoControl;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PuntoControlResponseDTO {
    private Long id;
    private String nombre;
    private TipoPuntoControl tipoPuntoControl;
}
