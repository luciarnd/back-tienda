package com.tienda.tienda.entity;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedido implements Serializable {

    

	@EmbeddedId DetallePedidoId id;

    @NotNull
    private int cantidad;

    @NotNull
    private double precio_unidad;

    @NotNull
    private double precio_total;
    public DetallePedidoId getId() {
		return id;
	}

	public void setId(DetallePedidoId id) {
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

	public double getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}
}

