package com.tienda.tienda.providerImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tienda.tienda.entity.ProductoEntity;

public class ExcelProviderImpl{
	public static ByteArrayInputStream createExcel(List<ProductoEntity> producto) {
		try (XSSFWorkbook workbook = new XSSFWorkbook()) {

			Sheet sheetProductos = workbook.createSheet("Productos");

			Row rowProductos = sheetProductos.createRow(0);

			Cell cellProductos = rowProductos.createCell(0);
			cellProductos.setCellValue("ID");

			cellProductos = rowProductos.createCell(1);
			cellProductos.setCellValue("Nombre");

			cellProductos = rowProductos.createCell(2);
			cellProductos.setCellValue("Descripcion");

			cellProductos = rowProductos.createCell(3);
			cellProductos.setCellValue("Precio");

			cellProductos = rowProductos.createCell(4);
			cellProductos.setCellValue("Stock");

			cellProductos = rowProductos.createCell(5);
			cellProductos.setCellValue("Categoria");

			for (int i = 0; i < producto.size(); i++) {
				Row dataRowProductos = sheetProductos.createRow(i + 1);
				dataRowProductos.createCell(0).setCellValue(producto.get(i).getId());
				dataRowProductos.createCell(1).setCellValue(producto.get(i).getNombre());
				dataRowProductos.createCell(2).setCellValue(producto.get(i).getDescripcion());
				dataRowProductos.createCell(3).setCellValue(producto.get(i).getPrecio());
				dataRowProductos.createCell(4).setCellValue(producto.get(i).getStock());
				dataRowProductos.createCell(5).setCellValue(producto.get(i).getCategoria().getNombre());
			}

			sheetProductos.autoSizeColumn(0);
			sheetProductos.autoSizeColumn(1);
			sheetProductos.autoSizeColumn(2);
			sheetProductos.autoSizeColumn(3);
			sheetProductos.autoSizeColumn(4);
			sheetProductos.autoSizeColumn(5);

			ByteArrayOutputStream output = new ByteArrayOutputStream();
			workbook.write(output);

			return new ByteArrayInputStream(output.toByteArray());
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
