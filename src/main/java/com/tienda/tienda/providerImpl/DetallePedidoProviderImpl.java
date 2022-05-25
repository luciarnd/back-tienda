package com.tienda.tienda.providerImpl;

import com.tienda.tienda.dto.DetallePedidoDTO;

import com.tienda.tienda.entity.DetallePedido;

import com.tienda.tienda.provider.DetallePedidoProvider;
import com.tienda.tienda.repository.DetallePedidoRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class DetallePedidoProviderImpl implements DetallePedidoProvider {

	@Autowired
	public DetallePedidoRepo detallePedidoRepo;
	

	 private ModelMapper mapper = new ModelMapper();

	String error = "No se encontró el detalle de pedido.";

	@Override
	public DetallePedido addDetallePedido(DetallePedidoDTO detallePedidoDto) {
		DetallePedido  detallePedido = new DetallePedido();
		detallePedido= mapper.map(detallePedidoDto, DetallePedido.class);
		return detallePedidoRepo.save(detallePedido);
	}

	@Override
	public List<DetallePedidoDTO> findAllDetallePedidoDTO() {
		   List<DetallePedidoDTO> listDTO = new ArrayList<>();
		    for(int i =0; i < detallePedidoRepo.findAll().size(); i++) {
		        DetallePedido detallePedido = detallePedidoRepo.findAll().get(i);
		        DetallePedidoDTO detallePedidoDTO = mapper.map(detallePedido, DetallePedidoDTO.class);
		        listDTO.add(detallePedidoDTO);
		    }
	
		return listDTO;
	}

	@Override
	public DetallePedido findDetallePedidoById(Long id) {
	        return detallePedidoRepo.findDetallePedidoById(id).orElseThrow(() -> new IllegalArgumentException(error));
	}

	@Override
	public void deleteDetallePedido(Long id) {
		detallePedidoRepo.deleteDetallePedidoById(id);
	}

	@Override
	public DetallePedido updateDetallePedido(DetallePedido detallePedido) {
		if(detallePedidoRepo.findDetallePedidoById(detallePedido.getId()).isPresent()) {
            return detallePedidoRepo.save(detallePedido);
        } else {
            throw new IllegalArgumentException(error);
        }
	}
	
//	public DetallePedidoDTO detallePedidoToDetallePedidoDTO(DetallePedido detallePedido) {
//		DetallePedidoDTO detallePedidoDTO = mapper.map(detallePedido, DetallePedidoDTO.class);
//		return detallePedidoDTO;
//	}
//	
//	public DetallePedido detallePedidoDTOtoDetallePedido(DetallePedidoDTO detallePedidoDTO) {
//		DetallePedido detallePedido = mapper.map(detallePedidoDTO, DetallePedido.class);
//		return detallePedido;
//		
//	}


}
