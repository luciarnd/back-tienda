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

@Service
@Transactional
public class PedidoProviderImpl implements PedidoProvider {
    

    @Autowired
    private PedidoRepo pedidoRepo;


    private ModelMapper modelMapper = new ModelMapper();

    String error = "No se encontró el pedido.";

    @Override
    public Pedido addPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = modelMapper.map(pedidoDTO, Pedido.class);
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
    public Pedido findPedidoById(Long id) {
    return pedidoRepo.findPedidoById(id).orElseThrow(() -> new IllegalArgumentException(error));
    }

    @Override
    public void deletePedido(Long id) {
        pedidoRepo.deletePedidoById(id);
    }

    @Override
    public Pedido updatePedido(PedidoDTO pedidoDTO) {
        if(pedidoRepo.findPedidoById(pedidoDTO.getId()).isPresent()) {
            Pedido pedido = modelMapper.map(pedidoDTO, Pedido.class);
            return pedidoRepo.save(pedido);
        } else {
            throw new IllegalArgumentException(error);
        }
    }
}
