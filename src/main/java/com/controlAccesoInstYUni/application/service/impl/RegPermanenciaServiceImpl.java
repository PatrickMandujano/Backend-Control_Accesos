package com.controlAccesoInstYUni.application.service.impl;

import com.controlAccesoInstYUni.application.dto.registroPermanencia.RegPermanenciaRequestDTO;
import com.controlAccesoInstYUni.application.dto.registroPermanencia.RegPermanenciaResponseDTO;
import com.controlAccesoInstYUni.application.mapper.RegistroPermanenciaMapper;
import com.controlAccesoInstYUni.application.service.UsuarioService;
import com.controlAccesoInstYUni.application.service.RegPermanenciaService;
import com.controlAccesoInstYUni.domain.entity.*;
import com.controlAccesoInstYUni.domain.repository.PuntoControlRepository;
import com.controlAccesoInstYUni.domain.repository.UsuarioRepository;
import com.controlAccesoInstYUni.domain.repository.RegPermanenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegPermanenciaServiceImpl implements RegPermanenciaService {
    private final UsuarioRepository usuarioRepository;
    private final PuntoControlRepository puntoControlRepository;
    private final RegPermanenciaRepository registroPermanenciaRepository;
    private final RegistroPermanenciaMapper mapper;

    @Override
    public List<RegPermanenciaResponseDTO> listarRegPermanencia() {
        return registroPermanenciaRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public RegPermanenciaResponseDTO obtenerRegPermanenciaPorID(Long id) {
        return registroPermanenciaRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(()->new RuntimeException("Acceso no encontrado"));
    }

    @Override
    public RegPermanenciaResponseDTO registrarEntrada(RegPermanenciaRequestDTO requestDTO) {
        Usuario usuario = usuarioRepository.findByCodigoAcceso(requestDTO.getCodigoAcceso())
                .orElseThrow(() -> new RuntimeException("Código de acceso inválido."));

        if (usuario.getEstado() != Estado.ACTIVO) {
            throw new RuntimeException("El usuario está inactivo. No se permite registrar la entrada.");
        }

        if (registroPermanenciaRepository.existsByUsuarioAndFechaHoraSalidaIsNull(usuario)) {
            throw new RuntimeException("El usuario ya tiene una permanencia activa.");
        }

        PuntoControl puntoEntrada = puntoControlRepository.findById(requestDTO.getIdPuntoControl())
                .orElseThrow(() -> new RuntimeException("Punto de control inválido."));

        if (puntoEntrada.getTipoPuntoControl() != TipoPuntoControl.ENTRADA) {
            throw new RuntimeException("El punto seleccionado no es de ENTRADA.");
        }

        RegistroPermanencia permanencia = mapper.toEntity(usuario, puntoEntrada);
        registroPermanenciaRepository.save(permanencia);

        return mapper.toDto(permanencia);
    }

    @Override
    public RegPermanenciaResponseDTO registrarSalida(RegPermanenciaRequestDTO requestDTO) {
        Usuario usuario = usuarioRepository.findByCodigoAcceso(requestDTO.getCodigoAcceso())
                .orElseThrow(() -> new RuntimeException("Código de acceso inválido."));

        if (usuario.getEstado() != Estado.ACTIVO) {
            throw new RuntimeException("El usuario está inactivo. No se permite registrar la salida.");
        }

        RegistroPermanencia permanencia = registroPermanenciaRepository
                .findTopByUsuarioAndFechaHoraSalidaIsNull(usuario)
                .orElseThrow(() -> new RuntimeException("No hay permanencia activa para este usuario."));

        PuntoControl puntoSalida = puntoControlRepository.findById(requestDTO.getIdPuntoControl())
                .orElseThrow(() -> new RuntimeException("Punto de control inválido."));

        if (puntoSalida.getTipoPuntoControl() != TipoPuntoControl.SALIDA) {
            throw new RuntimeException("El punto seleccionado no es de SALIDA.");
        }

        permanencia.setFechaHoraSalida(LocalDateTime.now());
        permanencia.setPuntoSalida(puntoSalida);
        registroPermanenciaRepository.save(permanencia);

        return mapper.toDto(permanencia);
    };

}
