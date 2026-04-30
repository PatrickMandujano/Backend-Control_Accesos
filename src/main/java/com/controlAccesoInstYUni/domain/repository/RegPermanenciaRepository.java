package com.controlAccesoInstYUni.domain.repository;

import com.controlAccesoInstYUni.domain.entity.Usuario;
import com.controlAccesoInstYUni.domain.entity.RegistroPermanencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegPermanenciaRepository extends JpaRepository<RegistroPermanencia, Long> {
    boolean existsByUsuarioAndFechaHoraSalidaIsNull(Usuario usuario);

    Optional<RegistroPermanencia> findTopByUsuarioAndFechaHoraSalidaIsNull(Usuario usuario);
}
