package com.nttdata.scotiabank.userscotiabank;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.libertadores.pensiones.model.EmpleadorResponse;
import com.libertadores.pensiones.persistence.entity.EmpleadorEntity;
import com.libertadores.pensiones.persistence.repository.EmpleadorRepository;
import com.libertadores.pensiones.service.impl.CalculoActiarialImpl;
import com.nttdata.scotiabank.userscotiabank.utils.ObjectInitializer;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class ServiceTest {

    @InjectMocks
    private CalculoActiarialImpl service;

    @Mock
    private EmpleadorRepository repository;

    private ObjectInitializer objectInitializer;

    @BeforeEach
    public void beforeEach() {
        objectInitializer = new ObjectInitializer();
    }

    @Test
    void testConsultarUsuarios() {
        Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(objectInitializer.crearUserEntity()));
        List<EmpleadorResponse> respuesta = service.getEmpleador();
        Assertions.assertNotNull(respuesta);
    }

    @Test
    void testConsultarUsuariosPorID() {
        Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(Optional.of(objectInitializer.crearUserEntity()));
        EmpleadorResponse respuesta = service.getEmpleadorID(1);
        Assertions.assertNotNull(respuesta);
    }

    @Test
    void testConsultaUserPorIdError() {
        Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
        try {
            service.getEmpleadorID(1);
        } catch (Exception exception) {
            Assertions.assertNotNull(exception);
        }
    }
    
    @Test
    void testcrearUser() {
        Mockito.when(repository.save(Mockito.any(EmpleadorEntity.class))).thenReturn(objectInitializer.crearUserEntity());
        EmpleadorResponse respuesta = service.saveEmpleador(objectInitializer.crearUserSinId());
        Assertions.assertNotNull(respuesta);
    }
    
    @Test
    void testcrearUserPorIdError() {
        try {
        	service.saveEmpleador(objectInitializer.crearUser());
        } catch (Exception exception) {
            Assertions.assertNotNull(exception);
        }
    }
    
    @Test
    void testActualizarUser() {
        Mockito.when(repository.save(Mockito.any(EmpleadorEntity.class))).thenReturn(objectInitializer.crearUserEntity());
        Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(Optional.of(objectInitializer.crearUserEntity()));
        EmpleadorResponse respuesta = service.updateEmpleador(objectInitializer.crearUser());
        Assertions.assertNotNull(respuesta);
    }
    
    @Test
    void testActualizarUserPorIdError() {
        try {
        	service.updateEmpleador(objectInitializer.crearUserSinId());
        } catch (Exception exception) {
            Assertions.assertNotNull(exception);
        }
    }

    @Test
    void testActualizarUserSinData() {
        Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
        try {
        	service.updateEmpleador(objectInitializer.crearUser());
        } catch (Exception exception) {
            Assertions.assertNotNull(exception);
        }
    }
    
    @Test
    void testEliminarUserPorUuid() {
        Mockito.doNothing().when(repository).deleteById(Mockito.anyInt());
        service.deleteEmpleadorID(1);
        Mockito.verify(repository, Mockito.times(1)).deleteById(Mockito.anyInt());
    }
}
