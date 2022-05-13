package com.tienda.tienda.provider;

import com.tienda.tienda.dto.PedidoDTO;
import com.tienda.tienda.entity.Pedido;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface PedidoProvider {
    Pedido addPedido(Pedido pedido);

    List<PedidoDTO> findAllPedidosDTO();

    Pedido findPedidoById(Long id);

    void deletePedido(int id);

    Pedido updatePedido(Pedido pedido);
}
