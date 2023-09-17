package com.example.demo.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GenerateZip {

	public static void main(String[] args) {
		try {
			ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream("D:/files/consolidado.zip"));
			
			 //Crea el archivo 
			 File archivoParaComprimir = new File("D:/files/alumnos.json");
			 FileInputStream fis = new FileInputStream(archivoParaComprimir);
			
			 //Crea la entrada
			 ZipEntry zipEntry = new ZipEntry(archivoParaComprimir.getName());
			 zipOut.putNextEntry(zipEntry);
			 
			 //Agregar lo bytes
			 int bytes;
			 while ((bytes = fis.read()) != -1) {
			        zipOut.write(bytes);
			 }
			 fis.close();
			 zipOut.closeEntry();
			 zipOut.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
