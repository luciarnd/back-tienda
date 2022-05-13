package com.tienda.tienda.provider;

import com.tienda.tienda.dtos.DetallePedidoDTO;
import com.tienda.tienda.entity.DetallePedido;


import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface DetallePedidoProvider {

	

    DetallePedido addDetallePedido(DetallePedido detallePedido);
	
    List<DetallePedidoDTO> findAllDetallePedidoDTO();

    DetallePedido findDetallePedidoById(Long id);

    void deleteDetallePedido(Long id);

    DetallePedido updateDetallePedido(DetallePedido detallePedido);

    DetallePedidoDTO detallePedidoToDetallePedidoDTO(DetallePedido detallePedido);
    
    DetallePedido  detallePedidoDTOtoDetallePedido(DetallePedidoDTO detallePedidoDTO);
}
