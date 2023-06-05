package com.libertadores.pensiones.controller;

import static com.libertadores.pensiones.utils.Constantes.DELETE_DATA;
import static com.libertadores.pensiones.utils.Constantes.SAVE_DATA;
import static com.libertadores.pensiones.utils.Constantes.UPDATE_DATA;

import java.util.List;

import com.libertadores.pensiones.model.EmpleadoRequest;
import com.libertadores.pensiones.model.EmpleadoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.libertadores.pensiones.model.EmpleadorRequest;
import com.libertadores.pensiones.model.EmpleadorResponse;
import com.libertadores.pensiones.service.CalculoActuarialService;
import com.libertadores.pensiones.utils.Response;

@RestController
@RequestMapping("libertadores")
@CrossOrigin("*")
public class CalculoActuarialController {
    @Autowired
    CalculoActuarialService service;

    @GetMapping(value = "/empleador/general", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<EmpleadorResponse> getEmpleador() {
        return this.service.getEmpleador();
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

    @GetMapping(value = "/empleado/general", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<EmpleadoResponse> getEmpleado() {
        return this.service.getEmpleado();
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

    @GetMapping(value = "/calculoAc", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<EmpleadorResponse> calculoActurial() {
        return this.service.getEmpleador();
    }

}
