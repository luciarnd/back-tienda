package com.tienda.tienda.repository;

import com.tienda.tienda.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PedidoRepo extends JpaRepository<PedidoEntity, Long> {
    Optional<PedidoEntity> findPedidoById(Long  id);

    void deletePedidoById(Long id);

    void deletePedidoByIdAndProductoId(Long id, Long productoId);

    /*@Query("SELECT DISTINCT id FROM PedidoEntity")*/
    /*List<PedidoEntity> getPedidos();*/
}

