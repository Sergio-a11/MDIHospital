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
public class HistoriaClinica {
    private String NroHistoria;
    private Fecha fecha;
    private Paciente dtsPaciente;
    private Servicio dtsServicio;

    public HistoriaClinica(String NroHistoria, Fecha fecha, Paciente dtsPaciente, Servicio dtsServicio) {
        this.NroHistoria = NroHistoria;
        this.fecha = fecha;
        this.dtsPaciente = dtsPaciente;
        this.dtsServicio = dtsServicio;
    }
    
    public HistoriaClinica() {
        this.NroHistoria = "";
        this.fecha = new Fecha();
    }

    public String getNroHistoria() {
        return NroHistoria;
    }

    public void setNroHistoria(String NroHistoria) {
        this.NroHistoria = NroHistoria;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Paciente getDtsPaciente() {
        return dtsPaciente;
    }

    public void setDtsPaciente(Paciente dtsPaciente) {
        this.dtsPaciente = dtsPaciente;
    }

    public Servicio getDtsServicio() {
        return dtsServicio;
    }

    public void setDtsServicio(Servicio dtsServicio) {
        this.dtsServicio = dtsServicio;
    }

    @Override
    public String toString() {
        return "HistoriaClinica" + "\nNumero Historia:" + NroHistoria + "\nfecha:" + fecha.toString() + "\nDatos Paciente=" + dtsPaciente.toString() + "\nDatos Servicio:" + dtsServicio.toString();
    }
    
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
    
    public double valorHOPS(Fecha ingreso, Fecha salida){
        int dias = 0;
        if((((salida.getMm()-ingreso.getMm())*30)-60)> 1){
            dias = (((salida.getMm()-ingreso.getMm())*30)-60)+(salida.getDd()-(30-ingreso.getDd()));
        }else{
            dias = (salida.getDd()-(30-ingreso.getDd()));
        }
        if(dtsServicio.tiposervicio().equalsIgnoreCase("Cita Medicina General")){
            switch (dtsPaciente.afiliacion()) {
                case 'A':
                    return dias*30000;
                case 'B':
                    return dias*40000;
                case 'C':
                    return dias*70000;
                default:
                    return dias*20000;
            }
        }
        return 0;
    }
}
