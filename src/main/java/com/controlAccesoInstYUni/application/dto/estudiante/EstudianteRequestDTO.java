package com.controlAccesoInstYUni.application.dto.estudiante;

import lombok.Data;

@Data
public class EstudianteRequestDTO {
    private Long idUsuario;
    private Long idCarrera;
    private Integer anoIngreso;

}
