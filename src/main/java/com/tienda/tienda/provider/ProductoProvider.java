package com.tienda.tienda.provider;

import com.tienda.tienda.entity.Producto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface ProductoProvider {

    Producto addProducto(Producto producto);

    List<Producto> findAllProductos();

    Producto findProductoById(Long id);

    void deleteProducto(Long id);

    Producto updateProducto(Producto producto);
}