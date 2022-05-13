package com.tienda.tienda.controller;

import com.tienda.tienda.dto.PedidoDTO;
import com.tienda.tienda.entity.Pedido;
import com.tienda.tienda.provider.PedidoProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoProvider pedidoProvider;

    @GetMapping("/all")
    public ResponseEntity<List<PedidoDTO>> getAllPedidos(){
        List<PedidoDTO> pedidos = pedidoProvider.findAllPedidosDTO();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PedidoDTO> getPedidoById(@PathVariable("id") Long id){
        PedidoDTO pedido = pedidoProvider.findPedidoById(id);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Pedido> addPedido(@RequestBody Pedido pedido){
    	Pedido newPedido= pedidoProvider.addPedido(pedido);
        return new ResponseEntity<>(newPedido, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Pedido> updatePedido(@RequestBody Pedido pedido){
    	Pedido upPedido=pedidoProvider.updatePedido(pedido);
        return new ResponseEntity<>(upPedido, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Pedido> deletePedido(@PathVariable("id") Long id){
        pedidoProvider.deletePedido(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
