package com.libertadores.pensiones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadorRequest {
    private Integer idEmpleador;
    private String tipoDocumentoEmpleador;
    private String identificadorEmpleador;
    private String nombreEmpleador;
    private String telefonoEmpleador;
    private String correoEmpleador;
}
