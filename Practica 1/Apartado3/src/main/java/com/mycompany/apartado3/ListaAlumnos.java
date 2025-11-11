package com.mycompany.apartado3;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "ListaAlumnos")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaAlumnos {

    // JAXB usa esta anotación para saber que tiene que crear muchos elementos <Alumno>
    @XmlElement(name = "Alumno") 
    private List<Alumno> alumnos = new ArrayList<>();

    public ListaAlumnos() {
    }
    
    public ListaAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}