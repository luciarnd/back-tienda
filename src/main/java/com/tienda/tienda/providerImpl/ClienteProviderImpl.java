package com.tienda.tienda.providerImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.tienda.entity.Cliente;
import com.tienda.tienda.provider.ClienteProvider;
import com.tienda.tienda.repository.ClienteRepo;

@Service
@Transactional
public class ClienteProviderImpl implements ClienteProvider{

	@Autowired
	private ClienteRepo clienteRepo;
	String error = "No se encontro el cliente.";
	
	@Override
	public Cliente addClinete(Cliente cliente) {
		
		return clienteRepo.save(cliente);
	}

	@Override
	public List<Cliente> findAllCliente() {
		return clienteRepo.findAll();
	}

	@Override
	public Cliente findClienteById(Long id) {
		return clienteRepo.findClienteById(id).orElseThrow(() -> new IllegalArgumentException(error));
	}
	@Override
	public void deleteClienteById(Long id) {
		clienteRepo.deleteClienteById(id);
		
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		if(clienteRepo.findClienteById(cliente.getId()).isPresent()) {
            return clienteRepo.save(cliente);
        } else {
            throw new IllegalArgumentException(error);
        }
	}
}


