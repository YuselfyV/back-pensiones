package com.libertadores.pensiones.persistence.repository;

import com.libertadores.pensiones.persistence.entity.FactorActuarial2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactorActuarial2Repository extends JpaRepository<FactorActuarial2Entity, Integer> {
        FactorActuarial2Entity findAllByEdad(Integer edad);
}
