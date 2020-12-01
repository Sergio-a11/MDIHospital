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

    public Vacunacion(String Codigo, String Nombre, String Descripcion) {
        super(Codigo, Nombre, Descripcion);
    }

    public Vacunacion() {
        super();
    }

    
    @Override
    public String tiposervicio() {
        return  "Vacunacion";  
    }
    
}
