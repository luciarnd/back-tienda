package com.tienda.tienda.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO implements Serializable {

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getClienteNombreCompleto() {
		return clienteNombreCompleto;
	}

	public void setClienteNombreCompleto(String clienteNombreCompleto) {
		this.clienteNombreCompleto = clienteNombreCompleto;
	}

	private Long id;

    private Date fecha;

    private String clienteNombreCompleto;


}
