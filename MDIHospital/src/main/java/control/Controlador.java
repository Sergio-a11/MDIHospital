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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

/**
 *
 * @author dadxc
 */
public class Controlador implements ActionListener {
    Registros objR;
    VentanaPrincipal frmPrincipal;
    VentanaRegistrar frmRegistrar;
    VentanaExamenes frmExamenes;
    VentanaConsultar frmConsultar;

    public Controlador() {
        this.objR = new Registros();
        this.frmPrincipal = new VentanaPrincipal();
        this.frmRegistrar = new VentanaRegistrar();
        this.frmExamenes = new VentanaExamenes();
        this.frmConsultar = new VentanaConsultar();
        frmPrincipal.getPndEscritorio().add(frmRegistrar);
        frmPrincipal.getPndEscritorio().add(frmExamenes);
        frmPrincipal.getPndEscritorio().add(frmConsultar);
        //frmPrincipal.getPndEscritorio().add(frmBuscar);
        this.frmPrincipal.getOpcmRegistrar().addActionListener(this);
        this.frmPrincipal.getOpcmConsultar().addActionListener(this);
        this.frmPrincipal.getOpcmBuscar().addActionListener(this);
        this.frmPrincipal.getOpcmSalir().addActionListener(this);
        this.frmRegistrar.getBtnFechaSistema().addActionListener(this);
        this.frmRegistrar.getBtnRegistrar().addActionListener(this);
        this.frmExamenes.getBtnAgregar().addActionListener(this);
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnSangre());
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnOrina());
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnOptometria());
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnOdontologia());
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnCorprologico());
    }
    
    public void iniciar(){
        frmPrincipal.setTitle("Hospital");
        frmPrincipal.setVisible(true);
    }

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
        if(ae.getSource() == frmRegistrar.getBtnRegistrar()){
            Paciente objP = null;
            Servicio objS = null;
        objR.getListaH().add(new HistoriaClinica(frmRegistrar.getTxtNro().getText(),
                                                 new Fecha(Integer.parseInt(frmRegistrar.getTxtDia().getText()),Integer.parseInt(frmRegistrar.getTxtMes().getText()),Integer.parseInt(frmRegistrar.getTxtAno().getText())),
                                                 objP,objS));
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
        objR.getListaH().get(objR.getListaH().size()-1).setDtsPaciente(objP);
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
               ArrayList<Examen> examenes = null; 
               abrirVentana(frmExamenes);
               if(ae.getSource() == frmExamenes.getBtnAgregar()){
                   if(frmExamenes.getBtnSangre().isSelected()){
                       examenes.add(new Examen("101","Sangre",frmExamenes.getTxtDescripcion().getText(),12000));
                   }
                   if(frmExamenes.getBtnOrina().isSelected()){
                       examenes.add(new Examen("102","Orina",frmExamenes.getTxtDescripcion().getText(),10000));
                   }
                   if(frmExamenes.getBtnOrina().isSelected()){
                       examenes.add(new Examen("103","Cropológico",frmExamenes.getTxtDescripcion().getText(),15000));
                   }
                   if(frmExamenes.getBtnOrina().isSelected()){
                       examenes.add(new Examen("104","Optometría",frmExamenes.getTxtDescripcion().getText(),35000));
                   }
                   if(frmExamenes.getBtnOrina().isSelected()){
                       examenes.add(new Examen("105","Odontología",frmExamenes.getTxtDescripcion().getText(),50000));
                   }
               }
                objS = new Laboratorios(examenes,frmRegistrar.getTxtCodigo().getText(), "Laboratorio", frmRegistrar.getTxtaDescripcion().getText());
            break;
            }
            case 3:{
                objS = new Hospitalizacion(new Fecha(Integer.parseInt(frmRegistrar.getTxtDia().getText()),Integer.parseInt(frmRegistrar.getTxtMes().getText()),Integer.parseInt(frmRegistrar.getTxtAno().getText())),
                                           new Fecha(Integer.parseInt(JOptionPane.showInputDialog(frmRegistrar,"Dia de salida:","Ingrese fecha de salida",1)),
                                                     Integer.parseInt(JOptionPane.showInputDialog(frmRegistrar,"Mes de salida:","Ingrese fecha de salida",1)),
                                                     Integer.parseInt(JOptionPane.showInputDialog(frmRegistrar,"Año de salida:","Ingrese fecha de salida",1))), 
                                           frmRegistrar.getTxtCodigo().getText(), "Hospitalizacion", frmRegistrar.getTxtaDescripcion().getText());
            }
        }
        objR.getListaH().get(objR.getListaH().size()-1).setDtsServicio(objS);
        }
    }
    
    public void agregarDatos(JTable tabla)
    {
        String fig = "", ser = "";
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
            Object datos[] = {objR.getListaH().get(i).getNroHistoria(),
                              objR.getListaH().get(i).getFecha().toString(),
                              objR.getListaH().get(i).getDtsPaciente().getNombre(),
                              objR.getListaH().get(i).getDtsPaciente().getIdentificacion(),
                              objR.getListaH().get(i).getDtsPaciente().getDireccion(),
                              objR.getListaH().get(i).getDtsPaciente().getTelefono(),
                              fig, ser, "Nulo"};
            plantilla.addRow(datos);
        }
    }
    
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