package com.tienda.tienda.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedido {
    @Id
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @Id
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @NotNull
    private int cantidad;

    @NotNull
    private double precio_unidad;

    @NotNull
    private double precio_total;
}
