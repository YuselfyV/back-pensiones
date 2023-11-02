package com.libertadores.pensiones.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "salario_minimo")
public class SalarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salario")
    private Integer idSalario;
    @Column(name = "ano")
    private Integer ano;
    @Column(name = "salario")
    private double salario;
}
