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
public class Registros {
    private ArrayList<HistoriaClinica> listaH;

    public Registros(ArrayList<HistoriaClinica> listaH) {
        this.listaH = listaH;
    }
    
    public Registros() {
        this.listaH = new ArrayList<HistoriaClinica>();
    }

    public ArrayList<HistoriaClinica> getListaH() {
        return listaH;
    }

    public void setListaH(ArrayList<HistoriaClinica> listaH) {
        this.listaH = listaH;
    }

    @Override
    public String toString() {
        return "Registros{" + "listaH=" + listaH + '}';
    }
    
    public double recaudoTotal(){
        double sum=0;
        for (int i = 0; i < listaH.size(); i++) {
            sum+=listaH.get(i).valor();
        }
        return sum;
    }
    public String buscarHistoria(String aux){
        String msj = "\n";
        for (int i = 0; i < listaH.size(); i++) {
            if(listaH.get(i).getNroHistoria()== aux){
                msj+=listaH.get(i).toString();
            }
        }
        return msj;
    }
}
