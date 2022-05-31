package com.tienda.tienda.providerImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.tienda.entity.CategoriaEntity;
import com.tienda.tienda.provider.CategoriaProvider;
import com.tienda.tienda.repository.CategoriaRepo;

@Service
@Transactional
public class CategoriaProviderImpl implements CategoriaProvider{
	@Autowired
	private CategoriaRepo categoriaRepo;
	
	String error = "No se encontro la categoria";
	
	@Override
	public CategoriaEntity addCategoria(CategoriaEntity categoria) {
		return categoriaRepo.save(categoria);
	}

	@Override
	public List<CategoriaEntity> findAllCategoria() {
		
		return categoriaRepo.findAll();
	}

	@Override
	public CategoriaEntity findCategoriaById(Long id) {
		return categoriaRepo.findCategoriaById(id).orElseThrow(() -> new IllegalArgumentException(error));
	}

	@Override
	public void deleteCategoriaById(Long id) {
		categoriaRepo.deleteCategoriaById(id);
		
	}

	@Override
	public CategoriaEntity updateCategoria(CategoriaEntity categoria) {
		if(categoriaRepo.findCategoriaById(categoria.getId()).isPresent()) {
            return categoriaRepo.save(categoria);
        } else {
            throw new IllegalArgumentException(error);
        }
	}

}
