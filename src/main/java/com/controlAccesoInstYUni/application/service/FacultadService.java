package com.controlAccesoInstYUni.application.service;

import com.controlAccesoInstYUni.application.dto.facultad.FacultadRequestDTO;
import com.controlAccesoInstYUni.application.dto.facultad.FacultadResponseDTO;
import com.controlAccesoInstYUni.application.dto.usuario.UsuarioRequestDTO;
import com.controlAccesoInstYUni.application.dto.usuario.UsuarioResponseDTO;

import java.util.List;

public interface FacultadService {
    List<FacultadResponseDTO> listar();
    FacultadResponseDTO guardar(FacultadRequestDTO requestDto);
    FacultadResponseDTO obtenerFacultadPorId(Long id);
    List<FacultadResponseDTO> guardarFacultades(List<FacultadRequestDTO> requestDTO);

}
