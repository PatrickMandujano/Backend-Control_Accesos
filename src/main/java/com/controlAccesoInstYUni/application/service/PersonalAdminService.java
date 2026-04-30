package com.controlAccesoInstYUni.application.service;

import com.controlAccesoInstYUni.application.dto.personalAdministrativo.PersonalAdminRequestDTO;
import com.controlAccesoInstYUni.application.dto.personalAdministrativo.PersonalAdminResponseDTO;

import java.util.List;

public interface PersonalAdminService {
    List<PersonalAdminResponseDTO> listar();
    PersonalAdminResponseDTO guardar(PersonalAdminRequestDTO requestDTO);
    PersonalAdminResponseDTO obtenerPersonalAdminPorID(Long id);
}
