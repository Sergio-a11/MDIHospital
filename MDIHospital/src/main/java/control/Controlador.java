/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

/**
 * Clase que Controla la logica del progrma y los procesos de la vista desde la interfaz de usuario
 * @author dadxc
 */
public class Controlador implements ActionListener {
    Registros objR;
    VentanaPrincipal frmPrincipal;
    VentanaRegistrar frmRegistrar;
    VentanaExamenes frmExamenes;
    VentanaConsultar frmConsultar;
    ArrayList<Examen> examenes;
    Hospitalizacion auxH;
    Laboratorios auxL;

    /**
     * Controlador básico, inicialización de las ventanas, variables y actionListener
     */
    public Controlador() {
        this.objR = new Registros();
        this.frmPrincipal = new VentanaPrincipal();
        this.frmRegistrar = new VentanaRegistrar();
        this.frmExamenes = new VentanaExamenes();
        this.frmConsultar = new VentanaConsultar();
        frmPrincipal.getPndEscritorio().add(frmRegistrar);
        frmPrincipal.getPndEscritorio().add(frmExamenes);
        frmPrincipal.getPndEscritorio().add(frmConsultar);
        //frmPrincipal.getPndEscritorio().add(frmBuscar);//En desarrollo
        this.frmPrincipal.getOpcmRegistrar().addActionListener(this);
        this.frmPrincipal.getOpcmConsultar().addActionListener(this);
        this.frmPrincipal.getOpcmBuscar().addActionListener(this);
        this.frmPrincipal.getOpcmSalir().addActionListener(this);
        this.frmRegistrar.getBtnFechaSistema().addActionListener(this);//En desarrollo
        this.frmRegistrar.getBtnRegistrar().addActionListener(this);
        this.frmExamenes.getBtnAgregar().addActionListener(this);
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnSangre());
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnOrina());
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnOptometria());
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnOdontologia());
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnCorprologico());
        examenes = new ArrayList<Examen>();
        auxH = new Hospitalizacion();
        auxL = new Laboratorios();
    }
    
    /**
     *  Método que inicia y establece el titulo de la ventana Principal
     */
    public void iniciar(){
        frmPrincipal.setTitle("Hospital");
        frmPrincipal.setVisible(true);
    }

    /**
     * Método para el control de acciones del formulario
     * @param ae actionEventa para detercatr eventos en las vistas
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == frmPrincipal.getOpcmRegistrar()){
            abrirVentana(frmRegistrar);
        }
        if(ae.getSource() == frmPrincipal.getOpcmConsultar()){
            agregarDatos(frmConsultar.getTblConsulta());
            abrirVentana(frmConsultar);
        }
        if(ae.getSource() == frmPrincipal.getOpcmSalir()){
            System.exit(0);
        }
        if(ae.getSource() == frmRegistrar.getBtnFechaSistema())
        {
            Fecha fecha = new Fecha();
            frmRegistrar.getTxtDia().setText(String.valueOf(fecha.getDd()));
            frmRegistrar.getTxtMes().setText(String.valueOf(fecha.getMm()));
            frmRegistrar.getTxtAno().setText(String.valueOf(fecha.getAa()));
        }
        if(ae.getSource() == frmRegistrar.getBtnRegistrar()){
            HistoriaClinica historia = new HistoriaClinica();
            Paciente objP = null;
            Servicio objS = null;  
            boolean flag = false;
            try
            {//excepcion para control de fecha
                Fecha fecha = new Fecha(Integer.parseInt(frmRegistrar.getTxtDia().getText()),Integer.parseInt(frmRegistrar.getTxtMes().getText()),Integer.parseInt(frmRegistrar.getTxtAno().getText()));
                //se divio en vez de usar el parametrico para poder controlar las excepciones
                
                historia.setNroHistoria(frmRegistrar.getTxtNro().getText());
                historia.setFecha(fecha);
                //objR.getListaH().add(new HistoriaClinica(frmRegistrar.getTxtNro().getText(),
                                                 //fecha,
            //                                     objP,objS));
            }
            catch(NumberFormatException ex)
            {
                String mensaje[] = ex.getMessage().split(":");
                JOptionPane.showMessageDialog(frmPrincipal, "Error, se han introducido valores NO númericos " + mensaje[1]);
                //Para que se ponga automaticamente la del sistema si la caga ajaj no se si ponerlo igual abajo
                //Fecha fecha = new Fecha();
                //debe haber una mejor solucion para esto : para que vuelva a preguntar
                //frmRegistrar.getTxtDia().setText(String.valueOf(fecha.getDd()));
                //frmRegistrar.getTxtMes().setText(String.valueOf(fecha.getMm()));
                //frmRegistrar.getTxtAno().setText(String.valueOf(fecha.getAa()));
                flag = true;
                
            } catch (FormatoEntradaExcepcion ex) {
                JOptionPane.showMessageDialog(frmPrincipal, ex.toString()); 
                //Fecha fecha = new Fecha();
                //frmRegistrar.getTxtDia().setText(String.valueOf(fecha.getDd()));
                //frmRegistrar.getTxtMes().setText(String.valueOf(fecha.getMm()));
                //frmRegistrar.getTxtAno().setText(String.valueOf(fecha.getAa()));
                flag = true;
            }
            //para poder aplicar la excepcion toca hacerle con set? siempre?
            //como evitar que se registre y que no caiga el programa con la excepcion? Dejar que el user carrija...
            if(flag == true)
            {
                JOptionPane.showMessageDialog(frmPrincipal, "Intente de nuevo"); 
            }
           //tipo de afiliacón
        switch(frmRegistrar.getCmbAfiliacion().getSelectedIndex()){
            case 0:{
               objP = new Sisben(frmRegistrar.getTxtIdentificacion().getText(),frmRegistrar.getTxtNombre().getText(),frmRegistrar.getTxtDireccion().getText(),frmRegistrar.getTxtTelefono().getText()); 
               break;
            }
            case 1:{
                objP = new TipoA(frmRegistrar.getTxtIdentificacion().getText(),frmRegistrar.getTxtNombre().getText(),frmRegistrar.getTxtDireccion().getText(),frmRegistrar.getTxtTelefono().getText());
                break;
            }
            case 2:{
                objP = new TipoB(frmRegistrar.getTxtIdentificacion().getText(),frmRegistrar.getTxtNombre().getText(),frmRegistrar.getTxtDireccion().getText(),frmRegistrar.getTxtTelefono().getText());
                break;
            }
            case 3:{
                objP = new TipoC(frmRegistrar.getTxtIdentificacion().getText(),frmRegistrar.getTxtNombre().getText(),frmRegistrar.getTxtDireccion().getText(),frmRegistrar.getTxtTelefono().getText());
                break;
            }
        }
        if(flag == false)
        {
            historia.setDtsPaciente(objP);
        }
        
        //objR.getListaH().get(objR.getListaH().size()-1).setDtsPaciente(objP);
        switch(frmRegistrar.getCmbTipoServicio().getSelectedIndex()){
            case 0:{
               objS = new CitaMedGenr(frmRegistrar.getTxtCodigo().getText(), "Cita Medicina General", frmRegistrar.getTxtaDescripcion().getText()); 
               break;
            }
            case 1:{
               objS = new Vacunacion(frmRegistrar.getTxtCodigo().getText(), "Vacunacion", frmRegistrar.getTxtaDescripcion().getText()); 
               break;
            }
            case 2:{
               abrirVentana(frmExamenes);
               objS = new Laboratorios(examenes,frmRegistrar.getTxtCodigo().getText(), "Laboratorio", frmRegistrar.getTxtaDescripcion().getText());
            break;
            }
            case 3:{
                try{
                objS = new Hospitalizacion(new Fecha(Integer.parseInt(frmRegistrar.getTxtDia().getText()),Integer.parseInt(frmRegistrar.getTxtMes().getText()),Integer.parseInt(frmRegistrar.getTxtAno().getText())),
                                           new Fecha(Integer.parseInt(JOptionPane.showInputDialog(frmRegistrar,"Dia de salida:","Ingrese fecha de salida",1)),
                                                     Integer.parseInt(JOptionPane.showInputDialog(frmRegistrar,"Mes de salida:","Ingrese fecha de salida",1)),
                                                     Integer.parseInt(JOptionPane.showInputDialog(frmRegistrar,"Año de salida:","Ingrese fecha de salida",1))), 
                                           frmRegistrar.getTxtCodigo().getText(), "Hospitalizacion", frmRegistrar.getTxtaDescripcion().getText());
                }
                catch(NumberFormatException ex)
                {
                    String mensaje[] = ex.getMessage().split(":");
                    JOptionPane.showMessageDialog(frmPrincipal, "Error, se han introducido valores NO númericos " + mensaje[1]);
                }
            break;    
            }
        }
        if(flag == false)
        {
            historia.setDtsServicio(objS);
            objR.getListaH().add(historia);//adición a la lista
            JOptionPane.showMessageDialog(frmPrincipal, "Historia Clinica Registrada");
        }
        
        //objR.getListaH().get(objR.getListaH().size()-1).setDtsServicio(objS);
        
        }
     if(ae.getSource() == frmExamenes.getBtnAgregar()){
         Examen ex = null;
                   if(frmExamenes.getBtnSangre().isSelected()){
                       ex=new Examen("101","Sangre",frmExamenes.getTxtDescripcion().getText(),12000);
                   }
                   if(frmExamenes.getBtnOrina().isSelected()){
                      ex=new Examen("102","Orina",frmExamenes.getTxtDescripcion().getText(),10000);
                   }
                   if(frmExamenes.getBtnCorprologico().isSelected()){
                      ex=new Examen("103","Cropológico",frmExamenes.getTxtDescripcion().getText(),15000);
                   }
                   if(frmExamenes.getBtnOptometria().isSelected()){
                     ex=new Examen("104","Optometría",frmExamenes.getTxtDescripcion().getText(),35000);
                   }
                   if(frmExamenes.getBtnOdontologia().isSelected()){
                      ex=new Examen("105","Odontología",frmExamenes.getTxtDescripcion().getText(),50000);
                   }
                examenes.add(ex);
                auxL.setExamenes(examenes);
                objR.getListaH().get(objR.getListaH().size()-1).setDtsServicio(auxL);
                JOptionPane.showMessageDialog(frmExamenes, objR.getListaH().get(objR.getListaH().size()-1).getDtsServicio().toString());
                JOptionPane.showMessageDialog(frmExamenes, "Examen Agregado con exito");
               }   
    }
    
    /**
     * Método para agregar datos a la tabla de consulta de datos
     * @param tabla tabla a modificar
     */
    public void agregarDatos(JTable tabla)
    {
        String fig = "", ser = "";
        double aux1 = 0;
        DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
        plantilla.setRowCount(0);
        for(int i=0; i<objR.getListaH().size(); i++)
        {
            if(objR.getListaH().get(i).getDtsPaciente() instanceof Sisben)
            {
                fig = "Sisben";
            }
            else if(objR.getListaH().get(i).getDtsPaciente() instanceof TipoA)
            {
                fig = "Tipo A";
            }
            else if(objR.getListaH().get(i).getDtsPaciente() instanceof TipoB)
            {
                fig = "Tipo B";
            }
            else if(objR.getListaH().get(i).getDtsPaciente() instanceof TipoC)
            {
                fig = "Tipo C";
            }
            
            if(objR.getListaH().get(i).getDtsServicio() instanceof CitaMedGenr)
            {
                ser = "Cita Medicina General";
            }
            else if(objR.getListaH().get(i).getDtsServicio() instanceof Hospitalizacion)
            {
                ser = "Hospitalización";
            }
            else if(objR.getListaH().get(i).getDtsServicio() instanceof Laboratorios)
            {
                ser = "Laboratorio";
            }
            else if(objR.getListaH().get(i).getDtsServicio() instanceof Vacunacion)
            {
                ser = "Vacunación";
            }
            
            if(objR.getListaH().get(i).getDtsServicio() instanceof CitaMedGenr || objR.getListaH().get(i).getDtsServicio() instanceof Vacunacion){
                aux1 = objR.getListaH().get(i).valor();
            }else if(objR.getListaH().get(i).getDtsServicio() instanceof Laboratorios){
                aux1 = objR.getListaH().get(i).valorLAB((Laboratorios)objR.getListaH().get(i).getDtsServicio());
            }else if(objR.getListaH().get(i).getDtsServicio() instanceof Hospitalizacion){
                aux1 = objR.getListaH().get(i).valorHOPS((Hospitalizacion) objR.getListaH().get(i).getDtsServicio());
            }
            Object datos[] = {objR.getListaH().get(i).getNroHistoria(),
                              objR.getListaH().get(i).getFecha().toString(),
                              objR.getListaH().get(i).getDtsPaciente().getNombre(),
                              objR.getListaH().get(i).getDtsPaciente().getIdentificacion(),
                              objR.getListaH().get(i).getDtsPaciente().getDireccion(),
                              objR.getListaH().get(i).getDtsPaciente().getTelefono(),
                              fig, ser, 
                              aux1};
            plantilla.addRow(datos);
        }
        frmConsultar.getTxtTotal().setText(""+objR.recaudoTotal());
    }
    
    /**
     * Método para abrir ventanas internas y controlar sus excepciones
     * @param frm ventana a abrir
     */
    public void abrirVentana(JInternalFrame frm)
    {
        if(frm.isVisible())
        {
            frm.toFront();
            frm.getFocusOwner();
            try{
                frm.setSelected(true); 
            } 
            catch(PropertyVetoException ex)
            {
                JOptionPane.showMessageDialog(frm, "Error al abrir Ventana " + ex.toString());
            }         
        }
        else if(!frmPrincipal.getPndEscritorio().isAncestorOf(frm))
        {
            frmPrincipal.getPndEscritorio().add(frm);
            frm.setVisible(true);
        }
        else
        {
            frmPrincipal.getPndEscritorio().setSelectedFrame(frm);
            frm.setVisible(true);
        }     
    }
}