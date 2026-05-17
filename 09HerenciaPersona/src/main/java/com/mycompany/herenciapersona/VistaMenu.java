/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.herenciapersona;

/**
 *
 * @author k31
 */
import java.util.ArrayList;
import java.util.Scanner;

public class VistaMenu {
    
    Scanner entrada = new Scanner(System.in);
    ControladorEstudiante crudEst = new ControladorEstudiante();
    ControladorProfesor crudProf = new ControladorProfesor();
    
    public void Principal() {
        
        crudEst.leerArchivo();
        crudProf.leerArchivo();
        
        int opcionGlobal;
        do {
            System.out.println("====== MENU PRINCIPAL ======");
            System.out.println("Elija una opcion:");
            System.out.println("1.- Gestionar Estudiantes");
            System.out.println("2.- Gestionar Profesores");
            System.out.println("3.- Salir");
            opcionGlobal = Integer.parseInt(entrada.nextLine());
            
            switch (opcionGlobal) {
                case 1:
                    menuEstudiantes();
                    break;
                case 2:
                    menuProfesores();
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicacion y guardando datos...");
                    break;
                default:
                    System.out.println("Escoge la opcion correcta");
            }
        } while (opcionGlobal != 3);
    }

    private void menuEstudiantes() {
        int opcion;
        do {
            System.out.println("\n--- GESTIONAR ESTUDIANTES ---");
            System.out.println("1.- Mostrar lista de estudiantes");
            System.out.println("2.- Registrar nuevo estudiante");
            System.out.println("3.- Editar datos de estudiante");
            System.out.println("4.- Borrar estudiante");
            System.out.println("5.- Volver al menú principal");
            opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1:
                    ArrayList<Estudiante> lista = crudEst.mostrarEstudiantes();
                    for(Estudiante objeto : lista) {
                        System.out.println("Boleta: " + objeto.getNumBoleta()
                        + " | Nombre: " + objeto.getNombre() + " " + objeto.getApellidoPaterno()
                        + " | Edad: " + objeto.getEdad() + " | Correo: " + objeto.getCorreo());
                    }
                    break;
                case 2:
                    System.out.println("Ingresa la boleta");
                    int boleta = Integer.parseInt(entrada.nextLine());
                    System.out.println("Ingresa el nombre");
                    String nom = entrada.nextLine();
                    System.out.println("Ingresa apellido paterno");
                    String apPat = entrada.nextLine();
                    System.out.println("Ingresa apellido materno");
                    String apMat = entrada.nextLine();
                    System.out.println("Ingresa la edad");
                    int edad = Integer.parseInt(entrada.nextLine());
                    System.out.println("Ingresa el correo");
                    String correo = entrada.nextLine();

                    Estudiante nuevo = new Estudiante(boleta, nom, apPat, apMat, edad, correo);
                    crudEst.registrarEstudiante(nuevo);
                    System.out.println("Estudiante registrado.");
                    break;
                case 3:
                    System.out.println("Ingresa la boleta, para buscar un estudiante");
                    boleta = Integer.parseInt(entrada.nextLine());
                    Estudiante seleccionado = crudEst.buscarEstudiante(boleta);
                    
                    System.out.println("Informacion actual:\nNombre: " + seleccionado.getNombre() + "\nCorreo: " + seleccionado.getCorreo());
                    System.out.println("Ingresa el nuevo nombre");
                    seleccionado.setNombre(entrada.nextLine());
                    System.out.println("Ingresa el nuevo correo");
                    seleccionado.setCorreo(entrada.nextLine());
                    
                    crudEst.actualizarEstudiante(seleccionado);
                    System.out.println("Estudiante actualizado.");
                    break;
                case 4:
                    System.out.println("Ingresa la boleta para eliminar");
                    int ideliminar = Integer.parseInt(entrada.nextLine());
                    Estudiante eliminar = crudEst.buscarEstudiante(ideliminar);
                    crudEst.eliminarEstudiante(eliminar);
                    System.out.println("Estudiante eliminado.");
                    break;
            }
        } while (opcion != 5);
    }

    private void menuProfesores() {
        int opcion;
        do {
            System.out.println("\n--- GESTIONAR PROFESORES ---");
            System.out.println("1.- Mostrar lista de profesores");
            System.out.println("2.- Registrar nuevo profesor");
            System.out.println("3.- Editar datos de profesor");
            System.out.println("4.- Borrar profesor");
            System.out.println("5.- Volver al menú principal");
            opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1:
                    ArrayList<Profesor> lista = crudProf.mostrarProfesores();
                    for(Profesor objeto : lista) {
                        System.out.println("Emp ID: " + objeto.getNumEmpleado()
                        + " | Nombre: " + objeto.getNombre() + " " + objeto.getApellidoPaterno()
                        + " | Materia: " + objeto.getMateria() + " | Correo: " + objeto.getCorreo());
                    }
                    break;
                case 2:
                    System.out.println("Ingresa numero de empleado");
                    int numEmp = Integer.parseInt(entrada.nextLine());
                    System.out.println("Ingresa la materia");
                    String materia = entrada.nextLine();
                    System.out.println("Ingresa el nombre");
                    String nom = entrada.nextLine();
                    System.out.println("Ingresa apellido paterno");
                    String apPat = entrada.nextLine();
                    System.out.println("Ingresa apellido materno");
                    String apMat = entrada.nextLine();
                    System.out.println("Ingresa la edad");
                    int edad = Integer.parseInt(entrada.nextLine());
                    System.out.println("Ingresa el correo");
                    String correo = entrada.nextLine();

                    Profesor nuevo = new Profesor(numEmp, materia, nom, apPat, apMat, edad, correo);
                    crudProf.registrarProfesor(nuevo);
                    System.out.println("Profesor registrado.");
                    break;
                case 3:
                    System.out.println("Ingresa el ID de empleado para buscar");
                    numEmp = Integer.parseInt(entrada.nextLine());
                    Profesor seleccionado = crudProf.buscarProfesor(numEmp);
                    
                    System.out.println("Informacion actual:\nNombre: " + seleccionado.getNombre() + "\nMateria: " + seleccionado.getMateria());
                    System.out.println("Ingresa el nuevo nombre");
                    seleccionado.setNombre(entrada.nextLine());
                    System.out.println("Ingresa la nueva materia");
                    seleccionado.setMateria(entrada.nextLine());
                    
                    crudProf.actualizarProfesor(seleccionado);
                    System.out.println("Profesor actualizado.");
                    break;
                case 4:
                    System.out.println("Ingresa el ID de empleado para eliminar");
                    int ideliminar = Integer.parseInt(entrada.nextLine());
                    Profesor eliminar = crudProf.buscarProfesor(ideliminar);
                    crudProf.eliminarProfesor(eliminar);
                    System.out.println("Profesor eliminado.");
                    break;
            }
        } while (opcion != 5);
    }
}
