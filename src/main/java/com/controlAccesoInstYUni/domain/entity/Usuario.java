package com.controlAccesoInstYUni.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", nullable = false)
    private Long id;

    @Column(name="codInst", nullable = false, length = 100, unique = true)
    private String codigoInstitucional;

    @Column(name = "codigoAcceso", nullable = false, length = 100, unique = true)
    private String codigoAcceso;

    @Enumerated(EnumType.STRING)
    private Rol rol; // ENUM: ESTUDIANTE, DOCENTE, ADMINISTRATIVO, INVITADO,

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "dni", nullable = false, length = 100)
    private String dni;

    @Column(name = "emailInst", nullable = false, unique = true, length = 150)
    private String emailInst;

    @Enumerated(EnumType.STRING)
    private Estado estado; // ENUM:

    /***********************************/
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Estudiante estudiante;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Docente docente;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private PersonalAdministrativo personalAdministrativo;


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistroPermanencia> registroPermanencias;

}
