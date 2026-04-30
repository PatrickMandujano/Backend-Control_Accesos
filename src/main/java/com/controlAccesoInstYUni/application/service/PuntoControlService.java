package com.controlAccesoInstYUni.application.service;

import com.controlAccesoInstYUni.application.dto.puntoControl.PuntoControlRequestDTO;
import com.controlAccesoInstYUni.application.dto.puntoControl.PuntoControlResponseDTO;
import com.controlAccesoInstYUni.application.dto.usuario.UsuarioRequestDTO;
import com.controlAccesoInstYUni.application.dto.usuario.UsuarioResponseDTO;

import java.util.List;

public interface PuntoControlService {
    List<PuntoControlResponseDTO>listarPuntosControl();
    PuntoControlResponseDTO guardar(PuntoControlRequestDTO requestDTO);
    PuntoControlResponseDTO obtenerPuntoControlPorId(Long id);
    void eliminar(Long id);
    List<PuntoControlResponseDTO> guardarPuntosControl(List<PuntoControlRequestDTO> requestDTO);

}
