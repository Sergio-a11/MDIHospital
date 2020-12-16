/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
     * @throws modelo.FormatoEntradaExcepcion excepción nulo, campo númerico
     */
    public void setIdentificacion(String identificacion) throws FormatoEntradaExcepcion {
        Pattern pat2 = Pattern.compile("[1-9]");
        Matcher mat2 = pat2.matcher(identificacion);
        if(identificacion.equals(""))
        {
            throw new FormatoEntradaExcepcion(101);
        }
        else if(!mat2.find())
        {
            throw new FormatoEntradaExcepcion(103);//solo núemros
        }
        else
        {
            this.identificacion = identificacion;
        }  
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
     * @throws modelo.FormatoEntradaExcepcion nulo o números no valido
     */
    public void setNombre(String nombre) throws FormatoEntradaExcepcion {
        Pattern pat = Pattern.compile("[1-9]");
        Matcher mat = pat.matcher(nombre);
        
        if(nombre.equals(""))
        {
            throw new FormatoEntradaExcepcion(101);
        }
        else if(mat.find())
        {
            throw new FormatoEntradaExcepcion(102);
        }
        else
        {
            this.nombre = nombre;
        }  
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
     * @throws modelo.FormatoEntradaExcepcion excepción nulo
     */
    public void setDireccion(String direccion) throws FormatoEntradaExcepcion {
        if(direccion.equals(""))
        {
            throw new FormatoEntradaExcepcion(101);
        }
        else
        {
            this.direccion = direccion;
        }
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
     * @throws modelo.FormatoEntradaExcepcion el telefono debe tener 7 o 10 numeros
     */
    public void setTelefono(String telefono) throws FormatoEntradaExcepcion {
        Pattern pat = Pattern.compile("\\d{7,10}");
        Matcher mat = pat.matcher(telefono);
        Pattern pat2 = Pattern.compile("[1-9]");
        Matcher mat2 = pat2.matcher(telefono);
        if(telefono.equals(""))
        {
            throw new FormatoEntradaExcepcion(101);
        }
        else if(!mat.find())
        {
            throw new FormatoEntradaExcepcion(105);//tamaño cadena
        }
        else if(!mat2.find())
        {
            throw new FormatoEntradaExcepcion(103);//solo núemros
        }
        else
        {
            this.telefono = telefono;
        }  
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
