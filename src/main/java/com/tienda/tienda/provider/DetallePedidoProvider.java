package com.tienda.tienda.provider;

import com.tienda.tienda.entity.DetallePedido;
import com.tienda.tienda.entity.DetallePedidoId;
import com.tienda.tienda.entity.Producto;

import java.util.List;


public interface DetallePedidoProvider {

    DetallePedido addDetallePedido(DetallePedido detallePedido);

    List<DetallePedido> findAllDetallePedido();

    DetallePedido findDetallePedidoById(DetallePedidoId detallePedidoId);

    void deleteDetallePedido(DetallePedidoId detallePedidoId);

    DetallePedido updateDetallePedido(DetallePedido detallePedido);

}
