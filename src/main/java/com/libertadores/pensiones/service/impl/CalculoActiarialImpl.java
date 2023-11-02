package com.libertadores.pensiones.service.impl;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import com.libertadores.pensiones.model.*;
import com.libertadores.pensiones.persistence.entity.*;
import com.libertadores.pensiones.persistence.repository.*;
import com.libertadores.pensiones.utils.UtilidadesAplicacion;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libertadores.pensiones.service.CalculoActuarialService;
import com.libertadores.pensiones.utils.Excepcion;

import static com.libertadores.pensiones.utils.Constantes.*;

@Service
public class CalculoActiarialImpl implements CalculoActuarialService {

    @Autowired
    EmpleadorRepository empleadorRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    UtilidadesAplicacion utilidadesAplicacion;

    @Autowired
    RegistroUsuarioRepository registroUsuarioRepository;

    @Autowired
    CalculoActuarialRepository calculoActuarialRepository;

    @Autowired
    SalarioMinimoRepository salarioMinimoRepository;

    @Autowired
    EdadRefenciaRepository edadRefenciaRepository;

    /**
     * Solicita Datos de entidad empleador
     *
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
     *
     * @param request
     * @return UserResponse
     */
    @Override
    public EmpleadorResponse saveEmpleador(EmpleadorRequest request) {
        Optional<EmpleadorEntity> entity = empleadorRepository.findAllByIdentificadorEmpleador(request.getIdentificadorEmpleador());
        if (request.getIdEmpleador() != null) {
            throw new Excepcion(MSCA_01);
        } else if (entity.isPresent()) {
            throw new Excepcion(MSCA_04);
        }
        return transformEmpleadorResponse(empleadorRepository.save(transformEmpleadorEntity(request)));
    }

    /**
     * Actualizacion de datos en la entidad empleador
     *
     * @param request
     * @return UserResponse
     */
    @Override
    public EmpleadorResponse updateEmpleador(EmpleadorRequest request) {
        if (request.getIdEmpleador() == null) {
            throw new Excepcion(MSCA_02);
        }
        EmpleadorResponse userId = getEmpleadorID(request.getIdEmpleador());
        if (userId != null) {
            return transformEmpleadorResponse(empleadorRepository.save(transformEmpleadorEntity(request)));
        } else {
            throw new Excepcion(MSCA_03);
        }
    }

    /**
     * Eliminar registro por ID en la entidad empleador
     *
     * @param id
     */

    @Override
    public void deleteEmpleadorID(Integer id) {
        empleadorRepository.deleteById(id);
    }

    /**
     * Obtener datos por ID en la entidad empleador
     *
     * @param id
     * @return UserResponse
     */
    @Override
    public EmpleadorResponse getEmpleadorID(Integer id) {
        Optional<EmpleadorEntity> optionalUserEntity = empleadorRepository.findById(id);
        if (!optionalUserEntity.isPresent()) {
            throw new Excepcion(MSCA_03);
        }
        return transformEmpleadorResponse(optionalUserEntity.get());
    }

    /**
     * Transformar el request a la entidad empleador
     *
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
     *
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
     * Solicita Datos de entidad empleado
     *
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
     *
     * @param request
     * @return UserResponse
     */
    @Override
    public EmpleadoResponse saveEmpleado(EmpleadoRequest request) {
        Optional<EmpleadoEntity> entity = empleadoRepository.findAllByIdentificadorEmpleado(request.getIdentificadorEmpleado());
        if (request.getIdEmpleado() != null) {
            throw new Excepcion(MSCA_01);
        } else if (entity.isPresent()) {
            throw new Excepcion(MSCA_04);
        }
        return transformEmpleadoResponse(empleadoRepository.save(transformEmpleadoEntity(request)));
    }

    /**
     * Actualizacion de datos en la entidad empleado
     *
     * @param request
     * @return UserResponse
     */
    @Override
    public EmpleadoResponse updateEmpleado(EmpleadoRequest request) {
        if (request.getIdEmpleado() == null) {
            throw new Excepcion(MSCA_02);
        }
        EmpleadoResponse userId = getEmpleadoID(request.getIdEmpleado());
        if (userId != null) {
            return transformEmpleadoResponse(empleadoRepository.save(transformEmpleadoEntity(request)));
        } else {
            throw new Excepcion(MSCA_03);
        }
    }

    /**
     * Eliminar registro por ID en la entidad empleado
     *
     * @param id
     */

    @Override
    public void deleteEmpleadoID(Integer id) {
        empleadoRepository.deleteById(id);
    }

