/**
 *
 * @author Rodrigo
 */
package Apartado2;


// Importa de internet el paquete "TypeReference".
import com.fasterxml.jackson.core.type.TypeReference;
// Importa de internet el paquete "ObjectMapper".
import com.fasterxml.jackson.databind.ObjectMapper;

// Importa de internet el paquete "File".
import java.io.File;
// Importa de internet el paquete "IOException".
import java.io.IOException;
// Importa de internet el paquete "ArrayList".
import java.util.ArrayList;
// Importa de internet el paquete "List".
import java.util.List;
// Importa de internet el paquete "JOptionPane".
import javax.swing.JOptionPane;

public class Main{
    public static void main(String[] args){
        // Declara una variable de tipo cadena para definir la ruta del archivo.
        String fileName = "C:\\Users\\rodri\\OneDrive\\Documentos\\NetBeansProjects\\ExamenAED_UT0y1\\Alumnos.json";
        
        // Crea el mapeador.
        ObjectMapper mapeador = new ObjectMapper();

        // Lista donde guardaremos los alumnos (como pide el examen)
        List<Alumno> alumnos = new ArrayList<>();
        
        // A?adimos los alumnos manualmente.
        alumnos.add(new Alumno("Daniel Martín Gómez",       14, 1.62));
        alumnos.add(new Alumno("Laura Sánchez Torres",      15, 1.58));
        alumnos.add(new Alumno("Pablo Herrera Ruiz",        14, 1.66));
        alumnos.add(new Alumno("Marta Fernández López",     15, 1.63));
        alumnos.add(new Alumno("Alejandro Pérez Hidalgo",   16, 1.70));
        alumnos.add(new Alumno("Carla Morales Díaz",        14, 1.55));
        alumnos.add(new Alumno("Javier Romero Castillo",    15, 1.68));
        alumnos.add(new Alumno("Irene Navarro García",      14, 1.60));
        alumnos.add(new Alumno("Sergio Ortega Ramos",       16, 1.72));
        alumnos.add(new Alumno("Lucía Vázquez Martínez",    15, 1.64));
        
        try{
            // Escribimos la lista (Alumnos) de objetos (alumnos) en un archivo ".json".
            mapeador.writeValue(new File(fileName), alumnos);
            
            // Muestreo del resultado final.
            System.out.println("\n\n\tEl archivo de extensión \".json\" ha sido creado correctamente.");
        } catch (IOException ioex){
            JOptionPane.showMessageDialog(null, "Error inesperado durante la creación del archivo \".json\": " + ioex.getMessage(), "Error de creación", JOptionPane.ERROR_MESSAGE);
            ioex.printStackTrace();
        }
        
        // Variable donde se guardará la lista leída del JSON
        List<Alumno> alumnosLeidos = null;
        
        try{
            // Muestreo del resultado final.
            System.out.println("\n\n\tAccediendo al archivo de extensión \".json\" recientemente creado...");
            
            // Leemos el archivo ".json" recién creado.
            alumnosLeidos = mapeador.readValue(new File(fileName), new TypeReference<List<Alumno>>() {});
        } catch (IOException ioex){
            JOptionPane.showMessageDialog(null, "Error inesperado durante la lectura del archivo \".json\" recientemente creado: " + ioex.getMessage(), "Error de lectura", JOptionPane.ERROR_MESSAGE);
            ioex.printStackTrace();
        }
        
        if (alumnosLeidos == null){
            System.out.println("\n\n\tLa lista está vacía.");
            return;
        }
        
        // Declara las variables que haran las funciones de contador.
        int totalAlumnos = alumnosLeidos.size();
        double mediaEdad = 0;
        double mediaAltura = 0;
        
        // Recorre la lista y muestra cada alumno leído.
        for (Alumno alumnosLeido : alumnosLeidos){
            System.out.println(alumnosLeido);
            mediaEdad += alumnosLeido.getEdad();
            mediaAltura += alumnosLeido.getAltura();
        }
        
        // Muestreo del resultado final.
        System.out.println("\n\n==============================================================================================================");
        System.out.print("\tEl número total de alumnos registrados en la lista es de: " + totalAlumnos);
        System.out.printf("\n\tLa edad media total de entre todos los alumnos registrados en la lista es de: %2.2f a?os", ((double)mediaEdad / totalAlumnos));
        System.out.printf("\n\tLa altura media total de entre todos los alumnos registrados en la lista es de: %2.2fm\n", (mediaAltura / totalAlumnos));
        System.out.print("==============================================================================================================");
    }
}