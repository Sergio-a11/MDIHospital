/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dadxc
 */
public class HistoriaClinica {
    private String NroHistoria;
    private Fecha fecha;
    private Paciente dtsPaciente;
    private Servicio dtsServicio;

    /**
     *Constructor parametrico
     * @param NroHistoria numero de la historia clinica
     * @param fecha fecha de la historia clinica
     * @param dtsPaciente datos del paciente de la historia clinica
     * @param dtsServicio datos del servicio de la historia clinica
     */
    public HistoriaClinica(String NroHistoria, Fecha fecha, Paciente dtsPaciente, Servicio dtsServicio) {
        this.NroHistoria = NroHistoria;
        this.fecha = fecha;
        this.dtsPaciente = dtsPaciente;
        this.dtsServicio = dtsServicio;
    }
    
    /**
     *Constructor basco
     */
    public HistoriaClinica() {
        this.NroHistoria = "";
        this.fecha = new Fecha();
    }

    /**
     *retonra el numero de la historia clinica
     * @return String
     */
    public String getNroHistoria() {
        return NroHistoria;
    }

    /**
     *Establece o modifica el numero de la historia clinica
     * @param NroHistoria numero de la historia clinica
     * @throws modelo.FormatoEntradaExcepcion excepción nulo
     */
    public void setNroHistoria(String NroHistoria) throws FormatoEntradaExcepcion {
        if(NroHistoria.equals(""))
        {
            throw new FormatoEntradaExcepcion(101);
        }
        else
        {
           this.NroHistoria = NroHistoria; 
        }
    }

    /**
     *retorna la fecha de la historia clinica en un objeto tipo fecha
     * @return Fecha
     */
    public Fecha getFecha() {
        return fecha;
    }

    /**
     *establece o modifica la fecha de la historia clinica
     * @param fecha objeto fecha de la fecha de la historia clinica
     * @throws modelo.FormatoEntradaExcepcion excepción formato fecha
     */
    public void setFecha(Fecha fecha) throws FormatoEntradaExcepcion {
        String fe = String.valueOf(fecha);
        Pattern pat = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}");
        Matcher mat = pat.matcher(fe);
        
        if(fecha.toString().equals(""))
        {
            throw new FormatoEntradaExcepcion(101);
        }
        else if(!mat.find())
        {
            throw new FormatoEntradaExcepcion(201);
        }
        else
        {
            this.fecha = fecha;
        }
    }

    /**
     *retorna los datos del paciente de la historia clinica
     * @return Paciente objeto del paciente de la historia clinica
     */
    public Paciente getDtsPaciente() {
        return dtsPaciente;
    }

    /**
     *establece o modifica el objeto paciente de la historia clinica
     * @param dtsPaciente objeto del paciente de la historia clinica
     */
    public void setDtsPaciente(Paciente dtsPaciente) {
        this.dtsPaciente = dtsPaciente;
    }

    /**
     *retorna el objeto servicio de la historia clinica
     * @return Servicio objeto del servicio de la historia clinica
     */
    public Servicio getDtsServicio() {
        return dtsServicio;
    }

    /**
     *establece o modifica el objeto servicio de la historia clinica
     * @param dtsServicio objeto del servicio de la historia clinica
     */
    public void setDtsServicio(Servicio dtsServicio) {
        this.dtsServicio = dtsServicio;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return "HistoriaClinica" + "\nNumero Historia:" + NroHistoria + "\nfecha:" + fecha.toString() + "\nDatos Paciente=" + dtsPaciente.toString() + "\nDatos Servicio:" + dtsServicio.toString();
    }
    
    /**
     *En caso de que el servicio sea una cita medica general o una vacunacion
     * retorna el valor a pagar por el cliente segun su afiliacion
     * @return Double
     */
    public double valor(){
        
        if(dtsServicio.tiposervicio().equalsIgnoreCase("Cita Medicina General")){
            switch (dtsPaciente.afiliacion()) {
                case 'A':
                    return 5000;
                case 'B':
                    return 10000;
                case 'C':
                    return 15000;
                default:
                    return 0;
            }
        }
        if(dtsServicio.tiposervicio().equalsIgnoreCase("Vacunacion")){
            switch (dtsPaciente.afiliacion()) {
                case 'A':
                    return 5000;
                case 'B':
                    return 10000;
                case 'C':
                    return 20000;
                default:
                    return 0;
            }
        }
        
        
        return 0;
    }
    
    /**
     *retorna el valor a pagar del servicio en caso de que sea de laboratorios
     * basandose en el tipo de afiliacion y los examenes realizados
     * @param lab objeto tipo Laboratorios para saber los examenes
     * @return Double
     */
    public double valorLAB(Laboratorios lab){
        double sum =0;
        if(dtsServicio.tiposervicio().equalsIgnoreCase("Laboratorios")){
            Laboratorios dtsLab = lab;
            switch (dtsPaciente.afiliacion()) {
                case 'A':
                    for (int i = 0; i < dtsLab.getExamenes().size(); i++) {
                        sum+=dtsLab.getExamenes().get(i).getValor()*0.1;
                    }
                break;    
                case 'B':
                    for (int i = 0; i < dtsLab.getExamenes().size(); i++) {
                        sum+=dtsLab.getExamenes().get(i).getValor()*0.5;
                    }
                    break;
                case 'C':
                    for (int i = 0; i < dtsLab.getExamenes().size(); i++) {
                        sum+=dtsLab.getExamenes().get(i).getValor()*1;
                    }
                    break;
                default:
                    return sum; 
            }
        }
        return sum;
    }
    
    /**
     *retorna el valor a pagar del servicio en caso de que sea una hospitalizacion
     * tomando en cuenta el tipo de afiliacion del cliente y los dias de hospitalizacion
     * @param hops objeto de tipo hospitalizacion para saber la cantidad de dias que se quedo
     * @return double
     */
    public double valorHOPS(Hospitalizacion hops){
        long dias1= 0;
        long dias2= 0;
        long aux=0;
        dias1 = (hops.getSalida().getAa()*365)+(hops.getSalida().getMm()*30)+(hops.getSalida().getDd());
        dias2 = (hops.getIngreso().getAa()*365)+(hops.getIngreso().getMm()*30)+(hops.getIngreso().getDd());
        aux = dias1 - dias2;
        if(dtsServicio.tiposervicio().equalsIgnoreCase("Hospitalizacion") && aux>0){
            switch (dtsPaciente.afiliacion()) {
                case 'A':
                    return aux*30000;
                case 'B':
                    return aux*40000;
                case 'C':
                    return aux*70000;
                default:
                    return aux*20000;
            }
        }
        return 0;
    }
}
