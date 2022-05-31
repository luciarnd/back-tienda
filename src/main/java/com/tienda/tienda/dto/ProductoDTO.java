package com.tienda.tienda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoDTO implements Serializable {

    private Long id;

    private String nombre;

    private String descripcion;

    private double precio;

    private int stock;

	private Long categoriaId;

    private String categoriaNombre;
    
    
}
