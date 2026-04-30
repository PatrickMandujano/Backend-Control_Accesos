package com.controlAccesoInstYUni.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estudiante")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Estudiante {
    @Id
    private Long id; // Mismo ID que Usuario

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @Column(name = "añoIngreso", nullable = false)
    private Integer anoIngreso;
}
