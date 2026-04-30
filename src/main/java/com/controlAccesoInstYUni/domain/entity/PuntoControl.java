package com.controlAccesoInstYUni.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "PuntoControl")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PuntoControl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_PuntoControl", nullable = false, unique = true)
    private Long id;

    @Column(name = "nombrePuntoControl", nullable = false, unique = true)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoPuntoControl", nullable = false)
    private TipoPuntoControl tipoPuntoControl;  // ENTRADA o SALIDA

}