    /**
     * Obtener datos por ID en la entidad empleado
     *
     * @param id
     * @return UserResponse
     */
    @Override
    public EmpleadoResponse getEmpleadoID(Integer id) {
        Optional<EmpleadoEntity> optionalUserEntity = empleadoRepository.findById(id);
        if (!optionalUserEntity.isPresent()) {
            throw new Excepcion(MSCA_03);
        }
        return transformEmpleadoResponse(optionalUserEntity.get());
    }

    /**
     * Transformar el request a la entidad empleado
     *
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
     *
     * @param entity
     * @return UserResponse
     */
    private EmpleadoResponse transformEmpleadoResponse(EmpleadoEntity entity) {
        EmpleadoResponse response = new EmpleadoResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }


    /**
     * Obtener datos por ID en la entidad empleado
     *
     * @return UserResponse
     */

    public List<RegistroUsuarioResponse> getUsuario() {
        List<UsuarioEntity> entity = new ArrayList<>();
        Iterable<UsuarioEntity> userModelIterable;
        userModelIterable = registroUsuarioRepository.findAll();
        userModelIterable.forEach(entity::add);
        List<RegistroUsuarioResponse> userLista = entity.stream().map(userEntity -> transformUsuarioResponse(userEntity)).collect(Collectors.toList());
        return userLista;
    }

    @Override
    public RegistroUsuarioResponse getUsuarioID(Integer id) {
        Optional<UsuarioEntity> optionalUserEntity = registroUsuarioRepository.findById(id);
        if (!optionalUserEntity.isPresent()) {
            throw new Excepcion(MSCA_03);
        }
        return transformUsuarioResponse(optionalUserEntity.get());
    }

    /**
     * Guardado de datos en la entidad usuario
     *
     * @param request
     * @return UserResponse
     */
    @Override
    public RegistroUsuarioResponse saveUsuario(RegistroUsuarioRequest request) {
        Optional<UsuarioEntity> entity = registroUsuarioRepository.findAllByUsername(request.getUsername());
        if (request.getIdUsuario() != null) {
            throw new Excepcion(MSCA_01);
        } else if (entity.isPresent()) {
            throw new Excepcion(MSCA_05);

        }
        RegistroUsuarioResponse usuarioRegistrado = transformUsuarioResponse(registroUsuarioRepository.save(transformUsuarioEntity(request)));

        return usuarioRegistrado;
    }

    /**
     * Actualizacion todos los datos menos contraseña
     *
     * @param request
     * @return UserResponse
     */
    @Override
    public RegistroUsuarioResponse updateUsuario(RegistroUsuarioRequest request) {
        if (request.getIdUsuario() == null) {
            throw new Excepcion(MSCA_02);
        }
        UsuarioEntity optionalUserEntity = registroUsuarioRepository.findAllByIdUsuario(request.getIdUsuario());
        optionalUserEntity.setTipoUsuario(request.getTipoUsuario());
        optionalUserEntity.setEstado(request.getEstado());
        optionalUserEntity.setNombre(request.getNombre());

        registroUsuarioRepository.save(optionalUserEntity);
        return transformUsuarioResponse(optionalUserEntity);
    }

    /**
     * Metodo de actualzacion de contraseña
     * @param request
     * @return
     */
    @Override
    public RegistroUsuarioResponse updateUsuarioPassword(PasswordRequest request) {
        UsuarioEntity optionalUserEntity = registroUsuarioRepository.findAllByIdUsuario(request.getIdUsuario());
        if(optionalUserEntity == null){
            throw new Excepcion(MSCA_02);
        }
        optionalUserEntity.setPassword(utilidadesAplicacion.encriptarContrasena(request.getPassword()));
        registroUsuarioRepository.save(optionalUserEntity);
        return transformUsuarioResponse(optionalUserEntity);
    }

