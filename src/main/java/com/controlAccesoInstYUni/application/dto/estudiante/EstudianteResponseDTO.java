package com.controlAccesoInstYUni.application.dto.estudiante;

import com.controlAccesoInstYUni.domain.entity.Estado;
import com.controlAccesoInstYUni.domain.entity.Rol;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EstudianteResponseDTO {
    private Long idUsuario;
    private String nombres;
    private String apellidos;
    private String dni;
    private String emailInst;
    private Estado estado;
    private String nomCarrera;
    private String nomFacultad;
    private Integer anoIngreso;
}
