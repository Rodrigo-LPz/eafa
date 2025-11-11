/**
 *
 * @author Rodrigo
 */
package Apartado_2;


// Importa de internet el paquete "TypeReference".
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
// Importa de internet el paquete "BufferedReader".
import java.io.BufferedReader;
// Importa de internet el paquete "File".
import java.io.File;
// Importa de internet el paquete "FileInputStream".
import java.io.FileInputStream;
// Importa de internet el paquete "FileNotFoundException".
import java.io.FileNotFoundException;
// Importa de internet el paquete "FileOutputStream".
import java.io.FileOutputStream;
// Importa de internet el paquete "FileReader".
import java.io.FileReader;
// Importa de internet el paquete "IOException".
// Importa de internet el paquete "IOException".
import java.io.IOException;
// Importa de internet el paquete "List".
import java.util.List;

// Crea la clase principal del programa.
public class Apart_1_JSON{
    // Crea el método principal del programa.
    public static void main(String[] args){
        // Declara una variable que recibe la ruta absoluta del archivo.
        String fileName = "C:\\Users\\Alumno\\Documents\\NetBeansProjects\\ExamenAEDUT0y1\\Alumnos.txt";
        
        // Declara una variable para corresponder a una línea en blanco/vacía;
        String line = "";
        
        // Declara una variable numérica que hará la función de contador.
        int contador = 0;
        
        // Declara las variables que haran la función de contador.
        int totalAlumnos = 0;
        int mediaEdad = 0;
        double mediaAltura = 0;
        
        // Bloque "try-with-resources" que crea un objeto "BufferedReader" el cuál leerá y pasará el archivo a un 'buffer', tomado de "FileReader", una clase de Java para leer el contenido de los archivos, en este caso será el archivo correspondiente a la ruta de la variable "fileName".
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){            
            System.out.println("\n\n========================================================================================================================\n");
            
            // Bucle "do-while" para asegurarnos que se ejecuta al menos una vez durante la ejecución del programa. En él incrementamos el valor de la variable "contador" e imprimimos línea por línea siempre y cuando la línea leída por el objeto de "BufferedReader" 'br' no devuelva vacío, "null".
            do { contador ++; System.out.println("\t\t\t" + line); } while ((line = br.readLine()) != null);
            
            System.out.println("\n========================================================================================================================\n\n");
            
            System.out.println("El archivo de texto, '.txt', (\"" + fileName + "\") analizado/leído tiene un total de " + contador + " lineas.");
        } catch (IOException e){}
        
        // Crea un objeto mapeador.
        ObjectMapper mapeador = new ObjectMapper();
        
        // Bloque "try-with-resources" para el apartado de las medias y sumas del total de alumnos..
        try{            
            // Creamos una lista donde ir iterando, añadiendo, objetos (los alumnos).
            List<Apartado_1.Alumno> alumnos;

            // La lista "alumnos" se conecta al mapeador, primero tipamos, capturamos y mantenemos, la información de tipos genéricos durante la propia ejecución. A su vez, con la función "readValue" leemos el valor que obtenemos de "new File" tras recibir la ruta del archivo.
            alumnos = mapeador.readValue(new File(fileName), new TypeReference<List<Apartado_1.Alumno>>() {});
            
            // Bucle "for" con el que recorrer la lista e ir incrementado los valores de las variables declaradas anteriormente.
            for (Apartado_1.Alumno alumno : alumnos){
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
    
    int byteData;
    int contador = 0;
    
    // Crea un bloque "try-with-resources" para la lectura y paso a un archivo ".json".
    try (FileInputStream fis = new FileInputStream("C:\\Users\\Alumno\\Documents\\NetBeansProjects\\ExamenAEDUT0y1\\Alumnos.txt"); FileOutputStream fos = new FileOutputStream("C:\\Users\\Alumno\\Documents\\NetBeansProjects\\ExamenAEDUT0y1\\Alumnos.json")){
        // Comienza leyendo el primer byte del archivo de entrada.
        byteData = fis.read();
    
        // Crea un bucle de tipo "while", para que mientras no se llegue al final del archivo (-1 indica EOF) se sigue leyendo.
        while (byteData != -1){
            // Aumenta el valor del contador por cada byte leído.
            contador ++;

            // Escribe en el archivo de salida el byte leído del archivo de entrada.
            fos.write(byteData);
            // Lee el siguiente byte.
            byteData = fis.read();
        }
    } catch (FileNotFoundException e){
        System.err.println("\nError. El archivo solicitado no se encuentra o no lo reconoce el sistema.");
    } catch (IOException ioe){
        System.err.println("\nError. Fallo de entrada/salida de datos.");
    }
}