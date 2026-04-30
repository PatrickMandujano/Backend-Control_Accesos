package com.controlAccesoInstYUni.application.mapper;

import com.controlAccesoInstYUni.application.dto.personalAdministrativo.PersonalAdminRequestDTO;
import com.controlAccesoInstYUni.application.dto.personalAdministrativo.PersonalAdminResponseDTO;
import com.controlAccesoInstYUni.domain.entity.PersonalAdministrativo;
import org.springframework.stereotype.Component;

@Component
public class PersonalAdminMapper{
    public PersonalAdminResponseDTO toDto(PersonalAdministrativo personalAministrativo){
        return PersonalAdminResponseDTO.builder()
                .idUsuario(personalAministrativo.getUsuario().getId())
                .nombres(personalAministrativo.getUsuario().getNombres())
                .apellidos(personalAministrativo.getUsuario().getApellidos())
                .dni(personalAministrativo.getUsuario().getDni())
                .emailInst(personalAministrativo.getUsuario().getEmailInst())
                .estado(personalAministrativo.getUsuario().getEstado())
                .area(personalAministrativo.getArea())
                .cargo(personalAministrativo.getCargo())
                .build();
    }

    public PersonalAdministrativo toEntity(PersonalAdminRequestDTO requestDTO){
        return PersonalAdministrativo.builder()
                .id(requestDTO.getIdUsuario())
                .area(requestDTO.getArea())
                .cargo(requestDTO.getCargo())
                .build();
    }
}

