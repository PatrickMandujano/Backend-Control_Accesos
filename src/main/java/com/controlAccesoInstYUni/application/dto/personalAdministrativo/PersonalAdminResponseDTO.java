package com.controlAccesoInstYUni.application.dto.personalAdministrativo;

import com.controlAccesoInstYUni.domain.entity.Estado;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalAdminResponseDTO {
    private Long idUsuario;
    private String codigoInstitucional;
    private String nombres;
    private String apellidos;
    private String dni;
    private String emailInst;
    private Estado estado;
    private String area;
    private String cargo;
}
