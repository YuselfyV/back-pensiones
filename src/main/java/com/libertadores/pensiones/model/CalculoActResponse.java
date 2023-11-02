package com.libertadores.pensiones.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@JsonInclude(content = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class CalculoActResponse {

    private Integer idCalculo;
    private Integer idEmpleado;
    private Integer idEmpleador;
    private String identificadorEmpleado;
    private LocalDate fechaInicioNoPago;
    private LocalDate fechaCorte;
    private Date fechaRegistro;
    private String estado;
    private Integer idUsuario;



}
