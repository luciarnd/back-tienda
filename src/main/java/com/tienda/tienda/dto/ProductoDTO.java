package com.tienda.tienda.dto;

import com.tienda.tienda.entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO implements Serializable {

    private Long id;

    private String nombre;

    private String descripcion;

    private double precio;

    private int stock;

    private String categoriaNombre;
}
