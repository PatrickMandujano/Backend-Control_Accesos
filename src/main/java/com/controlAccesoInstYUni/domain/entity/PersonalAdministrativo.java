package com.controlAccesoInstYUni.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "personalAdministrativo")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PersonalAdministrativo {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name="area", nullable = false, length = 100)
    private String area;

    @Column(name ="cargo",nullable = false, length = 100)
    private String cargo;


}
