/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.herenciapersona;

/**
 *
 * @author k31
 */
public class Estudiante extends Persona {
    private int numBoleta;

    public Estudiante() {
        super();
    }

    public Estudiante(int numBoleta, String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String correo) {
        super(nombre, apellidoPaterno, apellidoMaterno, edad, correo);
        this.numBoleta = numBoleta;
    }

    public int getNumBoleta() { return numBoleta; }
    public void setNumBoleta(int numBoleta) { this.numBoleta = numBoleta; }
}
