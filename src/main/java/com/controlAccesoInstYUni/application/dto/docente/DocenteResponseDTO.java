package com.controlAccesoInstYUni.application.dto.docente;

import com.controlAccesoInstYUni.domain.entity.Estado;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocenteResponseDTO {
    private Long idUsuario;
    private String codigoInstitucional;
    private String nombres;
    private String apellidos;
    private String dni;
    private String emailInst;
    private Estado estado;
    private String especialidad;

}
