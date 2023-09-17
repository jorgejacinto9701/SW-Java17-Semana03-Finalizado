package com.example.demo.json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.example.demo.entidad.Alumno;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GenerateJSON {

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
			file = new FileWriter("D:/files/alumnos.json");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(lista, file);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
}
