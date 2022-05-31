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

import com.tienda.tienda.entity.CategoriaEntity;
import com.tienda.tienda.provider.CategoriaProvider;



@Component
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	 
	@Autowired
	private CategoriaProvider categoriaProvider;
	
	@GetMapping("/all")
	public ResponseEntity<List<CategoriaEntity>> getAllCategories(){
		List<CategoriaEntity> categorias = categoriaProvider.findAllCategoria();
		return new ResponseEntity<>(categorias,HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<CategoriaEntity> findCategoria(@PathVariable("id") Long id){
		CategoriaEntity categoria=categoriaProvider.findCategoriaById(id);
		return new ResponseEntity<>(categoria, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<CategoriaEntity> addCategoria(@RequestBody CategoriaEntity categoria){
		CategoriaEntity newCategoria= categoriaProvider.addCategoria(categoria);
		return new ResponseEntity<>(newCategoria,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<CategoriaEntity> updateCategoria(@RequestBody CategoriaEntity categoria){
		CategoriaEntity upcategoria= categoriaProvider.updateCategoria(categoria);
		return new ResponseEntity<>(upcategoria, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CategoriaEntity> deleteCategory(@PathVariable("id") Long id) {
		categoriaProvider.deleteCategoriaById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
