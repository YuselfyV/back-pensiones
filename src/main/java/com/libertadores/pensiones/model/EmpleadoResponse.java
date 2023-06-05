package com.libertadores.pensiones.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@JsonInclude(content = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoResponse {
    private Integer idEmpleado;
    private String tipoDocumentoEmpleado;
    private String identificadorEmpleado;
    private String nombresEmpleado;
    private String apellidosEmpleado;
    private String direccionEmpleado;
    private String telefonoEmpleado;
    private String correoEmpleado;
    private String fechaNacimientoEmpleado;
}
