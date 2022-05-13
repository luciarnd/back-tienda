package com.tienda.tienda.providerImpl;

import com.tienda.tienda.dto.PedidoDTO;
import com.tienda.tienda.dto.ProductoDTO;
import com.tienda.tienda.entity.Pedido;
import com.tienda.tienda.entity.Producto;
import com.tienda.tienda.provider.ProductoProvider;
import com.tienda.tienda.repository.ProductoRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoProviderImpl implements ProductoProvider {

    @Autowired
    private ProductoRepo productoRepo;

    String error = "No se encontró el producto.";

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Producto addProducto(Producto producto) {
        return productoRepo.save(producto);
    }

    @Override
    public List<ProductoDTO> findAllProductosDTO() {
        List<ProductoDTO> productos = new ArrayList<>();
        for(int i =0; i < productoRepo.findAll().size(); i++) {
            Producto producto = productoRepo.findAll().get(i);
            ProductoDTO productoDTO = modelMapper.map(producto, ProductoDTO.class);
            productos.add(productoDTO);
        }
        return productos;
    }

    @Override
    public Producto findProductoById(Long id) {
       return productoRepo.findProductoById(id).orElseThrow(() -> new IllegalArgumentException(error));

    }

    @Override
    public void deleteProducto(Long id) {
        productoRepo.deleteProductoById(id);
    }

    @Override
    public Producto updateProducto(Producto producto) {
        if(productoRepo.findProductoById(producto.getId()).isPresent()) {
            return productoRepo.save(producto);
        } else {
            throw new IllegalArgumentException(error);
        }
    }
}
