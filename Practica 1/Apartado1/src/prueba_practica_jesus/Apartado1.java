package prueba_practica_jesus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Apartado1 {

  public static void main(String[] args) {
    final String fileName = "alumnos.txt";
    String line = "";
    int alumnostotales = 0;
    int edadtotal = 0;
    double alturatotal = 0;
    
    List<String> listaAlumnos = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      Scanner sc;
      while ((line = br.readLine()) != null) {
        listaAlumnos.add(line);

        sc = new Scanner(line).useLocale(Locale.US);
        sc.useDelimiter("\\s*,\\s*");

        sc.next();
        edadtotal += sc.nextInt();
        alturatotal += sc.nextDouble();
        alumnostotales++;
      }

      //Mostrar Resultados
      System.out.println("--- Listado de Alumnos ---");
            for (String alumno : listaAlumnos) {
                System.out.println(alumno);
            }
      System.out.println("--------------------------");
      System.out.println("Hay en total " + alumnostotales + " alumnos.");
      System.out.printf("Edad Media: %2.2f.\n", ((double) edadtotal / alumnostotales));
      System.out.printf("Altura Media: %2.2f.\n", (alturatotal / alumnostotales));

    } catch (IOException ioe) {
      System.out.println("Error: No se ha encontrado el fichero");
    }

  }
}
