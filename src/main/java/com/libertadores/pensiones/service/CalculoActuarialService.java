package com.libertadores.pensiones.service;

import com.libertadores.pensiones.model.*;
import com.libertadores.pensiones.persistence.entity.EdadReferenciaEntity;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

public interface CalculoActuarialService {
    /**
     *Empleador
     **/
    List<EmpleadorResponse> getEmpleador();

    EmpleadorResponse saveEmpleador(EmpleadorRequest request);

    EmpleadorResponse updateEmpleador(EmpleadorRequest request);

    void deleteEmpleadorID(Integer id);

    EmpleadorResponse getEmpleadorID(Integer id);

    /**
     *Empleado
     **/

    List<EmpleadoResponse> getEmpleado();

    EmpleadoResponse saveEmpleado(EmpleadoRequest request);

    EmpleadoResponse updateEmpleado(EmpleadoRequest request);

    void deleteEmpleadoID(Integer id);

    EmpleadoResponse getEmpleadoID(Integer id);

    /**
     *Usuario
     **/

    List<RegistroUsuarioResponse> getUsuario();
    RegistroUsuarioResponse saveUsuario(RegistroUsuarioRequest request);

    RegistroUsuarioResponse updateUsuario(RegistroUsuarioRequest request);

    RegistroUsuarioResponse getUsuarioID(Integer id);

    /**
     *Calculo
     **/

    ValorCalculoAc calculoActorial(CalculoRequest request) throws ParseException;

    List<CalculoActuarial> getCalculoActuarial();

    CalculoActResponse calculoActurialEstado(EstadoCalculoRequest calculo);

    RegistroUsuarioResponse updateUsuarioPassword(PasswordRequest request);

    /**
     *Salario
     **/
    List<SalarioResponse> getSalario();

    SalarioResponse saveSalario(SalarioRequest request);

    SalarioResponse updateSalario(SalarioRequest request);

    void deleteSalarioID(Integer id);

    SalarioResponse getSalarioID(Integer id);


    List<EdadReferenciaResponse> getEdadRefencia();

    EdadReferenciaResponse actualizarEdadReferencia(EdadReferenciaRequest calculo);
}
