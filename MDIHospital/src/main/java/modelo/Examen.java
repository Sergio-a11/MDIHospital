/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author dadxc
 */
public class Examen {
    private String Cod, nombre, descripcion;
    private double valor;

    public Examen(String Cod, String nombre, String descripcion, double valor) {
        this.Cod = Cod;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
    }
    
    public Examen() {
        this.Cod = "";
        this.nombre = "";
        this.descripcion = "";
        this.valor = 0;
    }

    public String getCod() {
        return Cod;
    }

    public void setCod(String Cod) {
        this.Cod = Cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "\nExamen" + "\nCod=" + Cod + "\nnombre:" + nombre + "\ndescripcion:" + descripcion + "\nvalor:" + valor;
    }
    
    
}
