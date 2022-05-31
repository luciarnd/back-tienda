package com.tienda.tienda.providerImpl;


import com.tienda.tienda.dto.ProductoDTO;
import com.tienda.tienda.entity.ProductoEntity;
import com.tienda.tienda.provider.ProductoProvider;
import com.tienda.tienda.repository.CategoriaRepo;
import com.tienda.tienda.repository.ProductoRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductoProviderImpl implements ProductoProvider {

    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private CategoriaRepo categoriaRepo;

    String error = "No se encontró el producto.";

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public ProductoEntity addProducto(ProductoDTO productoDTO) {
        ProductoEntity producto = modelMapper.map(productoDTO, ProductoEntity.class);
        return productoRepo.save(producto);
    }

    @Override
    public List<ProductoDTO> findAllProductosDTO() {
        List<ProductoDTO> productos = new ArrayList<>();
        for(int i =0; i < productoRepo.findAll().size(); i++) {
            ProductoEntity producto = productoRepo.findAll().get(i);
            ProductoDTO productoDTO = modelMapper.map(producto, ProductoDTO.class);
            productos.add(productoDTO);
        }
        return productos;
    }

    @Override
    public ProductoEntity findProductoById(Long id) {
       return productoRepo.findProductoById(id).orElseThrow(() -> new IllegalArgumentException(error));

    }

    @Override
    public List<ProductoEntity> findAllProductos() {
        return productoRepo.findAll();
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepo.deleteProductoById(id);
    }

    @Override
    public ProductoEntity updateProducto(ProductoDTO productoDTO) {
        if (productoRepo.findProductoById(productoDTO.getId()).isPresent()) {
            ProductoEntity producto = modelMapper.map(productoDTO, ProductoEntity.class);
            return productoRepo.save(producto);
        } else {
            throw new IllegalArgumentException(error);
        }
    }
}
