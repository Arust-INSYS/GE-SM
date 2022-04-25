/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Arust
 */
public class Empleado {
    private int id_empleado;
    private String nombre;
    private String apellido;

    public Empleado() {
    }

    public Empleado(int id_persona, String nombre, String apellido) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
}
