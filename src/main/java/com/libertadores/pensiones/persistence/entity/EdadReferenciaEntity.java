package com.libertadores.pensiones.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "edad_referencia")
public class EdadReferenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_edad")
    private Integer idEdad;
    @Column(name = "genero")
    private String genero;
    @Column(name = "edad")
    private Integer edad;
}
