package com.tienda.tienda.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoId implements Serializable {
    private Long id;

<<<<<<< HEAD
    private Long productoId;
=======
    private Long producto;
>>>>>>> 4ecb52158fb7008c4fd5a45e88cfc7d753ff2f54
}
