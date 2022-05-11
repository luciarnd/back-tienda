package com.tienda.tienda.controller;


import com.tienda.tienda.entity.DetallePedido;
import com.tienda.tienda.entity.DetallePedidoId;
import com.tienda.tienda.entity.Pedido;
import com.tienda.tienda.provider.DetallePedidoProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/detallepedidos")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoProvider detallePedidoProvider;

    @GetMapping("/all")
    public ResponseEntity<List<DetallePedido>> getAllDetallePedidos(){
        List<DetallePedido> detallePedidos = detallePedidoProvider.findAllDetallePedido();
        return new ResponseEntity<>(detallePedidos, HttpStatus.OK);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<DetallePedido> getDetallePedidoById(@PathVariable("id") DetallePedidoId id){
        DetallePedido detallePedido = detallePedidoProvider.findDetallePedidoById(id);
        return new ResponseEntity<>(detallePedido, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DetallePedido> addDetallePedido(@RequestBody DetallePedido detallePedido){
        return new ResponseEntity<>(detallePedido, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<DetallePedido> updateDetallePedido(@RequestBody DetallePedido detallePedido){
        return new ResponseEntity<>(detallePedido, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DetallePedido> deleteDetallePedido(@PathVariable("id") DetallePedidoId id){
        detallePedidoProvider.deleteDetallePedido(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
