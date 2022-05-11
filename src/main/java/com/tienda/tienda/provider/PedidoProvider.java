package com.tienda.tienda.provider;

import com.tienda.tienda.entity.Pedido;
import com.tienda.tienda.entity.Producto;

import java.util.List;

public interface PedidoProvider {
    Pedido addPedido(Pedido pedido);

    List<Pedido> findAllPedidos();

    Pedido findPedidoById(Long id);

    void deletePedido(Long id);

    Pedido updatePedido(Pedido pedido);
}
