package com.tienda.tienda.provider;

import com.tienda.tienda.entity.Producto;

import java.util.List;

public interface ProductoProvider {

    Producto addProducto(Producto producto);

    List<Producto> findAllProductos();

    Producto findProductoById(Long id);

    void deleteProducto(Long id);

    Producto updateProducto(Producto producto);
}
