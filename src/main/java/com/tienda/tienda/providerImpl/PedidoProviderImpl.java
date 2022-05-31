package com.tienda.tienda.providerImpl;

import com.tienda.tienda.dto.PedidoDTO;
import com.tienda.tienda.entity.PedidoEntity;
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
    public PedidoEntity addPedido(PedidoDTO pedidoDTO) {
        PedidoEntity pedido = modelMapper.map(pedidoDTO, PedidoEntity.class);
        return pedidoRepo.save(pedido);
    }

    @Override
    public List<PedidoDTO> findDistinct() {
        List<PedidoDTO> pedidos = new ArrayList<PedidoDTO>();
        List<PedidoEntity> pedidoEntity = pedidoRepo.findAll();
        for(PedidoEntity pedido : pedidoEntity) {
            PedidoDTO pedidoDTO = modelMapper.map(pedido, PedidoDTO.class);
            pedidos.add(pedidoDTO);
        }
        return pedidos;
    }

    @Override
    public PedidoEntity findPedidoById(Long id) {
    return pedidoRepo.findPedidoById(id).orElseThrow(() -> new IllegalArgumentException(error));
    }

    @Override
    public void deletePedido(Long id) {
        pedidoRepo.deletePedidoById(id);
    }

    @Override
    public PedidoEntity updatePedido(PedidoDTO pedidoDTO) {
        if(pedidoRepo.findPedidoById(pedidoDTO.getId()).isPresent()) {
            PedidoEntity pedido = modelMapper.map(pedidoDTO, PedidoEntity.class);
            return pedidoRepo.save(pedido);
        } else {
            throw new IllegalArgumentException(error);
        }
    }

    @Override
    public void deletePedidoByProducto(Long id, Long productoId) {
        pedidoRepo.deletePedidoByIdAndProductoId(id, productoId);
    }
}
