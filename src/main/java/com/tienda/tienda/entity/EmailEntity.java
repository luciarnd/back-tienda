package com.tienda.tienda.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmailEntity {
	private String email;
	
	private String asunto;
	
	private String Mensaje;

}
