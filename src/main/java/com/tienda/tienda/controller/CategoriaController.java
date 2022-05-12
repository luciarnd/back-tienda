package com.tienda.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.tienda.entity.Categoria;
import com.tienda.tienda.provider.CategoriaProvider;



@Component
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	 
	@Autowired
	private CategoriaProvider categoriaProvider;
	
	@GetMapping("/all")
	public ResponseEntity<List<Categoria>> getAllCategories(){
		List<Categoria> categorias = categoriaProvider.findAllCategoria();
		return new ResponseEntity<>(categorias,HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Categoria> findCategoria(@PathVariable("id") Long id){
		Categoria categoria=categoriaProvider.findCategoriaById(id);
		return new ResponseEntity<>(categoria, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Categoria> addCategoria(@RequestBody Categoria categoria){
		Categoria newCategoria= categoriaProvider.addCategoria(categoria);
		return new ResponseEntity<>(newCategoria,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria){
		Categoria upcategoria= categoriaProvider.updateCategoria(categoria);
		return new ResponseEntity<>(upcategoria, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Categoria> deleteCategory(@PathVariable("id") Long id) {
		categoriaProvider.deleteCategoriaById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
