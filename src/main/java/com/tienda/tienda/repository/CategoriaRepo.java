package com.tienda.tienda.repository;

import com.tienda.tienda.entity.Categoria;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepo extends JpaRepository<Categoria, Long> {

	Optional<Categoria> findCategoriaById(Long id);

	void deleteCategoria(Long id);
}