package com.tienda.tienda.dto;



import java.io.Serializable;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoDTO implements Serializable {
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio_unidad() {
		return precio_unidad;
	}

	public void setPrecio_unidad(double precio_unidad) {
		this.precio_unidad = precio_unidad;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getProductoNombre() {
		return productoNombre;
	}

	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}

	private Long id;
	
	private int cantidad;
	
	private double precio_unidad;
	
	private Long pedidoId;
	
	private String productoNombre;

	

}
