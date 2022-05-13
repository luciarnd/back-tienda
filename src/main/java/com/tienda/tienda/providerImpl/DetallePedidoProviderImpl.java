package com.tienda.tienda.providerImpl;

import com.tienda.tienda.entity.DetallePedido;

import com.tienda.tienda.provider.DetallePedidoProvider;
import com.tienda.tienda.repository.DetallePedidoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DetallePedidoProviderImpl implements DetallePedidoProvider {

	@Autowired
	public DetallePedidoRepo detallePedidoRepo;


	String error = "No se encontró el detalle de pedido.";

	@Override
	public DetallePedido addDetallePedido(DetallePedido detallePedido) {
		return detallePedidoRepo.save(detallePedido);
	}

	@Override
	public List<DetallePedido> findAllDetallePedido() {
		return detallePedidoRepo.findAll();
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
		return detallePedidoRepo.save(detallePedido);
	}

}
