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

    /**
     *identificacion del paciente
     */
    protected String identificacion,

    /**
     *nombre del paciente
     */
    nombre,

    /**
     *direccion del paciente
     */
    direccion,

    /**
     *telefono del paciente
     */
    telefono;

    /**
     *Constructor parametrico
     * @param identificacion identificacion del paciente
     * @param nombre nombre del paciente
     * @param direccion direccion del paciente
     * @param telefono telefono del paciente
     */
    public Paciente(String identificacion, String nombre, String direccion, String telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    /**
     *Constructor basico
     */
    public Paciente() {
        this.identificacion = "";
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
    }

    /**
     *Retorna la identificacion del paciente
     * @return String
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     *establece o modifica la identificacion del paciente
     * @param identificacion identificacion del paciente
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     *retorna el nombre del paciente
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *establece o modifica el nombre del paciente
     * @param nombre nombre del paciente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *retorna la direccion del paciente
     * @return String
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *establece o modifica la direccion del paciente
     * @param direccion direccion del paciente
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *Retorna el telefono del paciente
     * @return String
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *establece o modifica el telefono del paciente
     * @param telefono telefono del paciente
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return nombre +";"+identificacion+";"+direccion +";"+telefono;
    }
    
    /**
     *metodo abstracto para identificar el tipo de afiliacion de cada paciente 
     * @return char
     */
    public abstract char afiliacion();
}
