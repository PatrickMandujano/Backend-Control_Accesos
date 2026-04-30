package com.controlAccesoInstYUni.application.mapper;

import com.controlAccesoInstYUni.application.dto.registroPermanencia.RegPermanenciaResponseDTO;
import com.controlAccesoInstYUni.domain.entity.PuntoControl;
import com.controlAccesoInstYUni.domain.entity.Usuario;
import com.controlAccesoInstYUni.domain.entity.RegistroPermanencia;
import com.controlAccesoInstYUni.domain.entity.TipoPuntoControl;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RegistroPermanenciaMapper {

    public RegPermanenciaResponseDTO toDto(RegistroPermanencia registroPermanencia) {
        return RegPermanenciaResponseDTO.builder()
                .id(registroPermanencia.getId())
                .codigoInstitucional(registroPermanencia.getUsuario().getCodigoInstitucional())
                .rol(registroPermanencia.getUsuario().getRol())
                .nombreCompleto(registroPermanencia.getUsuario().getNombres() + " " + registroPermanencia.getUsuario().getApellidos())
                .dni(registroPermanencia.getUsuario().getDni())
                .PuntoEntrada(registroPermanencia.getPuntoEntrada().getNombre())
                .fechaHoraEntrada(registroPermanencia.getFechaHoraEntrada())
                .PuntoSalida(registroPermanencia.getPuntoSalida() != null ? registroPermanencia.getPuntoSalida().getNombre() : null)
                .fechaHoraSalida(registroPermanencia.getFechaHoraSalida())
                .build();
    }

    public RegistroPermanencia toEntity(Usuario usuario, PuntoControl puntoEntrada) {
        return RegistroPermanencia.builder()
                .usuario(usuario)
                .puntoEntrada(puntoEntrada)
                .fechaHoraEntrada(LocalDateTime.now())
                .build();
    }


}
