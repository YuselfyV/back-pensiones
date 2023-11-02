package com.libertadores.pensiones.persistence.repository;

import com.libertadores.pensiones.persistence.entity.EdadReferenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdadRefenciaRepository extends JpaRepository<EdadReferenciaEntity, Integer> {

    EdadReferenciaEntity findAllByGenero(String genero);
}
