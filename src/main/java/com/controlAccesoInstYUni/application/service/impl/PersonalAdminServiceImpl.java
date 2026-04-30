package com.controlAccesoInstYUni.application.service.impl;

import com.controlAccesoInstYUni.application.dto.personalAdministrativo.PersonalAdminRequestDTO;
import com.controlAccesoInstYUni.application.dto.personalAdministrativo.PersonalAdminResponseDTO;
import com.controlAccesoInstYUni.application.mapper.PersonalAdminMapper;
import com.controlAccesoInstYUni.application.service.PersonalAdminService;
import com.controlAccesoInstYUni.domain.entity.PersonalAdministrativo;
import com.controlAccesoInstYUni.domain.repository.PersonalAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalAdminServiceImpl implements PersonalAdminService {
private final PersonalAdminRepository personalAdminRepository;
private final PersonalAdminMapper personalAdminMapper;

    @Override
    public List<PersonalAdminResponseDTO> listar() {
        return personalAdminRepository.findAll().stream()
                .map(personalAdminMapper::toDto)
                .toList();
    }

    @Override
    public PersonalAdminResponseDTO guardar(PersonalAdminRequestDTO requestDTO) {
        PersonalAdministrativo personalAdministrativo=personalAdminMapper.toEntity(requestDTO);
        return personalAdminMapper.toDto(personalAdminRepository.save(personalAdministrativo));
    }

    @Override
    public PersonalAdminResponseDTO obtenerPersonalAdminPorID(Long id) {
        return personalAdminRepository.findById(id)
                .map(personalAdminMapper::toDto)
                .orElseThrow(()->new RuntimeException("No existe personal administrativo con ID: " + id));
    }
}
