package com.libertadores.pensiones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroUsuarioRequest {

    private Integer idUsuario;
    private String username;
    private String password;
    private String tipoUsuario;
    private String estado;
    private String nombre;
}
