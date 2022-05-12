package com.tienda.tienda.repository;

import com.tienda.tienda.entity.Cliente;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository<Cliente, Long> {
	Optional<Cliente> findClienteById(Long id);

	void deleteClienteById(Long id);
}