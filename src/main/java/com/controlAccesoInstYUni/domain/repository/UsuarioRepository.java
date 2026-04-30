package com.controlAccesoInstYUni.domain.repository;

import com.controlAccesoInstYUni.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
Optional<Usuario> findByCodigoAcceso(String codAcceso);
}
