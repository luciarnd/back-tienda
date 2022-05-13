package com.tienda.tienda.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO implements Serializable {

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getClienteNombre() {
		return clienteNombre;
	}

	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}

	public String getClienteApellido1() {
		return clienteApellido1;
	}

	public void setClienteApellido1(String clienteApellido1) {
		this.clienteApellido1 = clienteApellido1;
	}

	private Long id;

    private String fecha;

    private String clienteNombre;

    private String clienteApellido1;
}
