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

    /**
     *Constructor parametrico
     * @param Cod codigo del examen
     * @param nombre nombre del examen
     * @param descripcion descripcion del examen
     * @param valor valor del examen
     */
    public Examen(String Cod, String nombre, String descripcion, double valor) {
        this.Cod = Cod;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
    }
    
    /**
     *constructor basico
     */
    public Examen() {
        this.Cod = "";
        this.nombre = "";
        this.descripcion = "";
        this.valor = 0;
    }

    /**
     *retorna el codigo del examen
     * @return String
     */
    public String getCod() {
        return Cod;
    }

    /**
     *establece o modifica el codigo del examen
     * @param Cod codigo del examen
     */
    public void setCod(String Cod) {
        this.Cod = Cod;
    }

    /**
     *retorna el nombre del examen
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *establece o modifica el nombre del examen
     * @param nombre nombre del examen
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *retorna descripcion del examen
     * @return String
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *Establece o modifica descripcion del examen
     * @param descripcion descripcion del examen
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *retorna valor del examen
     * @return Double
     */
    public double getValor() {
        return valor;
    }

    /**
     *establece o modifica valor del examen
     * @param valor valor a pagar por el examen
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return "\nExamen" + "\nCod=" + Cod + "\nnombre:" + nombre + "\ndescripcion:" + descripcion + "\nvalor:" + valor;
    }
    
    
}
