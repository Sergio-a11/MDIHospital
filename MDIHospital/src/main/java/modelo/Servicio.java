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
public abstract class  Servicio {
    protected String Codigo, Nombre, Descripcion;

    public Servicio(String Codigo, String Nombre, String Descripcion) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }
    
    public Servicio() {
        this.Codigo = "";
        this.Nombre = "";
        this.Descripcion = "";
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return "Servicio" + "\nCodigo:" + Codigo + "\nNombre:" + Nombre + "\nDescripcion:" + Descripcion;
    }
    
    public abstract String tiposervicio();
    
}
