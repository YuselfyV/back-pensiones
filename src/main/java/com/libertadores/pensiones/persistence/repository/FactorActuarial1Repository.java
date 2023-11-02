package com.libertadores.pensiones.persistence.repository;

import com.libertadores.pensiones.persistence.entity.FactorActuarial1Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactorActuarial1Repository extends JpaRepository<FactorActuarial1Entity, Integer> {
    FactorActuarial1Entity findAllByEdad(Integer edad);
}
