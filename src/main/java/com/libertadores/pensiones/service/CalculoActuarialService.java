package com.libertadores.pensiones.service;

import com.libertadores.pensiones.model.EmpleadoRequest;
import com.libertadores.pensiones.model.EmpleadoResponse;
import com.libertadores.pensiones.model.EmpleadorRequest;
import com.libertadores.pensiones.model.EmpleadorResponse;

import java.util.List;

public interface CalculoActuarialService {
    List<EmpleadorResponse> getEmpleador();

    EmpleadorResponse saveEmpleador(EmpleadorRequest request);

    EmpleadorResponse updateEmpleador(EmpleadorRequest request);

    void deleteEmpleadorID(Integer id);

    EmpleadorResponse getEmpleadorID(Integer id);

    List<EmpleadoResponse> getEmpleado();

    EmpleadoResponse saveEmpleado(EmpleadoRequest request);

    EmpleadoResponse updateEmpleado(EmpleadoRequest request);

    void deleteEmpleadoID(Integer id);

    EmpleadoResponse getEmpleadoID(Integer id);

}
