package com.libertadores.pensiones.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoCalculoRequest {
    private Integer idCalculo;
    private String estado;
}
