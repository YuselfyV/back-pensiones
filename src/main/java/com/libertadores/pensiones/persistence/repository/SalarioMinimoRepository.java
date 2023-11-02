package com.libertadores.pensiones.persistence.repository;

import com.libertadores.pensiones.persistence.entity.SalarioEntity;
import com.libertadores.pensiones.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalarioMinimoRepository extends JpaRepository<SalarioEntity, Integer> {

    SalarioEntity findAllByAno(Integer ano);
    Optional<SalarioEntity> findByAno(Integer ano);
}
