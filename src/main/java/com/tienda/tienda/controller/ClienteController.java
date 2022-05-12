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

import com.tienda.tienda.entity.Cliente;
import com.tienda.tienda.provider.ClienteProvider;

@Component
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteProvider clienteProvider;
	
	@GetMapping("/all")
	public ResponseEntity<List<Cliente>> getAllClientes(){
		List<Cliente> clientes = clienteProvider.findAllCliente();
		return new ResponseEntity<>(clientes,HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Cliente> findCategoria(@PathVariable("id") Long id){
		Cliente cliente=clienteProvider.findClienteById(id);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente){
		Cliente newCliente = clienteProvider.addClinete(cliente);
		return new ResponseEntity<>(newCliente,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente){
		Cliente upcliente= clienteProvider.updateCliente(cliente);
		return new ResponseEntity<>(upcliente, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") Long id) {
		clienteProvider.deleteClienteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
