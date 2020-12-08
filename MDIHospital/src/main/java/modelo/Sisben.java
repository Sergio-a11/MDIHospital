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
public class Sisben extends Paciente{

    /**
     *Constructor parametrico
     * @param identificacion identificacion del paciente tipo Sisben
     * @param nombre nombre del paciente tipo Sisben
     * @param direccion direccion del paciente tipo Sisben
     * @param telefono telefono del paciente tipo Sisben
     */
    public Sisben(String identificacion, String nombre, String direccion, String telefono) {
        super(identificacion, nombre, direccion, telefono);
    }

    /**
     *Constructor basico
     */
    public Sisben() {
        super();
    }

    /**
     *
     * @return String
     */
    @Override
    public char afiliacion() {
        return 'S';
    }
    
    
}
