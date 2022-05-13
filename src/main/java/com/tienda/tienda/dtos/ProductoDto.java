package com.tienda.tienda.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
		
	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private double precio;
	
	private int stock;
	
	private Long categoria;
	
}
