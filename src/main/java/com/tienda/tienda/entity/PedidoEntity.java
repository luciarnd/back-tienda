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
@Table(name="Pedido")
@IdClass(PedidoId.class)
public class PedidoEntity implements Serializable {

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
