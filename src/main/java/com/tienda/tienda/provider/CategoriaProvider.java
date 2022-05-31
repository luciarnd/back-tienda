package com.tienda.tienda.provider;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tienda.tienda.entity.CategoriaEntity;




@Service
@Transactional
public interface CategoriaProvider {

    CategoriaEntity addCategoria(CategoriaEntity categoria);

    List<CategoriaEntity> findAllCategoria();

    CategoriaEntity findCategoriaById(Long id);

    CategoriaEntity updateCategoria(CategoriaEntity categoria);

	void deleteCategoriaById(Long id);


}