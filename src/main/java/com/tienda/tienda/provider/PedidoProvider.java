package com.tienda.tienda.provider;

import com.tienda.tienda.dto.PedidoDTO;
import com.tienda.tienda.entity.PedidoEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface PedidoProvider {
    PedidoEntity addPedido(PedidoDTO pedidoDTO);

    List<PedidoDTO> findDistinct();

    PedidoEntity findPedidoById(Long id);

    void deletePedido(Long id);

    PedidoEntity updatePedido(PedidoDTO pedidoDTO);

    void deletePedidoByProducto(Long id, Long productoId);
}
