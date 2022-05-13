package com.tienda.tienda.provider;

import com.tienda.tienda.dto.ProductoDTO;
import com.tienda.tienda.entity.Producto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface ProductoProvider {

    Producto addProducto(Producto producto);

    List<ProductoDTO> findAllProductosDTO();

    Producto findProductoById(Long id);

    void deleteProducto(Long id);

    Producto updateProducto(Producto producto);
}
