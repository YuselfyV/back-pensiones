package com.libertadores.pensiones.persistence.repository;

import com.libertadores.pensiones.persistence.entity.EmpleadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadorRepository extends JpaRepository<EmpleadorEntity, Integer> {
}
