package com.tienda.tienda.repository;

import com.tienda.tienda.entity.CategoriaEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepo extends JpaRepository<CategoriaEntity, Long> {

	Optional<CategoriaEntity> findCategoriaById(Long id);

	void deleteCategoriaById(Long id);
}