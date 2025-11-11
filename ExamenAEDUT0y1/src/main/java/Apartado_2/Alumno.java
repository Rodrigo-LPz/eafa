/**
 *
 * @author Rodrigo
 */
package Apartado_2;


// Crea la clase "Alumno".
public class Alumno{
  // Declara las variables privadas del método.
    private String nombre;
    private int edad;
    private double altura;

    // Crea el constructor del método.
    public Alumno(){

    }

    // Crea las funciones "get".
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public double getAltura() { return altura; }

    // Crea las funciones "set".
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setAltura(double altura) { this.altura = altura; }

    // Crea la función "toString".
    @Override
    public String toString(){
        return "Alumno{" +
                    "\n\tnombre: " + nombre + "." + 
                    "\n\tedad: " + edad + " años." +
                    "\n\taltura: " + altura + " m.\n" +
               '}';
    }  
}