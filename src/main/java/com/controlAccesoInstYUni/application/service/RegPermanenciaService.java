package com.controlAccesoInstYUni.application.service;

import com.controlAccesoInstYUni.application.dto.registroPermanencia.RegPermanenciaRequestDTO;
import com.controlAccesoInstYUni.application.dto.registroPermanencia.RegPermanenciaResponseDTO;

import java.util.List;

public interface RegPermanenciaService {
    List<RegPermanenciaResponseDTO> listarRegPermanencia();

    RegPermanenciaResponseDTO obtenerRegPermanenciaPorID(Long id);
    RegPermanenciaResponseDTO registrarEntrada(RegPermanenciaRequestDTO requestDTO);
    RegPermanenciaResponseDTO registrarSalida(RegPermanenciaRequestDTO requestDTO);

}
