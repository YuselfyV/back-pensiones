package com.libertadores.pensiones.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "semanas_minimas")
public class SemanasMinimasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sem_min")
    private Integer idSemMin;
    @Column(name = "año")
    private Integer ano;
    @Column(name = "sem_min")
    private Integer semMin;
}
