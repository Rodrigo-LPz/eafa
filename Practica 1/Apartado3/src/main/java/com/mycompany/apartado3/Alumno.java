package com.mycompany.apartado3;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement (name="Alumno")
@XmlType(propOrder = {"nombre", "edad", "altura"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Alumno {
 
  public Alumno() {
  }
  
  @XmlAttribute(name = "Alumno", required = true)
  private String Alumno;
  
  @XmlElement(name = "nombre")
  private String nombre;
  
  @XmlElement(name = "edad")
  private int edad;
  
  @XmlElement(name = "altura")
  private double altura;

  public Alumno(String Alumno, int edad, double altura) {
    this.Alumno = Alumno;
    this.nombre = nombre;
    this.edad = edad;
    this.altura = altura;
  }

  public String getAlumno() {
    return Alumno;
  }

  public void setAlumno(String Alumno) {
    this.Alumno = Alumno;
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
    return "Alumno{" + "Alumno=" + Alumno + ", nombre=" + nombre + ", edad=" + edad + ", altura=" + altura + '}';
  }
  
}
