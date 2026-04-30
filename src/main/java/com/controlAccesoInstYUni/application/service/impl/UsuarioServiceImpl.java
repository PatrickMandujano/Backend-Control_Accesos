package com.controlAccesoInstYUni.application.service.impl;

import com.controlAccesoInstYUni.application.dto.carrera.CarreraResponseDTO;
import com.controlAccesoInstYUni.application.dto.facultad.FacultadResponseDTO;
import com.controlAccesoInstYUni.application.dto.usuario.UsuarioRequestDTO;
import com.controlAccesoInstYUni.application.dto.usuario.UsuarioResponseDTO;
import com.controlAccesoInstYUni.application.mapper.CarreraMapper;
import com.controlAccesoInstYUni.application.mapper.FacultadMapper;
import com.controlAccesoInstYUni.application.mapper.UsuarioMapper;
import com.controlAccesoInstYUni.application.service.CarreraService;
import com.controlAccesoInstYUni.application.service.FacultadService;
import com.controlAccesoInstYUni.application.service.UsuarioService;
import com.controlAccesoInstYUni.domain.entity.Carrera;
import com.controlAccesoInstYUni.domain.entity.Facultad;
import com.controlAccesoInstYUni.domain.entity.Usuario;
import com.controlAccesoInstYUni.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioResponseDTO> listar() {
        return usuarioRepository.findAll().stream()
        .map(usuarioMapper::toDto)
                .toList();
    }

    @Override
    public UsuarioResponseDTO guardar(UsuarioRequestDTO requestDTO) {
        Usuario usuario = usuarioMapper.toEntity(requestDTO);
        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioResponseDTO obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDto)
                .orElseThrow(()->new RuntimeException("No existe usuario con ID: " + id));
    }

    @Override
    public UsuarioResponseDTO findByCodigoAcceso(String codAcceso) {
        Usuario usuario = usuarioRepository.findByCodigoAcceso(codAcceso)
                .orElseThrow(() -> new RuntimeException("No existe usuario con este código de acceso"));
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public List<UsuarioResponseDTO> guardarUsuarios(List<UsuarioRequestDTO> requestDTOs) {
        List<Usuario> usuarios = requestDTOs.stream()
                .map(usuarioMapper::toEntity)
                .collect(Collectors.toList());

        List<Usuario> usuariosGuardados = usuarioRepository.saveAll(usuarios);

        return usuariosGuardados.stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }

}
