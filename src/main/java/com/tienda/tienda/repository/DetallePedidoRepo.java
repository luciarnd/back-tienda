package com.tienda.tienda.repository;

import com.tienda.tienda.entity.DetallePedido;
import com.tienda.tienda.entity.DetallePedidoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetallePedidoRepo extends JpaRepository<DetallePedido, DetallePedidoId> {
    Optional<DetallePedido> findDetallePedidoById(DetallePedidoId detallePedidoId);

    void deleteDetallePedidoById(DetallePedidoId detallePedidoId);
}
