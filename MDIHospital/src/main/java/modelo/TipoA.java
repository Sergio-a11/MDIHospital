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
public class TipoA extends Paciente{

    /**
     *Constructor Parametrico
     * @param identificacion identificacion del paciente tipo A
     * @param nombre nombre del paciente tipo A
     * @param direccion direccion del paciente tipo A
     * @param telefono telefono del paciente tipo A
     */
    public TipoA(String identificacion, String nombre, String direccion, String telefono) {
        super(identificacion, nombre, direccion, telefono);
    }

    /**
     *Constructor basico
     */
    public TipoA() {
        super();
    }

    /**
     *
     * @return String
     */
    @Override
    public char afiliacion() {
        return 'A';
    }
    
}
