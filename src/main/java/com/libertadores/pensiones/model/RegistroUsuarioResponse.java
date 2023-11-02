package com.libertadores.pensiones.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(content = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class RegistroUsuarioResponse {

    private Integer idUsuario;
    private String username;
    private String password;
    private String tipoUsuario;
    private String estado;
    private String nombre;
}
