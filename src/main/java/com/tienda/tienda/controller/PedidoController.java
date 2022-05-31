package com.tienda.tienda.controller;

import com.tienda.tienda.dto.PedidoDTO;
import com.tienda.tienda.entity.PedidoEntity;
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
        List<PedidoDTO> pedidos = pedidoProvider.findDistinct();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PedidoEntity> getPedidoById(@PathVariable("id") Long id){
        PedidoEntity pedido = pedidoProvider.findPedidoById(id);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PedidoEntity> addPedido(@RequestBody PedidoDTO pedidoDTO){
    	PedidoEntity newPedido= pedidoProvider.addPedido(pedidoDTO);
        return new ResponseEntity<>(newPedido, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<PedidoEntity> updatePedido(@RequestBody PedidoDTO pedidoDTO){
    	PedidoEntity upPedido=pedidoProvider.updatePedido(pedidoDTO);
        return new ResponseEntity<>(upPedido, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PedidoEntity> deletePedido(@PathVariable("id") Long id){
        pedidoProvider.deletePedido(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletePedidoByProducto/{id}/{productoId}")
    public ResponseEntity<PedidoEntity> deletePedidoByProducto(@PathVariable("id") Long id, @PathVariable("productoId") Long productoId) {
        pedidoProvider.deletePedidoByProducto(id, productoId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
