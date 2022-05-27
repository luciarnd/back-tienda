package com.tienda.tienda.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(PedidoId.class)
public class Pedido implements Serializable {

	@Id
    @NotNull
    private Long id;

	@Id
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;

    @NotNull
    private Date fecha;

	@NotNull
	private int cantidad;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @NotNull
    private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
