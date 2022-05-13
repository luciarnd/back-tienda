package com.tienda.tienda.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidosDTO {
	
	
	private Long id;
	
	private String fecha;
	
	private Long cliente;
}
