package com.controlAccesoInstYUni.application.dto.registroPermanencia;

import com.controlAccesoInstYUni.domain.entity.Rol;
import com.controlAccesoInstYUni.domain.entity.TipoPuntoControl;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RegPermanenciaResponseDTO {
    private Long id;
    private String codigoInstitucional;
    private Rol rol;
    private String nombreCompleto;
    private String dni;
    private String PuntoEntrada;
    private LocalDateTime fechaHoraEntrada;
    private String PuntoSalida;
    private LocalDateTime fechaHoraSalida;

    // Datos del usuario asociados
}
