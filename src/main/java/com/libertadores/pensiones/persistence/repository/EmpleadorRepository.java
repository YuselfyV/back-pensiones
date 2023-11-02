package com.libertadores.pensiones.persistence.repository;

import com.libertadores.pensiones.persistence.entity.EmpleadorEntity;
import com.libertadores.pensiones.persistence.entity.FactorActuarial2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpleadorRepository extends JpaRepository<EmpleadorEntity, Integer> {
    Optional<EmpleadorEntity> findAllByIdentificadorEmpleador(String identificadorEmpleador);
}
