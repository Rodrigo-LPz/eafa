package com.mycompany.apartado2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class jsonAlumnos {

  public static void main(String[] args) {
    ObjectMapper mapper = new ObjectMapper();

    // Ruta del archivo JSON (Usaremos esta misma variable para escribir y leer)
    String fileName = "C:\\Users\\Alumno\\Documents\\NetBeansProjects\\Apartado2\\alumnos.txt";

    try {
      List<Alumno> listaAlumnos = new ArrayList<>();
      listaAlumnos.add(new Alumno("Luis García", 20, 1.75));
      listaAlumnos.add(new Alumno("Ana Martínez", 22, 1.68));
      listaAlumnos.add(new Alumno("Javier Ruiz", 19, 1.82));
      listaAlumnos.add(new Alumno("Sofía Pérez", 21, 1.65));

      System.out.println("Lista de alumnos creada.");

      // CORRECCIÓN: Usamos 'fileName' para asegurarnos de que se guarda en la ubicación completa.
      mapper.writeValue(new File(fileName), listaAlumnos); 
      System.out.println("Lista de alumnos almacenada en " + fileName);

      // Ahora la lectura funciona correctamente ya que el archivo está en la ubicación 'fileName'
      List<Alumno> alumnosLeidos = mapper.readValue(new File(fileName),
        new TypeReference<List<Alumno>>() {
        });

      // Variables y lógica de cálculo...
      int totalAlumnos = 0;
      int totalAge = 0;
      double totalHeigth = 0;

      for (Alumno j : alumnosLeidos) {
        System.out.println(j); // Mostrar alumno por alumno
        totalAlumnos++;
        totalAge += j.getEdad();
        totalHeigth += j.getAltura();
      }

      // Imprimimos resultados
      System.out.println("\nHay en total " + totalAlumnos + " alumnos.");
      System.out.printf("Edad Media: %.2f años.\n", ((double) totalAge / totalAlumnos));
      System.out.printf("Altura Media: %.2f metros.\n", (totalHeigth / totalAlumnos));

    } catch (IOException ioe) {
      System.err.println("Error al leer/escribir el archivo JSON: " + ioe.getMessage());
      ioe.printStackTrace();
    }
  }
}