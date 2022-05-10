package com.tienda.tienda.repository;

import com.tienda.tienda.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepo extends JpaRepository<Pedido, String> {
}
