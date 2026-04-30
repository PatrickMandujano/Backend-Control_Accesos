package com.controlAccesoInstYUni.application.dto.facultad;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FacultadResponseDTO {
    private Long id;
    private String nomFacultad;
}
