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
public class Hospitalizacion extends Servicio{

    private Fecha Ingreso,Salida;

    public Hospitalizacion(Fecha Ingreso, Fecha Salida, String Codigo, String Nombre, String Descripcion) {
        super(Codigo, Nombre, Descripcion);
        this.Ingreso = Ingreso;
        this.Salida = Salida;
    }

    public Hospitalizacion() {
        super();
        this.Ingreso = new Fecha();
        this.Salida = new Fecha();
    }
    
    
    @Override
    public String tiposervicio() {
        return "Hospitalizacion";
    }
    
}
