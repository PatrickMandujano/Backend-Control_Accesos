package com.controlAccesoInstYUni.application.dto.carrera;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarreraResponseDTO {
    private Long id;
    private String nomCarrera;
    private String nomFacutad;
}
