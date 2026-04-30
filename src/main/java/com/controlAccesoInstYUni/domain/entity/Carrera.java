package com.controlAccesoInstYUni.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "carrera")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_Carrera")
    private Long id;

    @Column(name = "nom_Carrera", unique = true, nullable = false, length = 100)
    private String nomCarrera;

    @ManyToOne
    @JoinColumn(name="cod_Facultad", nullable = false)
    private Facultad facultad;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estudiante> estudiantes;
}
