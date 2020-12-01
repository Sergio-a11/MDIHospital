/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author dadxc
 */
public class Laboratorios extends Servicio{
    private ArrayList<Examen> examenes;

    public Laboratorios(ArrayList<Examen> examenes, String Codigo, String Nombre, String Descripcion) {
        super(Codigo, Nombre, Descripcion);
        this.examenes = examenes;
    }

    public Laboratorios() {
        super();
        this.examenes = new ArrayList<Examen>();
    }
    
    public double valorExamen(int i){
       return this.examenes.get(i).getValor();
    }
    
    @Override
    public String tiposervicio() {
        return "Laboratorio";
    }
    
}
