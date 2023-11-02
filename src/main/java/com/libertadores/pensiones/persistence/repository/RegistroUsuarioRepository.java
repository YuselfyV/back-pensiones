package com.libertadores.pensiones.persistence.repository;

import com.libertadores.pensiones.persistence.entity.CalculoActuarialEntity;
import com.libertadores.pensiones.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistroUsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    Optional<UsuarioEntity> findAllByUsername(String username);

    UsuarioEntity findAllByIdUsuario(Integer idUsuario);
}
