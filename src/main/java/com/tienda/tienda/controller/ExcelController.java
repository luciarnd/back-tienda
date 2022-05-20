package com.tienda.tienda.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.tienda.provider.ExcelProvider;
import com.tienda.tienda.provider.ProductoProvider;
import com.tienda.tienda.providerImpl.ExcelProviderImpl;

@RestController
@RequestMapping("/excel")
@Controller
public class ExcelController {

	@Autowired
	private ProductoProvider productoProvider;
	
	@GetMapping("/download")
	public void downloadExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=productos.xlsx");
        ByteArrayInputStream stream = ExcelProviderImpl.createExcel(productoProvider.findAllProductos());
        IOUtils.copy(stream, response.getOutputStream());
    }
	
}
