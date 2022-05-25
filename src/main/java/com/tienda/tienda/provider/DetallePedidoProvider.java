package com.tienda.tienda.provider;

import com.tienda.tienda.dto.DetallePedidoDTO;
import com.tienda.tienda.entity.DetallePedido;


import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface DetallePedidoProvider {

	
    List<DetallePedidoDTO> findAllDetallePedidoDTO();

    DetallePedido findDetallePedidoById(Long id);

    void deleteDetallePedido(Long id);

    DetallePedido updateDetallePedido(DetallePedidoDTO detallePedido);

	DetallePedido addDetallePedido(DetallePedidoDTO detallePedido);


//    DetallePedidoDTO detallePedidoToDetallePedidoDTO(DetallePedido detallePedido);
//    
//    DetallePedido  detallePedidoDTOtoDetallePedido(DetallePedidoDTO detallePedidoDTO);
}
