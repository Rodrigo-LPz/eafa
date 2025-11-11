package com.mycompany.apartado3;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AlumnoXML {
    
    private static final String FICHERO_XML = "C:\\Users\\Alumno\\Documents\\ACCESO A DATOS\\lista_alumnos.xml";

    public static void main(String[] args) {
        
        List<Alumno> listaAlumnos = new ArrayList<>();
        listaAlumnos.add(new Alumno("Luis García", 20, 1.75));
        listaAlumnos.add(new Alumno("Ana Martínez", 22, 1.68));
        listaAlumnos.add(new Alumno("Javier Ruiz", 19, 1.82));
        listaAlumnos.add(new Alumno("Sofía Pérez", 21, 1.65));
        
        ListaAlumnos listaContenedora = new ListaAlumnos(listaAlumnos);

        try {
            JAXBContext ctx = JAXBContext.newInstance(ListaAlumnos.class);
            Marshaller m = ctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            m.marshal(listaContenedora, new File(FICHERO_XML));
            System.out.println("Lista de alumnos almacenada en: " + FICHERO_XML);
            
            Unmarshaller um = ctx.createUnmarshaller();
            ListaAlumnos listaLeida = (ListaAlumnos) um.unmarshal(new File(FICHERO_XML));
            
            mostrarInformacion(listaLeida.getAlumnos());

        } catch (JAXBException ex) {
            System.err.println("Error JAXB: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private static void mostrarInformacion(List<Alumno> alumnos) {
        if (alumnos == null || alumnos.isEmpty()) {
            System.out.println("La lista de alumnos está vacía.");
            return;
        }

        System.out.println("\n--- Lista de Alumnos Leída del XML ---");
        
        int totalAlumnos = 0;
        int totalAge = 0;
        double totalHeigth = 0;

        for (Alumno a : alumnos) {
            System.out.println(a);
            totalAlumnos++;
            totalAge += a.getEdad();
            totalHeigth += a.getAltura();
        }

        double mediaEdad = (double) totalAge / totalAlumnos;
        double mediaAltura = totalHeigth / totalAlumnos;
        
        System.out.println("\n--- Estadísticas ---");
        System.out.println("Número de alumnos: " + totalAlumnos);
        System.out.printf("Edad Media: %.2f años.\n", mediaEdad);
        System.out.printf("Altura Media: %.2f metros.\n", mediaAltura);
    }
}