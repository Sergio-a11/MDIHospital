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
public abstract class Paciente {
    protected String identificacion,nombre,direccion,telefono;

    public Paciente(String identificacion, String nombre, String direccion, String telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    public Paciente() {
        this.identificacion = "";
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Paciente" + "\nidentificacion:" + identificacion + "\nnombre:" + nombre + "\ndireccion:" + direccion + "\ntelefono:" + telefono;
    }
    
    public abstract char afiliacion();
}
