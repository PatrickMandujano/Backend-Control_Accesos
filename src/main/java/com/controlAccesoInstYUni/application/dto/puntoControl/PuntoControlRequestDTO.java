package com.controlAccesoInstYUni.application.dto.puntoControl;

import com.controlAccesoInstYUni.domain.entity.TipoPuntoControl;
import lombok.Data;

@Data
public class PuntoControlRequestDTO {
    private String nombre;
    private TipoPuntoControl tipoPuntoControl;
}
