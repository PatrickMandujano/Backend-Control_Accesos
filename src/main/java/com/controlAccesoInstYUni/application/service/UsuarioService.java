package com.controlAccesoInstYUni.application.service;

import com.controlAccesoInstYUni.application.dto.usuario.UsuarioRequestDTO;
import com.controlAccesoInstYUni.application.dto.usuario.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {
    List<UsuarioResponseDTO> listar();
    UsuarioResponseDTO guardar(UsuarioRequestDTO requestDTO);
    UsuarioResponseDTO obtenerUsuarioPorId(Long id);
    UsuarioResponseDTO findByCodigoAcceso(String codAcceso);
    List<UsuarioResponseDTO> guardarUsuarios(List<UsuarioRequestDTO> requestDTO);
}
