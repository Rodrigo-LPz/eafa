/**
 *
 * @author Rodrigo
 */
package Apartado3;


// Importa de internet el paquete "List".
import java.util.List;

// Crea la clase "ListaAlumnos".
public class ListaAlumnos{
    // ==================== ATRIBUTOS ====================
        // Crea una lista "alumnos" privada conectada a "Alumno.java".
    private List<Alumno> alumnos;
    
    // ==================== CONSTRUCTORES ====================
        // Crea el constructor vacío del método (obligatorio para librerías como Gson).
    public ListaAlumnos() {}
    
        // Crea el constructor con la lista "alumnos" pasada como parámetro.
    public ListaAlumnos(List<Alumno> alumnos){ this.alumnos = alumnos; }
    
    // ==================== GETTERS ====================
        // Crea los métodos "get".
    public List<Alumno> getAlumnos(){ return alumnos; }
    
    // ==================== SETTERS ====================
        // Crea los métodos "set".
    public void setAlumnos(List<Alumno> alumnos){ this.alumnos = alumnos; }
}