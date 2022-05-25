package com.tienda.tienda.providerImpl;


import com.tienda.tienda.dto.ProductoDTO;
import com.tienda.tienda.entity.Pedido;
import com.tienda.tienda.entity.Producto;
import com.tienda.tienda.provider.ProductoProvider;
import com.tienda.tienda.repository.CategoriaRepo;
import com.tienda.tienda.repository.ProductoRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoProviderImpl implements ProductoProvider {

    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private CategoriaRepo categoriaRepo;

    String error = "No se encontró el producto.";

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Producto addProducto(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setId(productoDTO.getId());
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setStock(productoDTO.getStock());
        for (int i = 0; i< categoriaRepo.findAll().size(); i++){
            if (categoriaRepo.findAll().get(i).getNombre().equals(productoDTO.getCategoriaNombre())){
                producto.setCategoria(categoriaRepo.findAll().get(i));
                break;
            }
        }
        return productoRepo.save(producto);
    }

    @Override
    public List<ProductoDTO> findAllProductosDTO() {
        List<ProductoDTO> productos = new ArrayList<>();
        for(int i =0; i < productoRepo.findAll().size(); i++) {
            Producto producto = productoRepo.findAll().get(i);
            ProductoDTO productoDTO = modelMapper.map(producto, ProductoDTO.class);
            productos.add(productoDTO);
        }
        return productos;
    }

    @Override
    public Producto findProductoById(Long id) {
       return productoRepo.findProductoById(id).orElseThrow(() -> new IllegalArgumentException(error));

    }

    @Override
    public List<Producto> findAllProductos() {
        return productoRepo.findAll();
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepo.deleteProductoById(id);
    }

    @Override
    public Producto updateProducto(ProductoDTO productoDTO) {
        if(productoRepo.findProductoById(productoDTO.getId()).isPresent()) {
            Producto producto = new Producto();
            producto.setId(productoDTO.getId());
            producto.setNombre(productoDTO.getNombre());
            producto.setDescripcion(productoDTO.getDescripcion());
            producto.setPrecio(productoDTO.getPrecio());
            producto.setStock(productoDTO.getStock());
            for (int i = 0; i< categoriaRepo.findAll().size(); i++){
                if (categoriaRepo.findAll().get(i).getNombre().equals(productoDTO.getCategoriaNombre())){
                    producto.setCategoria(categoriaRepo.findAll().get(i));
                    break;
                }
            }
            return productoRepo.save(producto);
        } else {
            throw new IllegalArgumentException(error);
        }
    }
}
