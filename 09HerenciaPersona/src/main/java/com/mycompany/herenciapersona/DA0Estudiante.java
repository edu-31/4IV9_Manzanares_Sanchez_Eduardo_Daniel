/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.herenciapersona;

/**
 *
 * @author k31
 */

import javax.swing.JOptionPane;

public class DA0Estudiante {
    
    // Arreglo para almacenar hasta 10 estudiantes
    Estudiante obj[] = new Estudiante[10];
    int x = 0; // Contador de estudiantes registrados
    
    // Menu principal
    void menu(){
        String var = "si";
        
        while(var.equalsIgnoreCase("si")){
            try {
                int op = Integer.parseInt(JOptionPane.showInputDialog(
                        "=== CRUD de Estudiantes ===\n"
                        + "1.- Registrar Estudiante (Create)\n"
                        + "2.- Mostrar todos los Estudiantes (Read)\n"
                        + "3.- Buscar Estudiante por Boleta (Read/Search)\n"
                        + "4.- Editar Estudiante (Update)\n"
                        + "5.- Eliminar Estudiante (Delete)\n"
                        + "Selecciona una opción:"));
                
                switch (op) {
                    case 1: pedirEstudiante(); break;
                    case 2: mostrarEstudiantes(); break;
                    case 3: 
                        int boletaBuscada = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la boleta a buscar:"));
                        int indice = buscarPorBoleta(boletaBuscada);
                        if(indice != -1) {
                            
                            JOptionPane.showMessageDialog(null, "Estudiante Encontrado:\n" 
                                    + "Nombre: " + obj[indice].getNombre() + "\n"
                                    + "Edad: " + obj[indice].getEdad());
                        } else {
                            JOptionPane.showMessageDialog(null, "Estudiante no registrado.");
                        }
                        break;
                    case 4: editarEstudiante(); break;
                    case 5: eliminarEstudiante(); break;
                    default: JOptionPane.showMessageDialog(null, "Opción no válida");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingresa un número válido.");
            }
            
            var = JOptionPane.showInputDialog("¿Desea regresar al menú principal? (si/no)");
            if (var == null) var = "no";
        }
    }

    // Crear un estudiante
    public void pedirEstudiante() {
        if (x >= obj.length) {
            JOptionPane.showMessageDialog(null, "El arreglo está lleno. No se pueden registrar más estudiantes.");
            return;
        }
        
        int numboleta = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la boleta:"));
        
        // Evitar boletas duplicadas
        if(buscarPorBoleta(numboleta) != -1) {
            JOptionPane.showMessageDialog(null, "Error: Esa boleta ya existe.");
            return;
        }
        
        String nom = JOptionPane.showInputDialog("Ingresa el nombre:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la edad:"));
        
        String genInput = JOptionPane.showInputDialog("Ingresa el género (M/F):");
        char gen = (genInput != null && !genInput.isEmpty()) ? genInput.charAt(0) : 'U';
        
        // Se crea el objeto y se guarda
        obj[x] = new Estudiante(numboleta, nom, edad, gen);
        x++;
        JOptionPane.showMessageDialog(null, "Estudiante registrado con éxito.");
    }

    // Mostrar estudiantes
    public void mostrarEstudiantes() {
        if (x == 0) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados.");
            return;
        }
        
        String lista = "=== Lista de Estudiantes ===\n";
        for(int i = 0; i < x; i++){
            // Usar getters para recuperar la información de cada objeto
            lista += "Boleta: " + obj[i].getNumBoleta() 
                    + " | Nombre: " + obj[i].getNombre() 
                    + " | Edad: " + obj[i].getEdad() 
                    + " | Género: " + obj[i].getGenero() + "\n";
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    // Buscar un estudiante
    public int buscarPorBoleta(int boleta) {
        for (int i = 0; i < x; i++) {
            // GET para comparar la boleta solicitada con la del objeto guardado
            if (obj[i].getNumBoleta() == boleta) {
                return i; 
            }
        }
        return -1; // No lo encontró
    }

    // Editar estudiambre
    public void editarEstudiante() {
        int boleta = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la boleta del estudiante a editar:"));
        int indice = buscarPorBoleta(boleta);
        
        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
            return;
        }
        
        
        String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre (Actual: " + obj[indice].getNombre() + "):");
        int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Nueva edad (Actual: " + obj[indice].getEdad() + "):"));
        
        
        obj[indice].setNombre(nuevoNombre);
        obj[indice].setEdad(nuevaEdad);
        
        JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.");
    }

    // Borrar estudiambre
    public void eliminarEstudiante() {
        int boleta = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la boleta del estudiante a eliminar:"));
        int indice = buscarPorBoleta(boleta);
        
        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
            return;
        }
        
        
        for (int i = indice; i < x - 1; i++) {
            obj[i] = obj[i + 1];
        }
        
        obj[x - 1] = null;
        x--;
        
        JOptionPane.showMessageDialog(null, "Estudiante eliminado del sistema.");
    }
}