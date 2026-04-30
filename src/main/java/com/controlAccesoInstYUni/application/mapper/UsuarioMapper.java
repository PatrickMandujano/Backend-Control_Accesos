package com.controlAccesoInstYUni.application.mapper;

import com.controlAccesoInstYUni.application.dto.usuario.UsuarioRequestDTO;
import com.controlAccesoInstYUni.application.dto.usuario.UsuarioResponseDTO;
import com.controlAccesoInstYUni.domain.entity.Estado;
import com.controlAccesoInstYUni.domain.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioResponseDTO toDto(Usuario usuario){
        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .codigoInstitucional(usuario.getCodigoInstitucional())
                .codigoAcceso(usuario.getCodigoAcceso())
                .rol(usuario.getRol())
                .nombres(usuario.getNombres())
                .apellidos(usuario.getApellidos())
                .dni(usuario.getDni())
                .emailInst(usuario.getEmailInst())
                .estado(usuario.getEstado())
                .build();
    }

    public Usuario toEntity(UsuarioRequestDTO requestDTO){
        return Usuario.builder()
                .codigoInstitucional(requestDTO.getCodigoInstitucional())
                .codigoAcceso(requestDTO.getCodigoAcceso())
                .rol(requestDTO.getRol())
                .nombres(requestDTO.getNombres())
                .apellidos(requestDTO.getApellidos())
                .dni(requestDTO.getDni())
                .emailInst(requestDTO.getEmailInst())
                .estado(requestDTO.getEstado())
                .build();
    }

}
