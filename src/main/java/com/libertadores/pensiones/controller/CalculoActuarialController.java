package com.libertadores.pensiones.controller;

import static com.libertadores.pensiones.utils.Constantes.DELETE_DATA;
import static com.libertadores.pensiones.utils.Constantes.SAVE_DATA;
import static com.libertadores.pensiones.utils.Constantes.UPDATE_DATA;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import com.libertadores.pensiones.model.*;
import com.libertadores.pensiones.persistence.entity.EdadReferenciaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.libertadores.pensiones.service.CalculoActuarialService;
import com.libertadores.pensiones.utils.Response;

@RestController
@RequestMapping("libertadores")
@CrossOrigin("*")
public class CalculoActuarialController {
    @Autowired
    CalculoActuarialService service;

    /**
     * Crud Empleador
     *
     */
    @GetMapping(value = "/empleador/general", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<EmpleadorResponse> getEmpleador() {
        return this.service.getEmpleador();
    }


    @GetMapping("/empleador/{id}")
    public Optional<EmpleadorResponse> getEmpleadorID(@PathVariable Integer id){
        return Optional.ofNullable(service.getEmpleadorID(id));
    }
    @PostMapping(value = "/empleador", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response<EmpleadorResponse>> saveEmpleador(@RequestBody EmpleadorRequest entity) {
        return new ResponseEntity<>(new Response<>(service.saveEmpleador(entity), SAVE_DATA), HttpStatus.OK);
    }

    @PutMapping(value = "/empleador", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response<EmpleadorResponse>> updateEmpleador(@RequestBody EmpleadorRequest entity) {
        return new ResponseEntity<>(new Response<>(service.updateEmpleador(entity), UPDATE_DATA), HttpStatus.OK);
    }

    @DeleteMapping(value = "/empleador/{id}")
    public ResponseEntity<Response<EmpleadorResponse>> deleteEmpleador(@Validated @PathVariable Integer id) {
        service.deleteEmpleadorID(id);
        return new ResponseEntity<>(new Response<>(null, DELETE_DATA), HttpStatus.OK);
    }
    /**
     * Crud empleado
     *
     */
    @GetMapping(value = "/empleado/general", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<EmpleadoResponse> getEmpleado() {
        return this.service.getEmpleado();
    }

    @GetMapping("/empleado/{id}")
    public Optional<EmpleadoResponse> getEmpleadoID(@PathVariable Integer id){
        return Optional.ofNullable(service.getEmpleadoID(id));
    }

    @PostMapping(value = "/empleado", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response<EmpleadoResponse>> saveEmpleado(@RequestBody EmpleadoRequest entity) {
        return new ResponseEntity<>(new Response<>(service.saveEmpleado(entity), SAVE_DATA), HttpStatus.OK);
    }

    @PutMapping(value = "/empleado", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response<EmpleadoResponse>> updateEmpleado(@RequestBody EmpleadoRequest entity) {
        return new ResponseEntity<>(new Response<>(service.updateEmpleado(entity), UPDATE_DATA), HttpStatus.OK);
    }


    @DeleteMapping(value = "/empleado/{id}")
    public ResponseEntity<Response<EmpleadoResponse>> deleteEmpleado(@Validated @PathVariable Integer id) {
        service.deleteEmpleadoID(id);
        return new ResponseEntity<>(new Response<>(null, DELETE_DATA), HttpStatus.OK);
    }

    /**
     * Crud usuario
     *
     */

    @GetMapping(value = "/usuario/general", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<RegistroUsuarioResponse> getUsuario() {
        return this.service.getUsuario();
    }

    @GetMapping("/usuario/{id}")
    public Optional<RegistroUsuarioResponse> getUsuarioID(@PathVariable Integer id){
        return Optional.ofNullable(service.getUsuarioID(id));
    }

    @PostMapping(value = "/usuario", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response<RegistroUsuarioResponse>> saveUsuario(@RequestBody RegistroUsuarioRequest entity) {
        return new ResponseEntity<>(new Response<>(service.saveUsuario(entity), SAVE_DATA), HttpStatus.OK);
    }

    @PutMapping(value = "/usuario", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response<RegistroUsuarioResponse>> updateUsuario(@RequestBody RegistroUsuarioRequest entity) {
        return new ResponseEntity<>(new Response<>(service.updateUsuario(entity), UPDATE_DATA), HttpStatus.OK);
    }

    @PutMapping(value = "/usuario/password", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response<RegistroUsuarioResponse>> updateUsuarioPassword(@RequestBody PasswordRequest request) {
        return new ResponseEntity<>(new Response<>(service.updateUsuarioPassword(request), UPDATE_DATA), HttpStatus.OK);
    }

    /**
     * Calculo
     *
     */
    @PostMapping(value = "/calculoAc", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ValorCalculoAc calculoActurial(@RequestBody CalculoRequest calculo) throws ParseException {
            return this.service.calculoActorial(calculo);
    }

    @GetMapping(value = "/calculoAc/general", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<CalculoActuarial> getCalculoActuarial() {
        return this.service.getCalculoActuarial();
    }

    @PutMapping(value = "/calculoAc/estado", produces = { MediaType.APPLICATION_JSON_VALUE })
    public CalculoActResponse calculoActurialEstado(@RequestBody EstadoCalculoRequest calculo) throws ParseException {
        return this.service.calculoActurialEstado(calculo);
    }


    /**
     * Crud Salario
     *
     */
    @GetMapping(value = "/salario/general", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<SalarioResponse> getSalario() {
        return this.service.getSalario();
    }

    @PostMapping(value = "/salario", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response<SalarioResponse>> saveSalario(@RequestBody SalarioRequest entity) {
        return new ResponseEntity<>(new Response<>(service.saveSalario(entity), SAVE_DATA), HttpStatus.OK);
    }

    @PutMapping(value = "/salario", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response<SalarioResponse>> updateSalario(@RequestBody SalarioRequest entity) {
        return new ResponseEntity<>(new Response<>(service.updateSalario(entity), UPDATE_DATA), HttpStatus.OK);
    }


    @DeleteMapping(value = "/salario/{id}")
    public ResponseEntity<Response<SalarioResponse>> deleteSalario(@Validated @PathVariable Integer id) {
        service.deleteSalarioID(id);
        return new ResponseEntity<>(new Response<>(null, DELETE_DATA), HttpStatus.OK);
    }

    @GetMapping("/salario/{id}")
    public Optional<SalarioResponse> getSalarioID(@PathVariable Integer id){
        return Optional.ofNullable(service.getSalarioID(id));
    }

    @GetMapping(value = "/edadReferencia/general", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<EdadReferenciaResponse> getEdadReferencia() {
        return this.service.getEdadRefencia();
    }

    @PutMapping(value = "/edadReferencia", produces = { MediaType.APPLICATION_JSON_VALUE })
    public EdadReferenciaResponse actualizarEdadReferencia(@RequestBody EdadReferenciaRequest calculo) throws ParseException {
        return this.service.actualizarEdadReferencia(calculo);
    }

}
