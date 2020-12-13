/*
 * con esta clase recolectaremos cada uno de los historiales clinicos con sus clientes y servicios
 * a su vez esta clase nos permitira saber el total recaudado por el hospital en servicios 
 * ArrayList todo esto con el uso de un 
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author dadxc
 */
public class Registros {
    private ArrayList<HistoriaClinica> listaH;

    /**
     *constructor parametrico
     * @param listaH lista de historiales clinicos 
     */
    public Registros(ArrayList<HistoriaClinica> listaH) {
        this.listaH = listaH;
    }
    
    /**
     *constructor basico
     */
    public Registros() {
        this.listaH = new ArrayList<HistoriaClinica>();
    }

    /**
     *retorna la lista de historiales clinicos 
     * @return ArrayList lista de historiales clinicos
     */
    public ArrayList<HistoriaClinica> getListaH() {
        return listaH;
    }

    /**
     *establece o modifica el arreglo de historiales clinicos
     * @param listaH lista de historiales clinicos
     */
    public void setListaH(ArrayList<HistoriaClinica> listaH) {
        this.listaH = listaH;
    }

    /**
     *
     * @return Stirng
     */
    @Override
    public String toString() {
        String msj = "";
        for (int i = 0; i < listaH.size(); i++) {
            msj+=listaH.get(i).toString();
        }
        return msj;
    }
    
    /**
     *nos regresa el recaudo total del hospital 
     * @return double
     */
    public double recaudoTotal(){
        double sum=0;
        for (int i = 0; i < listaH.size(); i++) {
            if(listaH.get(i).getDtsServicio() instanceof CitaMedGenr || listaH.get(i).getDtsServicio() instanceof Vacunacion){
              sum+=listaH.get(i).valor();  
            }else if(listaH.get(i).getDtsServicio() instanceof Laboratorios){
              sum+=listaH.get(i).valorLAB((Laboratorios)listaH.get(i).getDtsServicio());
            }else if(listaH.get(i).getDtsServicio() instanceof Hospitalizacion){
              sum+=listaH.get(i).valorHOPS((Hospitalizacion)listaH.get(i).getDtsServicio());
            }
        }
        return sum;
    }

    /**
     *metodo para buscar una historia clinica especifica
     * @param aux string para comparar con los numeros de historiales clinicos y encontrar la que se busca
     * @return String
     */
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
