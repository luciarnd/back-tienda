package com.tienda.tienda.provider;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tienda.tienda.entity.Producto;

@Service
@Transactional
public interface ExcelProvider {
		ByteArrayInputStream createExcel(List<Producto> producto);
}
