package com.libertadores.pensiones.model;

import com.libertadores.pensiones.utils.Constantes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

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
