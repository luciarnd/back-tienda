package com.tienda.tienda.provider;

import com.tienda.tienda.dto.ProductoDTO;
import com.tienda.tienda.entity.ProductoEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface ProductoProvider {

    ProductoEntity addProducto(ProductoDTO productoDTO);

    List<ProductoDTO> findAllProductosDTO();

    ProductoEntity findProductoById(Long id);

    List<ProductoEntity>findAllProductos();
    
    void deleteProducto(Long id);

    ProductoEntity updateProducto(ProductoDTO producto);
}
