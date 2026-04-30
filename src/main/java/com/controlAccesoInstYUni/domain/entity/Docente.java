package com.controlAccesoInstYUni.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "docente")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Docente {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private String especialidad;
}
