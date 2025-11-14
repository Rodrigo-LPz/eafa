/**
 *
 * @author Rodrigo
 */
package Apartado2;


// Importa de internet el paquete "List".
import java.util.List;

// Crea la clase "ListaLibros".
public class ListaLibros{
    // ==================== ATRIBUTOS ====================
        // Crea una lista "libros" privada conectada a "Libro.java".
    private List<Libro> libros;
    
    // ==================== CONSTRUCTORES ====================
        // Crea el constructor vacío del método (obligatorio para librerías como Gson).
    public ListaLibros() {}
    
        // Crea el constructor con la lista "libros" pasada como parámetro.
    public ListaLibros(List<Libro> libros){ this.libros = libros; }
    
    // ==================== GETTERS ====================
        // Crea los métodos "get".
    public List<Libro> getLibros(){ return libros; }
    
    // ==================== SETTERS ====================
        // Crea los métodos "set".
    public void setLibros(List<Libro> libros){ this.libros = libros; }
}