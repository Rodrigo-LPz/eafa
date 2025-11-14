/**
 *
 * @author Rodrigo
 */
package Apartado3;


// Crea la clase "Libro".
public class Libro{
    // Atributos/Variables
    private String titulo;
    private String autor;
    private int aPublicacion;
    private int nPaginas;
    
    // Contructor vacío.
    public Libro(){}
    
    // Constructor que recibe como parámetros a los atributos/variables.
    public Libro(String titulo, String autor, int aPublicacion, int nPaginas){
        this.titulo = titulo;
        this.autor = autor;
        this.aPublicacion = aPublicacion;
        this.nPaginas = nPaginas;
    }
    
    // Método get.
    public String getTitulo(){ return titulo; }
    public String getAutor(){ return autor; }
    public int getAPublicacion(){ return aPublicacion; }
    public int getNPaginas(){ return nPaginas; }
    
    // Método set.
    public void setTitulo(String titulo){ this.titulo = titulo; }
    public void setAutor(String autor){ this.autor = autor; }
    public void setAPublicacion(int aPublicacion){ this.aPublicacion = aPublicacion; }
    public void setNPaginas(int nPaginas){ this.nPaginas = nPaginas; }

    @Override
    public String toString(){
        return "\n\n\tLibro{"
             + "\n\t\tTitulo: " + titulo
             + "\n\t\tAutor: " + autor
             + "\n\t\tAño de Publicación: " + aPublicacion
             + "\n\t\tNúmero de Paginas: " + nPaginas
             + "\n\t" + '}';
    }
}