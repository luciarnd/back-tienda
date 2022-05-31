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

import com.tienda.tienda.entity.ClienteEntity;
import com.tienda.tienda.provider.ClienteProvider;

@Component
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteProvider clienteProvider;
	
	@GetMapping("/all")
	public ResponseEntity<List<ClienteEntity>> getAllClientes(){
		List<ClienteEntity> clientes = clienteProvider.findAllCliente();
		return new ResponseEntity<>(clientes,HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<ClienteEntity> findCategoria(@PathVariable("id") Long id){
		ClienteEntity cliente=clienteProvider.findClienteById(id);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<ClienteEntity> addCliente(@RequestBody ClienteEntity cliente){
		ClienteEntity newCliente = clienteProvider.addClinete(cliente);
		return new ResponseEntity<>(newCliente,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ClienteEntity> updateCliente(@RequestBody ClienteEntity cliente){
		ClienteEntity upcliente= clienteProvider.updateCliente(cliente);
		return new ResponseEntity<>(upcliente, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ClienteEntity> deleteCliente(@PathVariable("id") Long id) {
		clienteProvider.deleteClienteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
