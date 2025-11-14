/**
 *
 * @author Rodrigo
 */
package Apartado1;


// Importa de la biblioteca/librería el paquete "BufferedReader".
import java.io.BufferedReader;
// Importa de la biblioteca/librería el paquete "FileReader".
import java.io.FileReader;
// Importa de la biblioteca/librería el paquete "IOException".
import java.io.IOException;
// Importa de la biblioteca/librería el paquete "JOptionPane".
import javax.swing.JOptionPane;

// Crea la clase principal/'main' del programa.
public class Main{
    //
    public static void main(String[] args){
        // Declara una variable de tipo cadena para definir la ruta del archivo.
        String fileName = "C:\\Users\\Alumno\\Documents\\ExamenRecuperaciónAED_UT0y1\\ExamenRecuperacionAED_UT0\\src\\Apartado1\\Biblioteca.txt";
        
        // Declara las variables que haran las funciones de contador.
        int totalLibros = 0;
        double mediaAñoPublicacion = 0;
        double mediaNumeroPaginas = 0;
        
        // Bloque que recibe la ruta del archivo, ésta es recibida por "FileReader", el cuál leerá línea a línea el archivo. Y, a su vez "BufferedReader" recibirá a éste creando un "buffer", una zona aislada donde leer lo que le pase "FileReader".
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            // Salto de línea. Nos saltamos la primera línea del archivo (ya que no tiene datos es introductoria).
            br.readLine();
            
            // Variable que almacenará cada línea leída.
            String line;
            
            //Salto de línea.
            System.out.println();
            
            // Lee el archivo línea a línea. Parará cuando la línea leída no le devuelva nada, sea nula ("null").
            while ((line = br.readLine()) != null){
                // Muestreo por pantalla de la línea tal cual está siendo leída del fichero.
                System.out.println("\t" + line);

                // Separa los datos por comas.
                String[] partes = line.split(",");
                
                // Toma el array de cadena "String[] partes" y va separando/procesando cada valor separado por comas (línea de código anterior).
                String titulo = partes[0];
                String autor = partes[1];
                int APublicacion = Integer.parseInt(partes[2].trim());
                int NPaginas = Integer.parseInt(partes[3].trim());
                
                // Actualiza los contadores.
                totalLibros++;
                mediaAñoPublicacion += APublicacion;
                mediaNumeroPaginas += NPaginas;
            }
            
            // Muestreo del resultado final.
            System.out.println("\n\n==============================================================================================================");
            System.out.print("\tEl número total de libros registrados en la lista es de: " + totalLibros);
            System.out.printf("\n\tLa edad (año de publicación) media total de entre todos los libros registrados en la lista es de: %2.2f años", ((double)mediaAñoPublicacion / totalLibros));
            System.out.printf("\n\tEl número de páginas de media total de entre todos los libros registrados en la lista es de: %2.2f páginas\n", ((double)mediaNumeroPaginas / totalLibros));
            System.out.print("==============================================================================================================");
        } catch (IOException ioex){
            JOptionPane.showMessageDialog(null, "Error inesperado durante la lectura del archivo: " + ioex.getMessage(), "Error de lectura", JOptionPane.ERROR_MESSAGE);
            ioex.printStackTrace();
        } catch (NumberFormatException nfex){
            JOptionPane.showMessageDialog(null, "Error inesperado durante la conversión de datos: " + nfex.getMessage(), "Error de conversión", JOptionPane.ERROR_MESSAGE);
            nfex.printStackTrace();
        }
    }
}