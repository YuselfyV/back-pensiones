package com.libertadores.pensiones.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "empleadores")
public class EmpleadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleador")
    private Integer idEmpleador;
    @Column(name = "tipo_documento_empleador")
    private String tipoDocumentoEmpleador;
    @Column(name = "identificador_empleador")
    private String identificadorEmpleador;
    @Column(name = "nombre_empleador")
    private String nombreEmpleador;
    @Column(name = "telefono_empleador")
    private String telefonoEmpleador;
    @Column(name = "correo_empleador")
    private String correoEmpleador;

}
