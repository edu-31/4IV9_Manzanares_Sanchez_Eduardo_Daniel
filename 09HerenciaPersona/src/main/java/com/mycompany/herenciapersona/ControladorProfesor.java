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

public class ControladorProfesor {

    public static ArrayList<Profesor> listadeProfesores = new ArrayList<Profesor>();
    private static final String ARCHIVO = "profesores.txt";

    public ArrayList<Profesor> mostrarProfesores() {
        return listadeProfesores;
    }

    public void registrarProfesor(Profesor p) {
        listadeProfesores.add(p);
        escribirArchivo();
    }

    public Profesor buscarProfesor(int numEmp) {
        Profesor encontrada = new Profesor();
        for(Profesor p : listadeProfesores) {
            if(numEmp == p.getNumEmpleado()) {
                encontrada = p;
            }
        }
        return encontrada;
    }

    public void actualizarProfesor(Profesor profesorActualizado) {
        Profesor profesorActualizar = buscarProfesor(profesorActualizado.getNumEmpleado());
        listadeProfesores.remove(profesorActualizar);
        listadeProfesores.add(profesorActualizado);
        escribirArchivo();
    }

    public void eliminarProfesor(Profesor profesorEliminar) {
        listadeProfesores.remove(profesorEliminar);
        escribirArchivo();
    }

    public void escribirArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Profesor p : listadeProfesores) {
                writer.write("numEmpleado=" + p.getNumEmpleado()); writer.newLine();
                writer.write("materia=" + p.getMateria()); writer.newLine();
                writer.write("nombre=" + p.getNombre()); writer.newLine();
                writer.write("apellidoPaterno=" + p.getApellidoPaterno()); writer.newLine();
                writer.write("apellidoMaterno=" + p.getApellidoMaterno()); writer.newLine();
                writer.write("edad=" + p.getEdad()); writer.newLine();
                writer.write("correo=" + p.getCorreo()); writer.newLine();
                writer.write("===================="); writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public void leerArchivo() {
        File file = new File(ARCHIVO);
        if (!file.exists()) return;

        listadeProfesores.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linea;
            Profesor p = new Profesor();
            while ((linea = reader.readLine()) != null) {
                if (linea.equals("====================")) {
                    listadeProfesores.add(p);
                    p = new Profesor();
                    continue;
                }
                String[] partes = linea.split("=", 2);
                if (partes.length < 2) continue;
                String clave = partes[0];
                String valor = partes[1];
                
                switch (clave) {
                    case "numEmpleado":     p.setNumEmpleado(Integer.parseInt(valor)); break;
                    case "materia":         p.setMateria(valor); break;
                    case "nombre":          p.setNombre(valor); break;
                    case "apellidoPaterno": p.setApellidoPaterno(valor); break;
                    case "apellidoMaterno": p.setApellidoMaterno(valor); break;
                    case "edad":            p.setEdad(Integer.parseInt(valor)); break;
                    case "correo":          p.setCorreo(valor); break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
