package com.controlAccesoInstYUni.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "facultad")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Facultad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_Facultad")
    private Long id;

    @Column(name = "nom_Facultad", unique = true, nullable = false, length = 100)
    private String nomFacultad;

    @OneToMany(mappedBy = "facultad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carrera> carreras;
}
