package com.libertadores.pensiones.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "calculo_actuarial")
public class CalculoActuarialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calculo")
    private Integer idCalculo;

    @Column(name = "id_empleado")
    private Integer idEmpleado;


    @Column(name = "id_empleador")
    private Integer idEmpleador;

    @Column(name = "ultimo_cumpleanos")
    private LocalDate ultimoCumpleanos;

    @Column(name = "proximo_cumpleanos")
    private LocalDate proximoCumpleanos;

    @Column(name = "salario_minimo_fecha_corte")
    private double salarioMinimoFechaCorte;

    @Column(name = "numero_salarios_minimos")
    private BigDecimal numeroSalariosMinimos;

    @Column(name = "edad_referencia")
    private Integer edadReferencia;

    @Column(name = "fecha_referencia")
    private LocalDate fechaReferencia;

    @Column(name = "tiempo_faltante_pension")
    private double tiempoFaltantePension;

    @Column(name = "edad_fecha_corte")
    private Integer edadFechaCorte;

    @Column(name = "v1")
    private double v1;

    @Column(name = "v2")
    private double v2;

    @Column(name = "d1")
    private Integer d1;

    @Column(name = "d2")
    private Integer d2;

    @Column(name = "tiempo_convalidacion")
    private double tiempoConvalidacion;

    @Column(name = "smn_interpolado")
    private long smnInterpolado;

    @Column(name = "salario_referencia")
    private BigDecimal salarioReferencia;

    @Column(name = "tasa_reemplazo")
    private double tasaReemplazo;

    @Column(name = "pension_referencia")
    private BigDecimal pensionReferencia;

    @Column(name = "auxilio_funerario")
    private BigDecimal auxilioFunerario;

    @Column(name = "factorA_actuarial1")
    private BigDecimal factorActuarial1;

    @Column(name = "factorA_actuarial2")
    private BigDecimal factorActuarial2;

    @Column(name = "factor_actuarial3")
    private BigDecimal factorActuarial3;

    @Column(name = "reserva_acturial")
    private BigDecimal reservaActurial;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_inicio_no_pago")
    private LocalDate fechaInicioNoPago;

    @Column(name = "fecha_corte")
    private LocalDate fechaCorte;

    @Column(name = "id_usuario")
    private Integer idUsuario;

}
