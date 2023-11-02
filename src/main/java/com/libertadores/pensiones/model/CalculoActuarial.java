package com.libertadores.pensiones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculoActuarial {

    private Integer idCalculo;
    private Integer idEmpleado;
    private Integer idEmpleador;
    private BigDecimal salarioBaseLiquidacion;
    private LocalDate ultimoCumpleanos;
    private LocalDate proximoCumpleanos;
    private double salarioMinimoFechaCorte;
    private BigDecimal numeroSalariosMinimos;
    private Integer edadReferencia;
    private LocalDate fechaReferencia;
    private Integer semanasMinimas;
    private LocalDate fechaCumplimiento;
    private LocalDate fechaFR;
    private Integer edadFR;
    private double tiempoFaltantePension;
    private Integer edadFechaCorte;
    private BigDecimal v1;
    private double v2;
    private Integer d1;
    private Integer d2;
    private double tiempoConvalidacion;
    private long smnInterpolado;
    private BigDecimal salarioReferencia;
    private double tasaReemplazo;
    private BigDecimal pensionReferencia;
    private BigDecimal auxilioFunerario;
    private BigDecimal factorActuarial1;
    private BigDecimal factorActuarial2;
    private BigDecimal factorActuarial3;
    private BigDecimal reservaActurial;
    private Date fechaRegistro;
    private LocalDate fechaInicioNoPago;
    private LocalDate fechaCorte;
    private String estado;
    private Integer idUsuario;
}
