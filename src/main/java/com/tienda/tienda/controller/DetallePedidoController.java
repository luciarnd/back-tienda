package com.tienda.tienda.controller;



import com.tienda.tienda.dto.DetallePedidoDTO;
import com.tienda.tienda.entity.DetallePedido;


import com.tienda.tienda.provider.DetallePedidoProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Component
@RestController
@RequestMapping("/detallepedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoProvider detallePedidoProvider;

    @GetMapping("/all")
    public ResponseEntity<List<DetallePedidoDTO>> getAllDetallePedidos(){
        List<DetallePedidoDTO> detallePedido = detallePedidoProvider.findAllDetallePedidoDTO() ;
        return new ResponseEntity<>(detallePedido, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<DetallePedido> getDetallePedidoById(@PathVariable("id") Long id){
        DetallePedido detallePedido = detallePedidoProvider.findDetallePedidoById(id);
        return new ResponseEntity<>(detallePedido, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DetallePedido> addDetallePedido(@RequestBody DetallePedido detallePedido){
    	DetallePedido newDetallePedido = detallePedidoProvider.addDetallePedido(detallePedido);
        return new ResponseEntity<>(newDetallePedido, HttpStatus.CREATED);
    }
  

    @PutMapping("/update")
    public ResponseEntity<DetallePedido> updateDetallePedido(@RequestBody DetallePedido detallePedido){
    	DetallePedido upDetallePedido= detallePedidoProvider.updateDetallePedido(detallePedido);
        return new ResponseEntity<>(upDetallePedido, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DetallePedido> deleteDetallePedido(@PathVariable("id") Long id){
        detallePedidoProvider.deleteDetallePedido(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
