package com.controlAccesoInstYUni.application.dto.personalAdministrativo;

import lombok.Data;

@Data
public class PersonalAdminRequestDTO {
    private Long idUsuario;
    private String area;
    private String cargo;
}
