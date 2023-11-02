package com.libertadores.pensiones.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "fac1")
public class FactorActuarial1Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fac1")
    private Integer idFac1;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "hombres")
    private double hombres;
    @Column(name = "mujeres")
    private double mujeres;
}
