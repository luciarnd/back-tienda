package com.tienda.tienda.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class DetallePedidoId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    @NotNull
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    @NotNull
    private Producto producto;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
