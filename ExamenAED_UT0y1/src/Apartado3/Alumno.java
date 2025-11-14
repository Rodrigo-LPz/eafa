/**
 *
 * @author Rodrigo
 */
package Apartado3;


// Crea la clase "Alumno".
public class Alumno{
    // ==================== ATRIBUTOS ====================
        // Declara las variables, atributos.
    private String nombre;
    private int edad;
    private double altura;
    
    // ==================== CONSTRUCTORES ====================
        // Crea el constructor vacío del método (obligatorio para librerías como Gson).
    public Alumno(){}
    
        // Crea el constructor con las variables de la clase pasadas como parámetros.
    public Alumno(String nombre, int edad, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }
    
    // ==================== GETTERS ====================
        // Crea los métodos "get".
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public double getAltura() { return altura; }
    
    // ==================== SETTERS ====================
        // Crea los métodos "set".
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setAltura(double altura) { this.altura = altura; }
    
    // ==================== TOSTRING ====================
        // Crea el método "toString".
    @Override
    public String toString(){
        return "\n\n\tAlumno{"
             + "\n\t\tnombre: " + nombre + "."
             + "\n\t\tedad: " + edad + " a?os."
             + "\n\t\taltura: " + altura + " m."
             + "\n\t" + '}';
    }
}