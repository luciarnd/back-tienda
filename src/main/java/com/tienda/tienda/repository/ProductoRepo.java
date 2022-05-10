package com.tienda.tienda.repository;

import com.tienda.tienda.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepo extends JpaRepository<Producto, String> {
}
