/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.herenciapersona;

/**
 *
 * @author k31
 */
public class Profesor extends Persona {
    private int numEmpleado;
    private String materia;

    public Profesor() {
        super();
    }

    public Profesor(int numEmpleado, String materia, String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String correo) {
        super(nombre, apellidoPaterno, apellidoMaterno, edad, correo);
        this.numEmpleado = numEmpleado;
        this.materia = materia;
    }

    public int getNumEmpleado() { return numEmpleado; }
    public void setNumEmpleado(int numEmpleado) { this.numEmpleado = numEmpleado; }

    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }
}