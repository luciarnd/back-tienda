package com.tienda.tienda.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private String nombre;

    private String descripcion;

    @NotNull
    private double precio;

    @NotNull
    private int stock;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @NotNull
    private Categoria categoria;

}
