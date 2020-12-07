/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Clase de la entidad Cita Medicina General
 * @author dadxc
 */
public class CitaMedGenr extends Servicio{

    /**
     * Constructor Paramétrico, llama al contructor padre
     * @param Codigo codigo de servicio, derivado del padre (Servivio)
     * @param Nombre nombre de servicio, derivado del padre (Servivio)
     * @param Descripcion descripción de servicio, derivado del padre (Servivio)
     */
    public CitaMedGenr(String Codigo, String Nombre, String Descripcion) {
        super(Codigo, Nombre, Descripcion);
    }

    /**
     * Construcor básico, llama al constructor padre
     */
    public CitaMedGenr() {
        super();
    }

    /**
     * Método que describe el tipo del servicio especifico dentro de un servicio a un cliente
     * @return String
     */
    @Override
    public String tiposervicio() {
        return "Cita Medicina General";
    }

    
    
}
