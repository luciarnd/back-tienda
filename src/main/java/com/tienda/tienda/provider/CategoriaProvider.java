package com.tienda.tienda.provider;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tienda.tienda.entity.Categoria;




@Service
@Transactional
public interface CategoriaProvider {

    Categoria addCategoria(Categoria categoria);

    List<Categoria> findAllCategoria();

    Categoria findCategoriaById(Long id);

    void deleteCategoria(Long id);

    Categoria updateCategoria(Categoria categoria);
}