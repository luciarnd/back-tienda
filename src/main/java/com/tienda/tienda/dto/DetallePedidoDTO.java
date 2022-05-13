package com.tienda.tienda.dto;



import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetallePedidoDTO implements Serializable {
	
	private Long id;
	
	private int cantidad;
	
	private double precio_unidad;
	
	private String pedidoId;
	
	private String productoNombre;

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

	public String getPedido() {
		return pedidoId;
	}

	public void setPedido(String pedido) {
		this.pedidoId = pedido;
	}

	public String getProducto() {
		return productoNombre;
	}

	public void setProducto(String producto) {
		this.productoNombre = producto;
	}
	
	

}
