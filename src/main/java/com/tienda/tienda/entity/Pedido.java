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

	
}
