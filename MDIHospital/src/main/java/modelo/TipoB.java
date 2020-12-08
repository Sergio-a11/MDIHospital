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
public class TipoB extends Paciente{

    /**
     *Constructor parametrico
     * @param identificacion identificacion del paciente tipo B
     * @param nombre nombre del paciente tipo B
     * @param direccion direccion del paciente tipo B
     * @param telefono telefono del paciente tipo B
     */
    public TipoB(String identificacion, String nombre, String direccion, String telefono) {
        super(identificacion, nombre, direccion, telefono);
    }

    /**
     *Constructor Basico
     */
    public TipoB() {
        super();
    }

    /**
     *
     * @return String
     */
    @Override
    public char afiliacion() {
        return 'B';
    }
    
}
