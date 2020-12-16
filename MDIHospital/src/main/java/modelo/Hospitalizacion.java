/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase de la entidad Hospitalización
 * @author dadxc
 */
public class Hospitalizacion extends Servicio{

    private Fecha Ingreso, Salida;

    /**
     * Constructor Paramétrico, llama al contructor padre
     * @param Ingreso fecha de ingreso del paciente
     * @param Salida fecha de salida del paciente
     * @param Codigo codigo de servicio, derivado del padre (Servivio)
     * @param Nombre nombre de servicio, derivado del padre (Servivio)
     * @param Descripcion descripción de servicio, derivado del padre (Servivio)
     */
    public Hospitalizacion(Fecha Ingreso, Fecha Salida, String Codigo, String Nombre, String Descripcion) {
        super(Codigo, Nombre, Descripcion);
        this.Ingreso = Ingreso;
        this.Salida = Salida;
    }

    /**
     * Construcor básico, llama al constructor padre e inicializa fecha de ingreso y salida
     */
    public Hospitalizacion() {
        super();
        this.Ingreso = new Fecha();
        this.Salida = new Fecha();
    }

    /**
     * Método para obtener la fecha de ingreso como dato Fecha, compuesto de enteros
     * @return Fecha
     */
    public Fecha getIngreso() {
        return Ingreso;
    }

    /**
     * Método para modifica la fecha de ingreso como dato Fecha, compuesto de enteros
     * @param Ingreso fecha de ingreso, tipo Fecha compuesto de enteros
     * @throws modelo.FormatoEntradaExcepcion excepción, nulo, y modelo de fecha
     */
    public void setIngreso(Fecha Ingreso) throws FormatoEntradaExcepcion {
        String fecha = String.valueOf(Ingreso);
        Pattern pat = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}");
        Matcher mat = pat.matcher(fecha);
        
        if(fecha.equals(""))
        {
            throw new FormatoEntradaExcepcion(101);
        }
        else if(!mat.find())
        {
            throw new FormatoEntradaExcepcion(201);
        }
        else
        {
            this.Ingreso = Ingreso;
        }
    }

    /**
     * Método para obtener la fecha de salida como dato Fecha, compuesto de enteros
     * @return Fecha
     */
    public Fecha getSalida() {
        return Salida;
    }

    /**
     * Método para modificar la fecha de salida como dato Fecha, compuesto de enteros
     * @param Salida fecha de salida, tipo Fecha compuesto de enteros
     * @throws modelo.FormatoEntradaExcepcion excepción formato fecha
     */
    public void setSalida(Fecha Salida) throws FormatoEntradaExcepcion {
        String fe = String.valueOf(Salida);
        Pattern pat = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}");
        Matcher mat = pat.matcher(fe);
        
        if(fe.equals(""))
        {
            throw new FormatoEntradaExcepcion(101);
        }
        else if(!mat.find())
        {
            throw new FormatoEntradaExcepcion(201);
        }
        else
        {
            this.Salida = Salida;
        }
        
    }
    
    /**
     * Método que describe el tipo del servicio especifico dentro de un servicio a un cliente
     * @return String
     */
    @Override
    public String tiposervicio() {
        return "Hospitalizacion";
    }
    
}
