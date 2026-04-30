package com.controlAccesoInstYUni.application.service;

import com.controlAccesoInstYUni.application.dto.docente.DocenteRequestDTO;
import com.controlAccesoInstYUni.application.dto.docente.DocenteResponseDTO;

import java.util.List;

public interface DocenteService {
    List<DocenteResponseDTO> listar();
    DocenteResponseDTO guardar(DocenteRequestDTO requestDTO);
    DocenteResponseDTO obtenerDocentePorID(Long id);
}
