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

	private Long id;

	private Long productoId;

	private String productoNombre;

    private Date fecha;

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	private int cantidad;

	private Long clienteId;

	private String clienteNombre;

	private String clienteApellido1;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public String getProductoNombre() {
		return productoNombre;
	}

	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
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
}
