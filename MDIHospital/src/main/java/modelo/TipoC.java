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

    public TipoC(String identificacion, String nombre, String direccion, String telefono) {
        super(identificacion, nombre, direccion, telefono);
    }

    public TipoC() {
        super();
    }

    @Override
    public char afiliacion() {
        return 'C';
    }
    
}
