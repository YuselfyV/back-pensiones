package com.libertadores.pensiones.service.impl;

import static com.libertadores.pensiones.utils.Constantes.MSUS_01;
import static com.libertadores.pensiones.utils.Constantes.MSUS_02;
import static com.libertadores.pensiones.utils.Constantes.MSUS_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.libertadores.pensiones.model.EmpleadoRequest;
import com.libertadores.pensiones.model.EmpleadoResponse;
import com.libertadores.pensiones.persistence.entity.EmpleadoEntity;
import com.libertadores.pensiones.persistence.entity.EmpleadorEntity;
import com.libertadores.pensiones.persistence.repository.EmpleadoRepository;
import com.libertadores.pensiones.persistence.repository.EmpleadorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libertadores.pensiones.model.EmpleadorRequest;
import com.libertadores.pensiones.model.EmpleadorResponse;
import com.libertadores.pensiones.service.CalculoActuarialService;
import com.libertadores.pensiones.utils.Excepcion;

@Service
public class CalculoActiarialImpl implements CalculoActuarialService {

    @Autowired
    EmpleadorRepository empleadorRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    /**
     *Solicita Datos de entidad empleador
     * @return ArrayList<UserEntity>
     */
    public List<EmpleadorResponse> getEmpleador() {
        List<EmpleadorEntity> entity = new ArrayList<>();
        Iterable<EmpleadorEntity> userModelIterable;
        userModelIterable = empleadorRepository.findAll();
        userModelIterable.forEach(entity::add);
        List<EmpleadorResponse> userLista = entity.stream().map(userEntity -> transformEmpleadorResponse(userEntity)).collect(Collectors.toList());
        return userLista;
    }

    /**
     * Guardado de datos en la entidad empleador
     * @param entity
     * @return UserResponse
     */
    @Override
    public EmpleadorResponse saveEmpleador(EmpleadorRequest entity) {
        if (entity.getIdEmpleador() != null) {
            throw new Excepcion(MSUS_01);
        }
        return transformEmpleadorResponse(empleadorRepository.save(transformEmpleadorEntity(entity)));
    }

    /**
     * Actualizacion de datos en la entidad empleador
     * @param request
     * @return UserResponse
     */
    @Override
    public EmpleadorResponse updateEmpleador(EmpleadorRequest request) {
        if (request.getIdEmpleador() == null) {
            throw new Excepcion(MSUS_02);
        }
        EmpleadorResponse userId = getEmpleadorID(request.getIdEmpleador());
        if (userId != null) {
            return transformEmpleadorResponse(empleadorRepository.save(transformEmpleadorEntity(request)));
        } else {
            throw new Excepcion(MSUS_03);
        }
    }

    /**
     * Eliminar registro por ID en la entidad empleador
     * @param id
     */

    @Override
    public void deleteEmpleadorID(Integer id) {
        empleadorRepository.deleteById(id);
    }

    /**
     * Obtener datos por ID en la entidad empleador
     * @param id
     * @return UserResponse
     */
    @Override
    public EmpleadorResponse getEmpleadorID(Integer id) {
        Optional<EmpleadorEntity> optionalUserEntity = empleadorRepository.findById(id);
        if (!optionalUserEntity.isPresent()) {
            throw new Excepcion(MSUS_03);
        }
        return transformEmpleadorResponse(optionalUserEntity.get());
    }

    /**
     * Transformar el request a la entidad empleador
     * @param request
     * @return UserEntity
     */
    private EmpleadorEntity transformEmpleadorEntity(EmpleadorRequest request) {
        EmpleadorEntity entity = new EmpleadorEntity();
        BeanUtils.copyProperties(request, entity);
        return entity;
    }

    /**
     * transformacio de la respuesta final para el usuario
     * @param entity
     * @return UserResponse
     */
    private EmpleadorResponse transformEmpleadorResponse(EmpleadorEntity entity) {
        EmpleadorResponse response = new EmpleadorResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }


    /******************************************Empleado  ***********************************************/

    /**
     *Solicita Datos de entidad empleado
     * @return ArrayList<UserEntity>
     */
    public List<EmpleadoResponse> getEmpleado() {
        List<EmpleadoEntity> entity = new ArrayList<>();
        Iterable<EmpleadoEntity> userModelIterable;
        userModelIterable = empleadoRepository.findAll();
        userModelIterable.forEach(entity::add);
        List<EmpleadoResponse> userLista = entity.stream().map(userEntity -> transformEmpleadoResponse(userEntity)).collect(Collectors.toList());
        return userLista;
    }

    /**
     * Guardado de datos en la entidad empleado
     * @param entity
     * @return UserResponse
     */
    @Override
    public EmpleadoResponse saveEmpleado(EmpleadoRequest entity) {
        if (entity.getIdEmpleado() != null) {
            throw new Excepcion(MSUS_01);
        }
        return transformEmpleadoResponse(empleadoRepository.save(transformEmpleadoEntity(entity)));
    }

    /**
     * Actualizacion de datos en la entidad empleado
     * @param request
     * @return UserResponse
     */
    @Override
    public EmpleadoResponse updateEmpleado(EmpleadoRequest request) {
        if (request.getIdEmpleado() == null) {
            throw new Excepcion(MSUS_02);
        }
        EmpleadoResponse userId = getEmpleadoID(request.getIdEmpleado());
        if (userId != null) {
            return transformEmpleadoResponse(empleadoRepository.save(transformEmpleadoEntity(request)));
        } else {
            throw new Excepcion(MSUS_03);
        }
    }

    /**
     * Eliminar registro por ID en la entidad empleado
     * @param id
     */

    @Override
    public void deleteEmpleadoID(Integer id) {
        empleadoRepository.deleteById(id);
    }

    /**
     * Obtener datos por ID en la entidad empleado
     * @param id
     * @return UserResponse
     */
    @Override
    public EmpleadoResponse getEmpleadoID(Integer id) {
        Optional<EmpleadoEntity> optionalUserEntity = empleadoRepository.findById(id);
        if (!optionalUserEntity.isPresent()) {
            throw new Excepcion(MSUS_03);
        }
        return transformEmpleadoResponse(optionalUserEntity.get());
    }

    /**
     * Transformar el request a la entidad empleado
     * @param request
     * @return UserEntity
     */
    private EmpleadoEntity transformEmpleadoEntity(EmpleadoRequest request) {
        EmpleadoEntity entity = new EmpleadoEntity();
        BeanUtils.copyProperties(request, entity);
        return entity;
    }

    /**
     * transformacio de la respuesta final para el usuario
     * @param entity
     * @return UserResponse
     */
    private EmpleadoResponse transformEmpleadoResponse(EmpleadoEntity entity) {
        EmpleadoResponse response = new EmpleadoResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }


}
