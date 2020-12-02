/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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

    public Controlador(Registros objR, VentanaPrincipal frmPrincipal, VentanaRegistrar frmRegistrar) {
        this.objR = new Registros();
        this.frmPrincipal = new VentanaPrincipal();
        this.frmRegistrar = new VentanaRegistrar();
        this.frmExamenes = new VentanaExamenes();
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
            frmRegistrar.setVisible(true);
        }
        if(ae.getSource() == frmPrincipal.getOpcmConsultar()){
            frmRegistrar.setVisible(true);
        }
        if(ae.getSource() == frmPrincipal.getOpcmSalir()){
            frmRegistrar.setVisible(true);
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
            }
            case 1:{
                objP = new TipoA(frmRegistrar.getTxtIdentificacion().getText(),frmRegistrar.getTxtNombre().getText(),frmRegistrar.getTxtDireccion().getText(),frmRegistrar.getTxtTelefono().getText());
            }
            case 2:{
                objP = new TipoB(frmRegistrar.getTxtIdentificacion().getText(),frmRegistrar.getTxtNombre().getText(),frmRegistrar.getTxtDireccion().getText(),frmRegistrar.getTxtTelefono().getText());
            }
            case 3:{
                objP = new TipoC(frmRegistrar.getTxtIdentificacion().getText(),frmRegistrar.getTxtNombre().getText(),frmRegistrar.getTxtDireccion().getText(),frmRegistrar.getTxtTelefono().getText());
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
               frmExamenes.setVisible(true);
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
                                                     Integer.parseInt(JOptionPane.showInputDialog(frmRegistrar,"Dia de salida:","Ingrese fecha de salida",1)),
                                                     Integer.parseInt(JOptionPane.showInputDialog(frmRegistrar,"Dia de salida:","Ingrese fecha de salida",1))), 
                                           frmRegistrar.getTxtCodigo().getText(), "Hospitalizacion", frmRegistrar.getTxtaDescripcion().getText());
            }
        }
        objR.getListaH().get(objR.getListaH().size()-1).setDtsPaciente(objP);
        }
    }
}
