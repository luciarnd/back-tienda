package com.tienda.tienda.repository;


import com.tienda.tienda.entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetallePedidoRepo extends JpaRepository<DetallePedido, Long> {
   Optional<DetallePedido> findDetallePedidoById(Long id);
    
    
    void deleteDetallePedidoById(Long id);



}
