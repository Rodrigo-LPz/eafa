/**
 *
 * @author Rodrigo
 */
package Apartado_1;


// Importa de internet el paquete "TypeReference".
import com.fasterxml.jackson.core.type.TypeReference;
// Importa de internet el paquete "ObjectMapper".
import com.fasterxml.jackson.databind.ObjectMapper;
// Importa de internet el paquete "File".
import java.io.File;
// Importa de internet el paquete "IOException".
import java.io.IOException;
// Importa de internet el paquete "List".
import java.util.List;

// Crea la clase principal del programa.
public class Main{
    public static void main(String[] args){
        // Crea un objeto mapeador.
        ObjectMapper mapeador = new ObjectMapper();

        // Declara una variable de tipo dacena para definir la ruta del archivo.
        String fileName = "C:\\Users\\Alumno\\Documents\\NetBeansProjects\\ExamenAEDUT0y1\\Alumnos.txt";
        
        // Declara una variable para corresponder a una línea en blanco/vacía;
        String line = "";
        
        // Declara las variables que haran la función de contador.
        int totalAlumnos = 0;
        int mediaEdad = 0;
        double mediaAltura = 0;
        
        try{            
            // Creamos una lista donde ir iterando, añadiendo, objetos (los alumnos).
            List<Alumno> alumnos;

            // La lista "alumnos" se conecta al mapeador, primero tipamos, capturamos y mantenemos, la información de tipos genéricos durante la propia ejecución. A su vez, con la función "readValue" leemos el valor que obtenemos de "new File" tras recibir la ruta del archivo.
            alumnos = mapeador.readValue(new File(fileName), new TypeReference<List<Alumno>>() {});
            
            // Bucle "for" con el que recorrer la lista e ir incrementado los valores de las variables declaradas anteriormente.
            for (Alumno alumno : alumnos){
                totalAlumnos ++;
                mediaEdad += alumno.getEdad();
                mediaAltura += alumno.getAltura();
                System.out.println(alumno);
            }
                        
            // Muestreo del resultado final.
            System.out.println("==============================================================================================================\n");
            System.out.print("\n\tEl número total de jugadores registrados en la lista es de: " + totalAlumnos);
            System.out.printf("\n\tLa edad media total de entre todos los jugadores registrados en la lista es de: %2.2f años", ((double)mediaEdad / totalAlumnos));
            System.out.printf("\n\tLa altura media total de entre todos los jugadores registrados en la lista es de: %2.2fm\n\n", (mediaAltura / totalAlumnos));
            System.out.println("\n==============================================================================================================");
        } catch (IOException ioe) { ioe.printStackTrace(); }
    }
}