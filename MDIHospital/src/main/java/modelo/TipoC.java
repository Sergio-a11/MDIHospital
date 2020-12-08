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
public class TipoC extends Paciente{

    /**
     *Constructor parametric
     * @param identificacion Identificacion del paciente tipo C
     * @param nombre nombre del paciente tipo C
     * @param direccion direccion del paciente tipo C
     * @param telefono telefono del paciente tipo C
     */
    public TipoC(String identificacion, String nombre, String direccion, String telefono) {
        super(identificacion, nombre, direccion, telefono);
    }

    /**
     *Constructor Basico
     */
    public TipoC() {
        super();
    }

    /**
     *
     * @return String 
     */
    @Override
    public char afiliacion() {
        return 'C';
    }
    
}
