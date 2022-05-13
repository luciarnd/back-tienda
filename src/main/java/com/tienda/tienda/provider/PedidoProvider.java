package com.tienda.tienda.provider;

import com.tienda.tienda.entity.Pedido;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface PedidoProvider {
    Pedido addPedido(Pedido pedido);

    List<Pedido> findAllPedidos();

    Pedido findPedidoById(int id);

    void deletePedido(int id);

    Pedido updatePedido(Pedido pedido);
}
