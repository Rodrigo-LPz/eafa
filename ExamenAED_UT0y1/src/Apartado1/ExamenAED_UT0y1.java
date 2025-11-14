/**
 *
 * @author Rodrigo
 */
package Apartado1;


// Importa de internet el paquete "BufferedReader".
import java.io.BufferedReader;
// Importa de internet el paquete "FileReader".
import java.io.FileReader;
// Importa de internet el paquete "IOException".
import java.io.IOException;
// Importa de internet el paquete "JOptionPane".
import javax.swing.JOptionPane;

public class ExamenAED_UT0y1{
    public static void main(String[] args){
        // Declara una variable de tipo cadena para definir la ruta del archivo.
        String fileName = "C:\\Users\\rodri\\OneDrive\\Documentos\\NetBeansProjects\\ExamenAED_UT0y1\\Alumnos.txt";
        
        // Declara las variables que haran las funciones de contador.
        int totalAlumnos = 0;
        double mediaEdad = 0;
        double mediaAltura = 0;
        
        //
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            // Salto de línea. Nos saltamos la primera línea del archivo (ya que no tiene datos es introductoria).
            br.readLine();
            
            // Variable que almacenará cada línea leída.
            String line;
            
            System.out.println();
            
            // Lee el archivo línea a línea. Parará cuando la línea leída no le devuelva nada, sea nula ("null").
            while ((line = br.readLine()) != null){
                // Muestreo por pantalla de la línea tal cual está siendo leída del fichero.
                System.out.println("\t" + line);

                // Separa los datos por comas.
                String[] partes = line.split(",");
                
                // Toma el array de cadena "String[] partes" y va separando/procesando cada valor separado por comas (línea de código anterior.
                String nombre = partes[0];
                int edad = Integer.parseInt(partes[1].trim());
                double altura = Double.parseDouble(partes[2].trim());
                
                // Actualiza los contadores.
                totalAlumnos++;
                mediaEdad += edad;
                mediaAltura += altura;
            }
            
            // Muestreo del resultado final.
            System.out.println("\n\n==============================================================================================================");
            System.out.print("\tEl número total de alumnos registrados en la lista es de: " + totalAlumnos);
            System.out.printf("\n\tLa edad media total de entre todos los alumnos registrados en la lista es de: %2.2f a?os", ((double)mediaEdad / totalAlumnos));
            System.out.printf("\n\tLa altura media total de entre todos los alumnos registrados en la lista es de: %2.2fm\n", (mediaAltura / totalAlumnos));
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