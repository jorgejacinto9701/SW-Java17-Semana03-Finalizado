package com.example.demo.excel;

import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.demo.entidad.Alumno;

public class GenerateExcel {

	private static String[] HEADERs = { "CÓDIGO", "NOMBRE" };
	private static int[] HEADER_WITH = { 3000, 10000 };
	private static String SHEET = "Listado";

	public static void main(String[] args) {

		Alumno obj1 = new Alumno(1, "Luis");
		Alumno obj2 = new Alumno(2, "Elba");
		Alumno obj3 = new Alumno(3, "Diana");

		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		lista.add(obj1);
		lista.add(obj2);
		lista.add(obj3);

		try {
			FileOutputStream outputStream = new FileOutputStream("D:/files/alumnos.xlsx");
			Workbook excel = new XSSFWorkbook();
			Sheet hoja = excel.createSheet(SHEET);

			//Tamaño de las celdas
			for (int i = 0; i < HEADER_WITH.length; i++) {
				hoja.setColumnWidth(i, HEADER_WITH[i]);
			}
			
			//Tamaño el texto de las cabeceras
			Row fila1 = hoja.createRow(0);
			for (int i = 0; i < HEADERs.length; i++) {
				Cell celda1 = fila1.createCell(i);
				celda1.setCellValue(HEADERs[i]);
			}
			
			//Se genera la data
			int rowIdx = 1;
			for (Alumno obj : lista) {
				Row row = hoja.createRow(rowIdx++);

				Cell cel0 = row.createCell(0);
				cel0.setCellValue(obj.getIdAlumno());

				Cell cel1 = row.createCell(1);
				cel1.setCellValue(obj.getNombre());

			}
			excel.write(outputStream);
			excel.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
