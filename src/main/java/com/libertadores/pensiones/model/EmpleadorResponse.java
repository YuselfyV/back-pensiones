package com.libertadores.pensiones.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(content = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadorResponse {
    private Integer idEmpleador;
    private String tipoDocumentoEmpleador;
    private String identificadorEmpleador;
    private String nombreEmpleador;
    private String telefonoEmpleador;
    private String correoEmpleador;
}
