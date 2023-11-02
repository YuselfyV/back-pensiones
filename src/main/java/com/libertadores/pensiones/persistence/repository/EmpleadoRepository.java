package com.libertadores.pensiones.persistence.repository;

import com.libertadores.pensiones.persistence.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer> {
    Optional<EmpleadoEntity> findAllByIdentificadorEmpleado(String documento);

}