    /**
     * Transformar el request a la entidad usuario
     *
     * @param request
     * @return UserEntity
     */
    private UsuarioEntity transformUsuarioEntity(RegistroUsuarioRequest request) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setIdUsuario(request.getIdUsuario());
        entity.setUsername(request.getUsername());
        entity.setPassword(utilidadesAplicacion.encriptarContrasena(request.getPassword()));
        entity.setEstado(request.getEstado());
        entity.setTipoUsuario(request.getTipoUsuario());
        entity.setNombre(request.getNombre());
        return entity;
    }

    /**
     * transformacio de la respuesta final para el usuario
     *
     * @param entity
     * @return UserResponse
     */
    private RegistroUsuarioResponse transformUsuarioResponse(UsuarioEntity entity) {
        RegistroUsuarioResponse response = new RegistroUsuarioResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

    /**
     * Calcuolo Actuarial
     * @param request
     * @return valorCalculoAc
     * @throws ParseException
     */

    @Override
    public ValorCalculoAc calculoActorial(CalculoRequest request) throws ParseException {
        CalculoActuarial calculoActuarial = new CalculoActuarial();
        ValorCalculoAc valorCalculoAc = new ValorCalculoAc();
        calculoActuarial.setFechaInicioNoPago(request.getFechaInicioNoPago());
        calculoActuarial.setFechaCorte(request.getFechaCorte());
        calculoActuarial.setIdEmpleador(request.getIdEmpleador());
        calculoActuarial.setIdEmpleado(request.getIdEmpleado());
        calculoActuarial.setIdUsuario(request.getIdUsuario());
        calculoActuarial.setSalarioBaseLiquidacion(utilidadesAplicacion.validarSalarioBaseLiquidacion(request.getSalarioBaseLiquidacion(), request.getFechaCorte()));
        calculoActuarial.setTiempoConvalidacion(utilidadesAplicacion.tiempoConvalidacion(request.getFechaInicioNoPago(), request.getFechaCorte()));
        calculoActuarial.setUltimoCumpleanos(utilidadesAplicacion.ultimoCumpleanos(request.getFechaNacimiento(), request.getFechaCorte()));
        calculoActuarial.setProximoCumpleanos(utilidadesAplicacion.proximoCumpleanos(request.getFechaNacimiento(), request.getFechaCorte()));
        calculoActuarial.setSalarioMinimoFechaCorte(utilidadesAplicacion.salarioMinimoFechaCorte(request.getFechaCorte()));
        calculoActuarial.setNumeroSalariosMinimos(utilidadesAplicacion.numeroSalariosMinimos(request.getSalarioBaseLiquidacion(), calculoActuarial.getSalarioMinimoFechaCorte()));
        calculoActuarial.setEdadReferencia(utilidadesAplicacion.edadReferencia(request.getGenero()));
        calculoActuarial.setFechaReferencia(utilidadesAplicacion.fechaReferencia(request.getFechaNacimiento(), calculoActuarial.getEdadReferencia()));
        calculoActuarial.setSemanasMinimas(utilidadesAplicacion.semanasMinimas(calculoActuarial.getFechaReferencia()));
        calculoActuarial.setFechaCumplimiento(utilidadesAplicacion.fechaCumplimiento(calculoActuarial.getSemanasMinimas(),calculoActuarial.getFechaCorte(),calculoActuarial.getTiempoConvalidacion()));
        calculoActuarial.setFechaFR(utilidadesAplicacion.eleccioFechaReferencia(calculoActuarial.getFechaReferencia(),calculoActuarial.getFechaCumplimiento()));
        calculoActuarial.setEdadFR(utilidadesAplicacion.edadFechaReferencia(request.getFechaNacimiento(),calculoActuarial.getFechaFR()));
        calculoActuarial.setTiempoFaltantePension(utilidadesAplicacion.tiempoFaltantePension(calculoActuarial.getFechaFR(), request.getFechaCorte()));
        calculoActuarial.setEdadFechaCorte(utilidadesAplicacion.fechaEdadCorte(request.getFechaNacimiento(), request.getFechaCorte()));
        calculoActuarial.setV1(utilidadesAplicacion.salarioMedioNacionalFechaCorte(calculoActuarial.getEdadFechaCorte()));
        calculoActuarial.setV2(utilidadesAplicacion.salarioMedioNacionalPosteriorFechaCorte(calculoActuarial.getEdadFechaCorte()));
        calculoActuarial.setD1(utilidadesAplicacion.diasTrancurridosUltiCumFechaCor(calculoActuarial.getUltimoCumpleanos(), request.getFechaCorte()));
        calculoActuarial.setD2(utilidadesAplicacion.diasTrancurridosProxiCumFechaCor(calculoActuarial.getProximoCumpleanos(), request.getFechaCorte()));
        calculoActuarial.setSalarioReferencia(utilidadesAplicacion.salarioReferencia(request.getSalarioBaseLiquidacion(), calculoActuarial.getEdadReferencia(), calculoActuarial.getV1()));
        calculoActuarial.setTasaReemplazo(utilidadesAplicacion.tasaReemplazo(calculoActuarial.getNumeroSalariosMinimos()));
        calculoActuarial.setPensionReferencia(utilidadesAplicacion.pensionReferencia(calculoActuarial.getSalarioReferencia(), calculoActuarial.getTasaReemplazo()));
        calculoActuarial.setAuxilioFunerario(utilidadesAplicacion.auxilioFunerario(calculoActuarial.getPensionReferencia()));
        calculoActuarial.setFactorActuarial1(utilidadesAplicacion.factorActuarial1(calculoActuarial.getEdadFR(), request.getGenero()));
        calculoActuarial.setFactorActuarial2(utilidadesAplicacion.factorActuarial2(calculoActuarial.getEdadFR(), request.getGenero()));
        calculoActuarial.setFactorActuarial3(utilidadesAplicacion.factorActuarial3(calculoActuarial.getTiempoConvalidacion(), calculoActuarial.getTiempoFaltantePension()));
        calculoActuarial.setReservaActurial(utilidadesAplicacion.reservaActuarial(calculoActuarial.getFactorActuarial1(), calculoActuarial.getPensionReferencia(), calculoActuarial.getFactorActuarial2(), calculoActuarial.getAuxilioFunerario(), calculoActuarial.getFactorActuarial3()));
        calculoActuarial.setFechaRegistro(new Date());
        calculoActuarial.setEstado("Exitoso");
        CalculoActuarialEntity entity = transformCalculoEntity(calculoActuarial);
        calculoActuarialRepository.save(entity);
        valorCalculoAc.setReservaActurial(calculoActuarial.getReservaActurial());
        valorCalculoAc.setFechaRegistro(calculoActuarial.getFechaRegistro());
        return valorCalculoAc;

    }

    /**
     * Obtener los registros de la tabla de calculo
     * @return userLista
     */
    public List<CalculoActuarial> getCalculoActuarial() {
        List<CalculoActuarialEntity> entity = new ArrayList<>();
        Iterable<CalculoActuarialEntity> userModelIterable;
        userModelIterable = calculoActuarialRepository.findAll();
        userModelIterable.forEach(entity::add);
        List<CalculoActuarial> userLista = entity.stream().map(userEntity -> transformCalculoEntityToResponse(userEntity)).collect(Collectors.toList());
        return userLista;
    }

    /**
     * Metodo para actualizar el estado de un calculo realizado
     * @param calculo
     * @return
     */
    @Override
    public CalculoActResponse calculoActurialEstado(EstadoCalculoRequest calculo) {
        CalculoActuarialEntity optionalEntity = calculoActuarialRepository.findAllByIdCalculo(calculo.getIdCalculo());
        if(optionalEntity == null){
            throw new Excepcion(MSCA_02);
        }
        optionalEntity.setEstado(calculo.getEstado());
        calculoActuarialRepository.save(optionalEntity);
        return transformCalculoResponse(optionalEntity);
    }


    /**
     * Metodo donde se transforma la entidad del calculo en una calculo response
     *
     * @param request
     * @return response
     */
    private CalculoActResponse transformCalculoResponse(CalculoActuarialEntity request) {
        CalculoActResponse response = new CalculoActResponse();
        response.setIdCalculo(request.getIdCalculo());
        response.setFechaRegistro(request.getFechaRegistro());
        response.setIdEmpleador(request.getIdEmpleador());
        response.setIdEmpleado(request.getIdEmpleado());
        response.setFechaInicioNoPago(request.getFechaInicioNoPago());
        response.setFechaCorte(request.getFechaCorte());
        response.setEstado(request.getEstado());
        return response;
    }

    /**
     * Transformar el request a la entidad empleado
     *
     * @param request
     * @return UserEntity
     */
    private CalculoActuarialEntity transformCalculoEntity(CalculoActuarial request) {
        CalculoActuarialEntity entity = new CalculoActuarialEntity();
        BeanUtils.copyProperties(request, entity);
        return entity;
    }

    /**
     * transformacio de la respuesta final para el usuario
     *
     * @param entity
     * @return UserResponse
     */
    private CalculoActuarial transformCalculoEntityToResponse(CalculoActuarialEntity entity) {
        CalculoActuarial response = new CalculoActuarial();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

    /******************************************Salario  ***********************************************/

    /**
     * Solicita Datos de entidad Salario
     *
     * @return ArrayList<SalarioEntity>
     */
    public List<SalarioResponse> getSalario() {
        List<SalarioEntity> entity = new ArrayList<>();
        Iterable<SalarioEntity> userModelIterable;
        userModelIterable = salarioMinimoRepository.findAll();
        userModelIterable.forEach(entity::add);
        List<SalarioResponse> userLista = entity.stream().map(userEntity -> transformSalarioResponse(userEntity)).collect(Collectors.toList());
        return userLista;
    }

    /**
     * Guardado de datos en la entidad Salario
     *
     * @param request
     * @return SalarioResponse
     */
    @Override
    public SalarioResponse saveSalario(SalarioRequest request) {
        Optional<SalarioEntity> entity1 = salarioMinimoRepository.findByAno(request.getAno());
        if (request.getIdSalario() != null) {
            throw new Excepcion(MSCA_01);
        } else if (entity1.isPresent()) {
            throw new Excepcion(MSCA_05);
        }
        SalarioResponse salarioRegistrado = transformSalarioResponse(salarioMinimoRepository.save(transformSalarioEntity(request)));
        return salarioRegistrado;
    }

    /**
     * Actualizacion de datos en la entidad Salario
     *
     * @param request
     * @return SalarioResponse
     */
    @Override
    public SalarioResponse updateSalario(SalarioRequest request) {
        if (request.getIdSalario() == null) {
            throw new Excepcion(MSCA_02);
        }
        SalarioResponse userId = getSalarioID(request.getIdSalario());
        if (userId != null) {
            return transformSalarioResponse(salarioMinimoRepository.save(transformSalarioEntity(request)));
        } else {
            throw new Excepcion(MSCA_03);
        }
    }

    /**
     * Eliminar registro por ID en la entidad Salario
     *
     * @param id
     */

    @Override
    public void deleteSalarioID(Integer id) {
        salarioMinimoRepository.deleteById(id);
    }

    /**
     * Obtener datos por ID en la entidad Salario
     *
     * @param id
     * @return SalarioResponse
     */
    @Override
    public SalarioResponse getSalarioID(Integer id) {
        Optional<SalarioEntity> optionalSalarioEntity = salarioMinimoRepository.findById(id);
        if (!optionalSalarioEntity.isPresent()) {
            throw new Excepcion(MSCA_03);
        }
        return transformSalarioResponse(optionalSalarioEntity.get());
    }


    /**
     * Transformar el request a la entidad Salario
     *
     * @param request
     * @return SalarioEntity
     */
    private SalarioEntity transformSalarioEntity(SalarioRequest request) {
        SalarioEntity entity = new SalarioEntity();
        BeanUtils.copyProperties(request, entity);
        return entity;
    }

    /**
     * transformacio de la respuesta final para el Salario
     *
     * @param entity
     * @return SalarioResponse
     */
    private SalarioResponse transformSalarioResponse(SalarioEntity entity) {
        SalarioResponse response = new SalarioResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

    @Override
    public List<EdadReferenciaResponse> getEdadRefencia() {
        List<EdadReferenciaEntity> entity = new ArrayList<>();
        Iterable<EdadReferenciaEntity> userModelIterable;
        userModelIterable = edadRefenciaRepository.findAll();
        userModelIterable.forEach(entity::add);
        List<EdadReferenciaResponse> userLista = entity.stream().map(userEntity -> transformEdadReferenciaResponse(userEntity)).collect(Collectors.toList());
        return userLista;
    }

    @Override
    public EdadReferenciaResponse actualizarEdadReferencia(EdadReferenciaRequest request) {
        if (request.getIdEdad() == null) {
            throw new Excepcion(MSCA_02);
        }
        SalarioResponse userId = getSalarioID(request.getIdEdad());
        if (userId != null) {
            return transformEdadReferenciaResponse(edadRefenciaRepository.save(transformEdadReferenciaEntity(request)));
        } else {
            throw new Excepcion(MSCA_03);
        }
    }

    /**
     * transformacio de la respuesta final para la edad de referencia
     *
     * @param entity
     * @return EdadReferenciaResponse
     */
    private EdadReferenciaResponse transformEdadReferenciaResponse(EdadReferenciaEntity entity) {
        EdadReferenciaResponse response = new EdadReferenciaResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }


    /**
     * Transformar el request a la entidad edad referencia
     *
     * @param request
     * @return EdadReferenciaEntity
     */
    private EdadReferenciaEntity transformEdadReferenciaEntity(EdadReferenciaRequest request) {
        EdadReferenciaEntity entity = new EdadReferenciaEntity();
        BeanUtils.copyProperties(request, entity);
        return entity;
    }
}
