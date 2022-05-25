package com.tienda.tienda.repository;

import com.tienda.tienda.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepo extends JpaRepository<Pedido, Long> {
    Optional<Pedido> findPedidoById(Long  id);

    void deletePedidoById(Long id);
}
