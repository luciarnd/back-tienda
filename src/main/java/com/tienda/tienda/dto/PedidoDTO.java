package com.tienda.tienda.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidoDTO implements Serializable {

    private Long id;

    private String fecha;

    private String clienteNombre;

    private String clienteApellido1;
}
