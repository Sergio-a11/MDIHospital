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
            if(dtsPaciente.afiliacion()=='A'){
                return 5000;
            }else if(dtsPaciente.afiliacion()=='B'){
                return 10000;
            }else if(dtsPaciente.afiliacion()=='C'){
                return 15000;
            }else{
                return 0;
            }
        }
        if(dtsServicio.tiposervicio().equalsIgnoreCase("Vacunacion")){
            if(dtsPaciente.afiliacion()=='A'){
                return 5000;
            }else if(dtsPaciente.afiliacion()=='B'){
                return 10000;
            }else if(dtsPaciente.afiliacion()=='C'){
                return 20000;
            }else{
                return 0;
            }
        }
       /* if(dtsServicio.tiposervicio().equalsIgnoreCase("Laboratorios")){
            Laboratorios dtsLab = new Laboratorios();
            if(dtsPaciente.afiliacion()=='A'){

            }else if(dtsPaciente.afiliacion()=='B'){
                return 10000;
            }else if(dtsPaciente.afiliacion()=='C'){
                return 15000;
            }else{
                return 0;
            }
        }*/
        /*if(dtsServicio.tiposervicio().equalsIgnoreCase("Cita Medicina General")){
            if(dtsPaciente.afiliacion()=='A'){
                return 5000;
            }else if(dtsPaciente.afiliacion()=='B'){
                return 10000;
            }else if(dtsPaciente.afiliacion()=='C'){
                return 15000;
            }else{
                return 0;
            }
        }*/
        return 0;
    }
}
