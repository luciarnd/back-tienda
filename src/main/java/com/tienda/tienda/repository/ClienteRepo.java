package com.tienda.tienda.repository;

import com.tienda.tienda.entity.ClienteEntity;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository<ClienteEntity, Long> {
	Optional<ClienteEntity> findClienteById(Long id);

	void deleteClienteById(Long id);
}