package com.tienda.tienda.provider;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tienda.tienda.entity.ClienteEntity;



@Service
@Transactional
public interface ClienteProvider {

    ClienteEntity addClinete(ClienteEntity cliente);

    List<ClienteEntity> findAllCliente();

    ClienteEntity findClienteById(Long id);

    ClienteEntity updateCliente(ClienteEntity cliente);

	void deleteClienteById(Long id);
}