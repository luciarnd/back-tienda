package com.tienda.tienda.providerImpl;

import com.tienda.tienda.dto.PedidoDTO;
import com.tienda.tienda.entity.Pedido;
import com.tienda.tienda.provider.PedidoProvider;
import com.tienda.tienda.repository.PedidoRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PedidoProviderImpl implements PedidoProvider {
    

    @Autowired
    private PedidoRepo pedidoRepo;

    private ModelMapper modelMapper = new ModelMapper();

    String error = "No se encontró el pedido.";

    @Override
    public Pedido addPedido(Pedido pedido) {
        return pedidoRepo.save(pedido);
    }

    @Override
    public List<PedidoDTO> findAllPedidosDTO() {
        List<PedidoDTO> pedidos = new ArrayList<>();
        for(int i =0; i < pedidoRepo.findAll().size(); i++) {
            Pedido pedido = pedidoRepo.findAll().get(i);
            PedidoDTO pedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
            pedidos.add(pedidoDTO);
        }
        return pedidos;
    }

    @Override
    public PedidoDTO findPedidoById(Long id) {
        Optional<Pedido> pedido = pedidoRepo.findById(id);
        PedidoDTO pedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
        return pedidoDTO;
    }

    @Override
    public void deletePedido(int  id) {
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
