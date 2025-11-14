/**
 *
 * @author Rodrigo
 */
package Apartado3;


// Importa de internet el paquete "XmlMapper".
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

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
        String fileName = "C:\\Users\\rodri\\OneDrive\\Documentos\\NetBeansProjects\\ExamenAED_UT0y1\\Alumnos.xml";
        
        // Crea el mapeador.
        XmlMapper xmlMapper = new XmlMapper();

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
        
        // Contenedor requerido para XML. Envuelve la lista en una clase contenedor.
        ListaAlumnos lista = new ListaAlumnos(alumnos);
        
        try{
            // Escribimos la lista (Alumnos) de objetos (alumnos) en un archivo ".xml".
            xmlMapper.writeValue(new File(fileName), lista);
            
            // Muestreo del resultado final.
            System.out.println("\n\n\tEl archivo de extensión \".xml\" ha sido creado correctamente.");
        } catch (IOException ioex){
            JOptionPane.showMessageDialog(null, "Error inesperado durante la creación del archivo \".xml\": " + ioex.getMessage(), "Error de creación", JOptionPane.ERROR_MESSAGE);
            ioex.printStackTrace();
        }
        
        // Objeto donde guardar lo leído de la lista.
        ListaAlumnos listaLeida = null;
        
        try{
            // Muestreo del resultado final.
            System.out.println("\n\n\tAccediendo al archivo de extensión \".xml\" recientemente creado...");
            
            // Leemos el archivo ".xml" recién creado.
            listaLeida = xmlMapper.readValue(new File(fileName), ListaAlumnos.class);
        } catch (IOException ioex){
            JOptionPane.showMessageDialog(null, "Error inesperado durante la lectura del archivo \".xml\" recientemente creado: " + ioex.getMessage(), "Error de lectura", JOptionPane.ERROR_MESSAGE);
            ioex.printStackTrace();
        }
        
        if (listaLeida == null){
            System.out.println("\n\n\tLa lista está vacía.");
            return;
        }
        
        // Declara las variables que haran las funciones de contador.
        int totalAlumnos = listaLeida.getAlumnos().size();
        double mediaEdad = 0;
        double mediaAltura = 0;
        
        // Recorre la lista y muestra cada alumno leído.
        for (Alumno alumnosLeido : listaLeida.getAlumnos()){
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