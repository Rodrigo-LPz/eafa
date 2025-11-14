/**
 *
 * @author Rodrigo
 */
package Apartado2;


// Importa de internet el paquete "BufferedReader".
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

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

// Crea la clase principal/'main' del programa.
public class Main{
    //
    public static void main(String[] args){
        // Declara una variable de tipo cadena para definir la ruta del archivo.
        String fileName = "C:\\Users\\Alumno\\Documents\\ExamenRecuperaciónAED_UT0y1\\ExamenRecuperacionAED_UT1\\src\\main\\java\\Apartado2\\Biblioteca.xml";

        // Crea el mapeador.
        XmlMapper xmlMapper = new XmlMapper();

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
        
                
        // Contenedor requerido para XML. Envuelve la lista en una clase contenedor.
        ListaLibros lista = new ListaLibros(libros);
        
        try{
            // Escribimos la lista (Libros) de objetos (libros) en un archivo ".xml".
            xmlMapper.writeValue(new File(fileName), lista);
            
            // Muestreo del resultado final.
            System.out.println("\n\n\tEl archivo de extensión \".xml\" ha sido creado correctamente.");
        } catch (IOException ioex){
            JOptionPane.showMessageDialog(null, "Error inesperado durante la creación del archivo \".xml\": " + ioex.getMessage(), "Error de creación", JOptionPane.ERROR_MESSAGE);
            ioex.printStackTrace();
        }
        
        // Objeto donde guardar lo leído de la lista.
        ListaLibros listaLeida = null;
        
        try{
            // Muestreo del resultado final.
            System.out.println("\n\n\tAccediendo al archivo de extensión \".xml\" recientemente creado...");
            
            // Leemos el archivo ".xml" recién creado.
            listaLeida = xmlMapper.readValue(new File(fileName), ListaLibros.class);
        } catch (IOException ioex){
            JOptionPane.showMessageDialog(null, "Error inesperado durante la lectura del archivo \".xml\" recientemente creado: " + ioex.getMessage(), "Error de lectura", JOptionPane.ERROR_MESSAGE);
            ioex.printStackTrace();
        }
        
        if (listaLeida == null){
            System.out.println("\n\n\tLa lista está vacía.");
            return;
        }
        
        // Declara las variables que haran las funciones de contador.
        int totalLibros = listaLeida.getLibros().size();
        double mediaAñoPublicacion = 0;
        double mediaNumeroPaginas = 0;
        
        // Recorre la lista y muestra cada libro leído.
        for (Libro libroLeido : listaLeida.getLibros()){
            System.out.println(libroLeido);
            mediaAñoPublicacion += libroLeido.getAPublicacion();
            mediaNumeroPaginas += libroLeido.getNPaginas();
        }
        
        // Muestreo del resultado final.
        System.out.println("\n\n==============================================================================================================");
        System.out.print("\tEl número total de libros registrados en la lista es de: " + totalLibros);
        System.out.printf("\n\tLa edad (año de publicación) media total de entre todos los libros registrados en la lista es de: %2.2f años", ((double)mediaAñoPublicacion / totalLibros));
        System.out.printf("\n\tEl número de páginas de media total de entre todos los libros registrados en la lista es de: %2.2f páginas\n", ((double)mediaNumeroPaginas / totalLibros));
        System.out.print("==============================================================================================================");
    }
}