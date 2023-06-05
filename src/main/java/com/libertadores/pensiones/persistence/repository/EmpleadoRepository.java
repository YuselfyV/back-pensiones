package com.libertadores.pensiones.persistence.repository;

import com.libertadores.pensiones.persistence.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer> {
}
