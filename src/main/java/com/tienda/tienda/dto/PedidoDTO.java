package com.tienda.tienda.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
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
