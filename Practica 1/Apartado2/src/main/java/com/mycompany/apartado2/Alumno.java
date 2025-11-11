package com.mycompany.apartado2;

public class Alumno {
  
  private String nombre;
  private int edad;
  private double altura;

  public Alumno() {
  }

  public Alumno(String nombre, int edad, double altura) {
    this.nombre = nombre;
    this.edad = edad;
    this.altura = altura;
  }
  
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public double getAltura() {
    return altura;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  @Override
  public String toString() {
    return "Alumno: " + "nombre= " + nombre + ", edad= " + edad + ", altura= " + altura;
  }
  
}
