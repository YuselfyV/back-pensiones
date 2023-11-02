package com.libertadores.pensiones.persistence.repository;

import com.libertadores.pensiones.persistence.entity.SalarioMedioNacionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalarioMedioNacionalRepository extends JpaRepository<SalarioMedioNacionalEntity, Integer> {

    SalarioMedioNacionalEntity findAllByEdad(Integer edad);
}
