package com.example.demo.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.example.demo.entidad.Alumno;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

//https://www.tutorialspoint.com/convert-pojo-to-xml-using-the-jackson-library-in-java
public class GenerateXML {

	public static void main(String[] args) {
		Alumno obj1 = new Alumno(1 , "Luis");
		Alumno obj2 = new Alumno(2 , "Elba");
		Alumno obj3 = new Alumno(3 , "Diana");
		
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		lista.add(obj1);
		lista.add(obj2);
		lista.add(obj3);

		FileWriter file = null;
		 try {
			file = new FileWriter("D:/files/alumnos.xml");
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.writeValue(file,lista);
		} catch (Exception e) {
			try {
				file.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
