package com.tienda.tienda.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoId implements Serializable {

    private Pedido pedidoid;

    private Producto productoid;
}
