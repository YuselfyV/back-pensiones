package com.libertadores.pensiones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.BeanInfo;
import java.math.BigDecimal;
import java.security.PrivateKey;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculoRequest {

    private Integer idEmpleado;
    private Integer idEmpleador;
    private LocalDate fechaInicioNoPago;
    private LocalDate fechaCorte;
    private BigDecimal salarioBaseLiquidacion;
    private LocalDate fechaNacimiento;
    private String genero;
    private Integer idUsuario;
}
