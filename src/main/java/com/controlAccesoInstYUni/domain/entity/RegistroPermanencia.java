package com.controlAccesoInstYUni.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "registroPermanencia")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RegistroPermanencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_RegAcceso", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "punto_entrada_id")
    private PuntoControl puntoEntrada;

    @Column(nullable = false)
    private LocalDateTime fechaHoraEntrada;

    @ManyToOne
    @JoinColumn(name = "punto_salida_id", nullable = true)
    private PuntoControl puntoSalida;

    @Column(nullable = true)
    private LocalDateTime fechaHoraSalida;

    @ManyToOne
    @JoinColumn(name="idUsuario", nullable = false)
    private Usuario usuario;

}
