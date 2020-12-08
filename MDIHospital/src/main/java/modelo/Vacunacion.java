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
public class Vacunacion extends Servicio{

    /**
     *Constructor parametrico
     * @param Codigo Codigo de la vacunacion
     * @param Nombre Nombre de la vacunacion
     * @param Descripcion Descripcion de la vacunacion
     */
    public Vacunacion(String Codigo, String Nombre, String Descripcion) {
        super(Codigo, Nombre, Descripcion);
    }

    /**
     *Constructor Basico
     */
    public Vacunacion() {
        super();
    }

    /**
     *
     * @return String
     */
    @Override
    public String tiposervicio() {
        return  "Vacunacion";  
    }
    
}
