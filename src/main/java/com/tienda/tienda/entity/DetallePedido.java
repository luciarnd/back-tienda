package com.tienda.tienda.entity;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedido implements Serializable {

    @EmbeddedId DetallePedidoId id;

    @NotNull
    private int cantidad;

    @NotNull
    private double precio_unidad;

    @NonNull
    private double precio_total;

}

