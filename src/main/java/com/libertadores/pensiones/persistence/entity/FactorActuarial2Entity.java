package com.libertadores.pensiones.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "fac2")
public class FactorActuarial2Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fac2")
    private Integer idFac1;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "hombres")
    private double hombres;
    @Column(name = "mujeres")
    private double mujeres;
}
