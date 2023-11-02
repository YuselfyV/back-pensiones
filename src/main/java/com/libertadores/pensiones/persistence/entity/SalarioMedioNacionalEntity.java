package com.libertadores.pensiones.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "salario_medio_nacional")
public class SalarioMedioNacionalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_smn")
    private Integer idSMN;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "salario_medio")
    private double salarioMedio;
}
