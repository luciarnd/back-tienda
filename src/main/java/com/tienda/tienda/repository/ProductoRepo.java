package com.tienda.tienda.repository;

import com.tienda.tienda.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepo extends JpaRepository<ProductoEntity, Long> {
   Optional <ProductoEntity> findProductoById(Long id);

    void deleteProductoById(Long id);
}
