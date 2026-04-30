package com.controlAccesoInstYUni.application.dto.usuario;

import com.controlAccesoInstYUni.domain.entity.Estado;
import com.controlAccesoInstYUni.domain.entity.MotivoInactividad;
import com.controlAccesoInstYUni.domain.entity.Rol;
import lombok.Data;

@Data
public class UsuarioRequestDTO {
    private String codigoInstitucional;
    private String codigoAcceso;
    private Rol rol;
    private String nombres;
    private String apellidos;
    private String dni;
    private String emailInst;
    private Estado estado;
}
