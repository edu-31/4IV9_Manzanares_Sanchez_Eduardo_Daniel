/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.herenciapersona;

/**
 *
 * @author k31
 */


import java.io.*;
import java.util.ArrayList;

public class ControladorEstudiante {
    
    public static ArrayList<Estudiante> listadeEstudiantes = new ArrayList<Estudiante>();
    private static final String ARCHIVO = "estudiantes.txt";

    public ArrayList<Estudiante> mostrarEstudiantes() {
        return listadeEstudiantes;
    }

    public void registrarEstudiante(Estudiante e) {
        listadeEstudiantes.add(e);
        escribirArchivo();
    }

    public Estudiante buscarEstudiante(int boleta) {
        Estudiante encontrada = new Estudiante();
        for(Estudiante e : listadeEstudiantes) {
            if(boleta == e.getNumBoleta()) {
                encontrada = e;
            }
        }
        return encontrada;
    }

    public void actualizarEstudiante(Estudiante estudianteActualizado) {
        Estudiante estudianteActualizar = buscarEstudiante(estudianteActualizado.getNumBoleta());
        listadeEstudiantes.remove(estudianteActualizar);
        listadeEstudiantes.add(estudianteActualizado);
        escribirArchivo();
    }

    public void eliminarEstudiante(Estudiante estudianteEliminar) {
        listadeEstudiantes.remove(estudianteEliminar);
        escribirArchivo();
    }

    
    public void escribirArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Estudiante e : listadeEstudiantes) {
                writer.write("numBoleta=" + e.getNumBoleta()); writer.newLine();
                writer.write("nombre=" + e.getNombre()); writer.newLine();
                writer.write("apellidoPaterno=" + e.getApellidoPaterno()); writer.newLine();
                writer.write("apellidoMaterno=" + e.getApellidoMaterno()); writer.newLine();
                writer.write("edad=" + e.getEdad()); writer.newLine();
                writer.write("correo=" + e.getCorreo()); writer.newLine();
                writer.write("===================="); writer.newLine(); 
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public void leerArchivo() {
        File file = new File(ARCHIVO);
        if (!file.exists()) return;

        listadeEstudiantes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linea;
            Estudiante e = new Estudiante();
            while ((linea = reader.readLine()) != null) {
                if (linea.equals("====================")) {
                    listadeEstudiantes.add(e);
                    e = new Estudiante();
                    continue;
                }
                String[] partes = linea.split("=", 2);
                if (partes.length < 2) continue;
                String clave = partes[0];
                String valor = partes[1];
                
                switch (clave) {
                    case "numBoleta":        e.setNumBoleta(Integer.parseInt(valor)); break;
                    case "nombre":          e.setNombre(valor); break;
                    case "apellidoPaterno": e.setApellidoPaterno(valor); break;
                    case "apellidoMaterno": e.setApellidoMaterno(valor); break;
                    case "edad":            e.setEdad(Integer.parseInt(valor)); break;
                    case "correo":          e.setCorreo(valor); break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}