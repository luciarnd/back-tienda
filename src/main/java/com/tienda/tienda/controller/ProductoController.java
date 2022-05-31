package com.tienda.tienda.controller;

import com.tienda.tienda.dto.ProductoDTO;
import com.tienda.tienda.entity.ProductoEntity;
import com.tienda.tienda.provider.ProductoProvider;
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
    public ResponseEntity<List<ProductoDTO>> getAllProductos() {
        List<ProductoDTO> productos = productoProvider.findAllProductosDTO();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<ProductoEntity> getProductoById(@PathVariable("id") Long id){
        ProductoEntity producto = productoProvider.findProductoById(id);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductoEntity> addProducto(@RequestBody ProductoDTO productoDTO){
    	ProductoEntity newProducto=productoProvider.addProducto(productoDTO);
        return new ResponseEntity<>(newProducto, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductoEntity> updateProducto(@RequestBody ProductoDTO productoDTO){
    	ProductoEntity upProducto = productoProvider.updateProducto(productoDTO);
        return new ResponseEntity<>(upProducto, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductoEntity> deleteProdcuto(@PathVariable("id") Long id){
        productoProvider.deleteProducto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
