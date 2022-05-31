package com.tienda.tienda.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidoDTO implements Serializable {

	private Long id;

	private Long productoId;

	private String productoNombre;

    private Date fecha;

	private int cantidad;

	private Long clienteId;

	private String clienteNombre;

	private String clienteApellido1;

}
