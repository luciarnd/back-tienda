package com.tienda.tienda.providerImpl;

import com.tienda.tienda.entity.Producto;
import com.tienda.tienda.provider.ProductoProvider;
import com.tienda.tienda.repository.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductoProviderImpl implements ProductoProvider {

    @Autowired
    private ProductoRepo productoRepo;
    String error = "No se encontró el producto.";

    @Override
    public Producto addProducto(Producto producto) {
        return productoRepo.save(producto);
    }

    @Override
    public List<Producto> findAllProductos() {
        return productoRepo.findAll();
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
