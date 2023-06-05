package com.nttdata.scotiabank.userscotiabank;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.libertadores.pensiones.controller.CalculoActuarialController;
import com.libertadores.pensiones.model.EmpleadorResponse;
import com.libertadores.pensiones.service.CalculoActuarialService;
import com.nttdata.scotiabank.userscotiabank.utils.ObjectInitializer;
import com.libertadores.pensiones.utils.Response;


@RunWith(MockitoJUnitRunner.class)
class ControllerTest {
    @InjectMocks
    private CalculoActuarialController controller;

    @Mock
    private CalculoActuarialService service;

    private ObjectInitializer objectInitializer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        objectInitializer = new ObjectInitializer();
    }

    @Test
    void testcrearUser() {
        Mockito.when(service.saveEmpleador(objectInitializer.crearUserSinId())).thenReturn(objectInitializer.crearUserResponse());
        ResponseEntity<Response<EmpleadorResponse>> respuesta = controller.saveEmpleador(objectInitializer.crearUserSinId());
        Assertions.assertNotNull(respuesta);
    }
    
    @Test
    void testActualizarUser() {
        Mockito.when(service.updateEmpleador(objectInitializer.crearUserSinId())).thenReturn(objectInitializer.crearUserResponse());
        ResponseEntity<Response<EmpleadorResponse>> respuesta = controller.updateEmpleador(objectInitializer.crearUser());
        Assertions.assertNotNull(respuesta);
    }
    
    @Test
    void testEliminarUser() {
    	Mockito.doNothing().when(service).deleteEmpleadorID(Mockito.anyInt());
        ResponseEntity<Response<EmpleadorResponse>> respuesta = controller.deleteEmpleador(1);
        Assertions.assertNotNull(respuesta);
    }
    
    @Test
    void testConsultarUsuarios() {
        Mockito.when(service.getEmpleador()).thenReturn(Collections.singletonList(objectInitializer.crearUserResponse()));
        List<EmpleadorResponse> respuesta = controller.getEmpleador();
        Assertions.assertNotNull(respuesta);
    }

    @Test
    void testConsultarUsuariosPorID() {
        Mockito.when(service.getEmpleadorID(Mockito.anyInt())).thenReturn(objectInitializer.crearUserResponse());
        EmpleadorResponse respuesta = service.getEmpleadorID(1);
        Assertions.assertNotNull(respuesta);
    }

}
