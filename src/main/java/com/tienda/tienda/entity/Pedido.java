package com.tienda.tienda.entity;



import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PedidoId.class)
public class Pedido implements Serializable {

	@Id
    @NotNull
    private Long id;

	@Id
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_producto")
	private ProductoEntity producto;

    @NotNull
    private Date fecha;

	@NotNull
	private int cantidad;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @NotNull
    private ClienteEntity cliente;

	
}
