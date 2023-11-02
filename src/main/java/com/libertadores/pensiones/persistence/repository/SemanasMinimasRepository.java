package com.libertadores.pensiones.persistence.repository;
import com.libertadores.pensiones.persistence.entity.SemanasMinimasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SemanasMinimasRepository extends JpaRepository<SemanasMinimasEntity, Integer> {

    Optional<SemanasMinimasEntity> findByAno(Integer ano);
}
