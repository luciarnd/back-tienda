package com.tienda.tienda.provider;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tienda.tienda.entity.Cliente;



@Service
@Transactional
public interface ClienteProvider {

    Cliente addClinete(Cliente cliente);

    List<Cliente> findAllCliente();

    Cliente findClienteById(Long id);

    void deleteCliente(Long id);

    Cliente updateCliente(Cliente cliente);
}