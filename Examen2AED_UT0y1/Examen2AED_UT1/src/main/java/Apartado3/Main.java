/**
 *
 * @author Rodrigo
 */
package Apartado3;


// Importa de internet el paquete "TypeReference".
import com.fasterxml.jackson.core.type.TypeReference;
// Importa de internet el paquete "ObjectMapper".
import com.fasterxml.jackson.databind.ObjectMapper;

// Importa de la biblioteca/librería el paquete "File".
import java.io.File;
// Importa de la biblioteca/librería el paquete "IOException".
import java.io.IOException;
// Importa de la biblioteca/librería el paquete "ArrayList".
import java.util.ArrayList;
// Importa de la biblioteca/librería el paquete "List".
import java.util.List;
// Importa de la biblioteca/librería el paquete "JOptionPane".
import javax.swing.JOptionPane;

public class Main{
    public static void main(String[] args){
        // Declara una variable de tipo cadena para definir la ruta del archivo.
        String fileName = "C:\\Users\\Alumno\\Documents\\ExamenRecuperaciónAED_UT0y1\\ExamenRecuperacionAED_UT1\\src\\main\\java\\Apartado3\\Biblioteca.json";
        
        // Crea el mapeador.
        ObjectMapper mapeador = new ObjectMapper();

        // Lista donde guardaremos los libros.
        List<Libro> libros = new ArrayList<>();
        
        // Añadimos los libros manualmente.
        libros.add(new Libro("Cien años de soledad",                "Gabriel García Márquez",   1967,   417));
        libros.add(new Libro("Don Quijote de la Mancha",            "Miguel de Cervantes",      1605,   863));
        libros.add(new Libro("1984",                                "George Orwell",            1949,   328));
        libros.add(new Libro("El amor en los tiempos del cólera",   "Gabriel García Márquez",   1985,   348));
        libros.add(new Libro("La sombra del viento",                "Carlos Ruiz Zafón",        2001,   576));
        libros.add(new Libro("Rayuela",                             "Julio Cortázar",           1963,   635));
        libros.add(new Libro("Crimen y castigo",                    "Fiódor Dostoyevski",       1866,   671));
        libros.add(new Libro("El principito",                       "Antoine de Saint-Exupéry", 1943,   96));
        libros.add(new Libro("La casa de los espíritus",            "Isabel Allende",           1982,   433));
        libros.add(new Libro("El túnel",                            "Ernesto Sabato",           1948,   142));
        
        try{
            // Escribimos la lista (Libros) de objetos (libros) en un archivo ".json".
            mapeador.writeValue(new File(fileName), libros);
            
            // Muestreo del resultado final.
            System.out.println("\n\n\tEl archivo de extensión \".json\" ha sido creado correctamente.");
        } catch (IOException ioex){
            JOptionPane.showMessageDialog(null, "Error inesperado durante la creación del archivo \".json\": " + ioex.getMessage(), "Error de creación", JOptionPane.ERROR_MESSAGE);
            ioex.printStackTrace();
        }
        
        // Variable donde se guardará la lista leída del JSON
        List<Libro> librosLeidos = null;
        
        try{
            // Muestreo del resultado final.
            System.out.println("\n\n\tAccediendo al archivo de extensión \".json\" recientemente creado...");
            
            // Leemos el archivo ".json" recién creado.
            librosLeidos = mapeador.readValue(new File(fileName), new TypeReference<List<Libro>>() {});
        } catch (IOException ioex){
            JOptionPane.showMessageDialog(null, "Error inesperado durante la lectura del archivo \".json\" recientemente creado: " + ioex.getMessage(), "Error de lectura", JOptionPane.ERROR_MESSAGE);
            ioex.printStackTrace();
        }
        
        if (librosLeidos == null){
            System.out.println("\n\n\tLa lista está vacía.");
            return;
        }
        
        // Declara las variables que haran las funciones de contador.
        int totalLibros = librosLeidos.size();
        double mediaAñoPublicacion = 0;
        double mediaNumeroPaginas = 0;
        
        // Recorre la lista y muestra cada libro leído.
        for (Libro librosLeido : librosLeidos){
            System.out.println(librosLeido);
            mediaAñoPublicacion += librosLeido.getAPublicacion();
            mediaNumeroPaginas += librosLeido.getNPaginas();
        }
        
        // Muestreo del resultado final.
        System.out.println("\n\n==============================================================================================================");
        System.out.print("\tEl número total de libros registrados en la lista es de: " + totalLibros);
        System.out.printf("\n\tLa edad (año de publicación) media total de entre todos los libros registrados en la lista es de: %2.2f años", ((double)mediaAñoPublicacion / totalLibros));
        System.out.printf("\n\tEl número de páginas de media total de entre todos los libros registrados en la lista es de: %2.2f páginas\n", ((double)mediaNumeroPaginas / totalLibros));
        System.out.print("==============================================================================================================");
    }
}