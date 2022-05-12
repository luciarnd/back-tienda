package com.tienda.tienda.controller;

import com.tienda.tienda.entity.Pedido;
import com.tienda.tienda.entity.Producto;
import com.tienda.tienda.provider.ProductoProvider;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoProvider productoProvider;

    @GetMapping("/all")
    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> productos = productoProvider.findAllProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable("id") Long id){
        Producto producto = productoProvider.findProductoById(id);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Producto> addProducto(@RequestBody Producto producto){
    	Producto newProducto=productoProvider.addProducto(producto);
        return new ResponseEntity<>(newProducto, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto){
    	Producto upProducto = productoProvider.updateProducto(producto);
        return new ResponseEntity<>(upProducto, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Producto> deleteProdcuto(@PathVariable("id") Long id){
        productoProvider.deleteProducto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
