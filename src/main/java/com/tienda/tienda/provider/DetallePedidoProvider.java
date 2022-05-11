package com.tienda.tienda.provider;

import com.tienda.tienda.entity.DetallePedido;
import com.tienda.tienda.entity.DetallePedidoId;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface DetallePedidoProvider {

    DetallePedido addDetallePedido(DetallePedido detallePedido);

    List<DetallePedido> findAllDetallePedido();

    DetallePedido findDetallePedidoById(DetallePedidoId detallePedidoId);

    void deleteDetallePedido(DetallePedidoId detallePedidoId);

    DetallePedido updateDetallePedido(DetallePedido detallePedido);

}
