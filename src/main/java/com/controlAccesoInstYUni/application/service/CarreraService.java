package com.controlAccesoInstYUni.application.service;

import com.controlAccesoInstYUni.application.dto.carrera.CarreraRequestDTO;
import com.controlAccesoInstYUni.application.dto.carrera.CarreraResponseDTO;


import java.util.List;

public interface CarreraService {
        List<CarreraResponseDTO> listar();
        CarreraResponseDTO guardar(CarreraRequestDTO requestDto);
        CarreraResponseDTO listarPorId(Long id);
        List<CarreraResponseDTO> guardarCarreras(List<CarreraRequestDTO> requestDTO);

}
