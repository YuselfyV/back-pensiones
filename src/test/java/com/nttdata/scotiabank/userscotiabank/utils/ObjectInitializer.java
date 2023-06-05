package com.nttdata.scotiabank.userscotiabank.utils;

import com.libertadores.pensiones.model.EmpleadorRequest;
import com.libertadores.pensiones.model.EmpleadorResponse;
import com.libertadores.pensiones.persistence.entity.EmpleadorEntity;

public class ObjectInitializer {

    public EmpleadorRequest crearUser() {
        EmpleadorRequest user = new EmpleadorRequest();
        user.setId(1L);
        user.setFirstName("Luis");
        user.setLastName("Rodriguez");
        user.setCompany("NttData");
        user.setCity("Bogota");
        user.setPhone("356698555");
        user.setEmail("luis.rodriguez.nttdata.co");
        return user;
    }
    
    public EmpleadorRequest crearUserSinId() {
        EmpleadorRequest user = new EmpleadorRequest();
        user.setFirstName("Luis");
        user.setLastName("Rodriguez");
        user.setCompany("NttData");
        user.setCity("Bogota");
        user.setPhone("356698555");
        user.setEmail("luis.rodriguez.nttdata.co");
        return user;
    }

    public EmpleadorEntity crearUserEntity() {
        EmpleadorEntity user = new EmpleadorEntity();
        user.setId(1l);
        user.setFirstName("Luis");
        user.setLastName("Rodriguez");
        user.setCompany("NttData");
        user.setCity("Bogota");
        user.setPhone("356698555");
        user.setEmail("luis.rodriguez.nttdata.co");
        return user;
    }


    public EmpleadorResponse crearUserResponse() {
    	EmpleadorResponse user = new EmpleadorResponse();
        user.setId(1l);
        user.setFirstName("Luis");
        user.setLastName("Rodriguez");
        user.setCompany("NttData");
        user.setCity("Bogota");
        user.setPhone("356698555");
        user.setEmail("luis.rodriguez.nttdata.co");
        return user;
    }

}
