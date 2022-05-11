package com.tienda.tienda.providerImpl;

import com.tienda.tienda.entity.Pedido;
import com.tienda.tienda.entity.Producto;
import com.tienda.tienda.provider.PedidoProvider;
import com.tienda.tienda.repository.PedidoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PedidoProviderImpl implements PedidoProvider {

    @Autowired
    private PedidoRepo pedidoRepo;

    String error = "No se encontró el pedido.";

    @Override
    public Pedido addPedido(Pedido pedido) {
        return pedidoRepo.save(pedido);
    }

    @Override
    public List<Pedido> findAllPedidos() {
        return pedidoRepo.findAll();
    }

    @Override
    public Pedido findPedidoById(Long id) {
        return pedidoRepo.findPedidoById(id).orElseThrow(() -> new IllegalArgumentException(error));
    }

    @Override
    public void deletePedido(Long id) {
        pedidoRepo.deletePedidoById(id);
    }

    @Override
    public Pedido updatePedido(Pedido pedido) {
        if(pedidoRepo.findPedidoById(pedido.getId()).isPresent()) {
            return pedidoRepo.save(pedido);
        } else {
            throw new IllegalArgumentException(error);
        }
    }
}
