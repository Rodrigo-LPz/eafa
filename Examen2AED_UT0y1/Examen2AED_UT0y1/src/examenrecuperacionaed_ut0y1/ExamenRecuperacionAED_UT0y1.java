/**
 *
 * @author Rodrigo
 */
package examenrecuperacionaed_ut0y1;


// Importa todos los paquetes de la biblioteca/librería "IOException".
import java.io.IOException;
// Importa todos los paquetes de la biblioteca/librería "file".
import java.nio.file.*;
// Importa todos los paquetes de la biblioteca/librería "BasicFileAttributes".
import java.nio.file.attribute.BasicFileAttributes;
// Importa de la biblioteca/librería el paquete "JOptionPane".
import javax.swing.JOptionPane;

public class ExamenRecuperacionAED_UT0y1{
    public static void main(String[] args){
        // Directorio raíz donde buscar proyectos de NetBeans
        // Declara una variable de tipo cadena para definir la ruta del directorio/carpeta raíz.
        String directorioRaiz = "C:\\Users\\Alumno\\Documents\\ExamenRecuperaciónAED_UT0y1";
        
        System.out.println("\n\n\tBuscando archivos de extensión \".java\" en proyectos de NetBeans...\n");
        
        try{
            // Bloque de código para recorrer los ficheros/archivos "walkFileTree" de la ruta pasada del directorio.
            Files.walkFileTree(Paths.get(directorioRaiz), new SimpleFileVisitor<Path>(){
                // Método "Override" para sobrescribir el método "FileVisitResult".
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs){
                    // Verifica si el directorio es un proyecto de "NetBeans".
                    if (dir.getFileName().toString().equals("src")){
                        Path proyectoDir = dir.getParent();
                        // Si así es el caso se 'adentra' buscando el posible archivo ".java".
                        if (proyectoDir != null){
                            Path nbproject = proyectoDir.resolve(".nbproject");
                            if (Files.isDirectory(nbproject)){
                                // Busca archivos ".java" dentro de la carpeta "src" de "NetBeans".
                                try{
                                    Files.walk(dir)
                                        .filter(path -> path.toString().endsWith(".java")).forEach(System.out::println);
                                } catch (IOException ioex){
                                    // Ignorar errores en este directorio
                                }
                            }
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException ioex){
            JOptionPane.showMessageDialog(null, "Error inesperado durante la lectura del directorio {" + directorioRaiz + "}: " + ioex.getMessage(), "Error de lectura", JOptionPane.ERROR_MESSAGE);
            ioex.printStackTrace();
        }
    }
}