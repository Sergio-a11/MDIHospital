/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import modelo.Conexion;
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
    Conexion con;
    long total;

    /**
     * Controlador básico, inicialización de las ventanas, variables y actionListener
     * @throws java.io.IOException control de excepciones
     */
    public Controlador() throws IOException {
        this.objR = new Registros();
        this.frmPrincipal = new VentanaPrincipal();
        this.frmRegistrar = new VentanaRegistrar();
        this.frmExamenes = new VentanaExamenes();
        this.frmConsultar = new VentanaConsultar();
        this.con = new Conexion();
        frmPrincipal.getPndEscritorio().add(frmRegistrar);
        frmPrincipal.getPndEscritorio().add(frmExamenes);
        frmPrincipal.getPndEscritorio().add(frmConsultar);
        this.frmPrincipal.getOpcmRegistrar().addActionListener(this);
        this.frmPrincipal.getOpcmConsultar().addActionListener(this);
        this.frmPrincipal.getOpcmSalir().addActionListener(this);
        this.frmRegistrar.getBtnFechaSistema().addActionListener(this);
        this.frmRegistrar.getBtnRegistrar().addActionListener(this);
        this.frmExamenes.getBtnAgregar().addActionListener(this);
        this.frmExamenes.getBtnFinalizar().addActionListener(this);
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnSangre());
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnOrina());
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnOptometria());
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnOdontologia());
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnCorprologico());
        examenes = new ArrayList<Examen>();
        auxH = new Hospitalizacion();
        auxL = new Laboratorios();
        this.total = 0;
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
            try {
                //agregarDatos(frmConsultar.getTblConsulta());
                agregarDatosPersistencia(frmConsultar.getTblConsulta());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frmPrincipal, "Error al abrir el archivo");
            }
            frmConsultar.getTxtTotal().setText(String.valueOf(this.total));
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
                flag = true;
                
            } catch (FormatoEntradaExcepcion ex) {
                JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Fecha)"); 
                flag = true;
            }
            //para poder aplicar la excepcion toca hacerle con set? siempre?
            
            
           //tipo de afiliacón
        switch(frmRegistrar.getCmbAfiliacion().getSelectedIndex()){
            case 0:{
                Sisben sis = new Sisben();
                try {
                    sis.setDireccion(frmRegistrar.getTxtDireccion().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Dirección)"); 
                    flag = true;
                }
                try {
                    sis.setIdentificacion(frmRegistrar.getTxtIdentificacion().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Identificación)"); 
                    flag = true;
                }
                try {
                    sis.setNombre(frmRegistrar.getTxtNombre().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Nombre)"); 
                    flag = true;
                }
                try {
                    sis.setTelefono(frmRegistrar.getTxtTelefono().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Telefono)"); 
                    flag = true;
                }
                objP = sis;
               break;
            }
            case 1:{
                TipoA ta = new TipoA();
                try {
                    ta.setDireccion(frmRegistrar.getTxtDireccion().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Dirección)"); 
                    flag = true;
                }
                try {
                    ta.setIdentificacion(frmRegistrar.getTxtIdentificacion().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Identificación)"); 
                    flag = true;
                }
                try {
                    ta.setNombre(frmRegistrar.getTxtNombre().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Nombre)"); 
                    flag = true;
                }
                try {
                    ta.setTelefono(frmRegistrar.getTxtTelefono().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Telefono)"); 
                    flag = true;
                }
                objP = ta;
                break;
            }
            case 2:{
                TipoB tb = new TipoB();
                try {
                    tb.setDireccion(frmRegistrar.getTxtDireccion().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Dirección)"); 
                    flag = true;
                }
                try {
                    tb.setIdentificacion(frmRegistrar.getTxtIdentificacion().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Identificación)"); 
                    flag = true;
                }
                try {
                    tb.setNombre(frmRegistrar.getTxtNombre().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Nombre)"); 
                    flag = true;
                }
                try {
                    tb.setTelefono(frmRegistrar.getTxtTelefono().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Telefono)"); 
                    flag = true;
                }
                objP = tb;
                break;
            }
            case 3:{
                TipoC tc = new TipoC();
                try {
                    tc.setDireccion(frmRegistrar.getTxtDireccion().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Dirección)"); 
                    flag = true;
                }
                try {
                    tc.setIdentificacion(frmRegistrar.getTxtIdentificacion().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Identificación)"); 
                    flag = true;
                }
                try {
                    tc.setNombre(frmRegistrar.getTxtNombre().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Nombre)"); 
                    flag = true;
                }
                try {
                    tc.setTelefono(frmRegistrar.getTxtTelefono().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Telefono)"); 
                    flag = true;
                }
                objP = tc;
                break;
            }
        }
        
        //objR.getListaH().get(objR.getListaH().size()-1).setDtsPaciente(objP);
        switch(frmRegistrar.getCmbTipoServicio().getSelectedIndex()){
            case 0:{
               //objS = new CitaMedGenr(frmRegistrar.getTxtCodigo().getText(), "Cita Medicina General", frmRegistrar.getTxtaDescripcion().getText()); 
                CitaMedGenr med = new CitaMedGenr();
                try {
                    med.setCodigo(frmRegistrar.getTxtCodigo().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Cod Servicio)"); 
                    flag = true;
                }
                med.setNombre("Cita Medicina General");
                try {
                    med.setDescripcion(frmRegistrar.getTxtaDescripcion().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Nom Servicio)"); 
                    flag = true;
                }
                objS = med;
                break;
            }
            case 1:{
               //objS = new Vacunacion(frmRegistrar.getTxtCodigo().getText(), "Vacunacion", frmRegistrar.getTxtaDescripcion().getText()); 
                Vacunacion vac = new Vacunacion();
                try {
                    vac.setCodigo(frmRegistrar.getTxtCodigo().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Cod Servicio)"); 
                    flag = true;
                }
                vac.setNombre("Vacunacion");
                try {
                    vac.setDescripcion(frmRegistrar.getTxtaDescripcion().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Nom Servicio)"); 
                    flag = true;
                }
               objS = vac;
               break;
            }
            case 2:{
                    abrirVentana(frmExamenes);
                Laboratorios lab = new Laboratorios(examenes, null, null, null);
                try {
                    lab.setCodigo(frmRegistrar.getTxtCodigo().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Cod Servicio)"); 
                    flag = true;
                }
                lab.setNombre("Laboratorio");
                try {
                    lab.setDescripcion(frmRegistrar.getTxtaDescripcion().getText());
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Nom Servicio)"); 
                    flag = true;
                }
                objS = lab;
               //objS = new Laboratorios(examenes,frmRegistrar.getTxtCodigo().getText(), "Laboratorio", frmRegistrar.getTxtaDescripcion().getText());
            break;
            }
            case 3:{
                try{
                Hospitalizacion hos = new Hospitalizacion();
                Fecha entrada = new Fecha(Integer.parseInt(frmRegistrar.getTxtDia().getText()),Integer.parseInt(frmRegistrar.getTxtMes().getText()),Integer.parseInt(frmRegistrar.getTxtAno().getText()));
                hos.setIngreso(entrada);
                Fecha salida = new Fecha(Integer.parseInt(JOptionPane.showInputDialog(frmRegistrar,"Dia de salida:","Ingrese fecha de salida [formato dd]",1)),
                                         Integer.parseInt(JOptionPane.showInputDialog(frmRegistrar,"Mes de salida:","Ingrese fecha de salida [formato mm]",1)),
                                         Integer.parseInt(JOptionPane.showInputDialog(frmRegistrar,"Año de salida:","Ingrese fecha de salida [formato aaaa]",1)));
                hos.setSalida(salida);
                hos.setCodigo(frmRegistrar.getTxtCodigo().getText());
                hos.setNombre("Hospitalizacion");
                hos.setDescripcion(frmRegistrar.getTxtaDescripcion().getText());
                
                /*objS = new Hospitalizacion(new Fecha(Integer.parseInt(frmRegistrar.getTxtDia().getText()),Integer.parseInt(frmRegistrar.getTxtMes().getText()),Integer.parseInt(frmRegistrar.getTxtAno().getText())),
                                           new Fecha(Integer.parseInt(JOptionPane.showInputDialog(frmRegistrar,"Dia de salida:","Ingrese fecha de salida",1)),
                                                     Integer.parseInt(JOptionPane.showInputDialog(frmRegistrar,"Mes de salida:","Ingrese fecha de salida",1)),
                                                     Integer.parseInt(JOptionPane.showInputDialog(frmRegistrar,"Año de salida:","Ingrese fecha de salida",1))), 
                                           frmRegistrar.getTxtCodigo().getText(), "Hospitalizacion", frmRegistrar.getTxtaDescripcion().getText());
                */
                objS = hos;
                }
                catch(NumberFormatException ex)
                {
                    String mensaje[] = ex.getMessage().split(":");
                    JOptionPane.showMessageDialog(frmPrincipal, "Error, se han introducido valores NO númericos " + mensaje[1]);
                    flag = true;
                } catch (FormatoEntradaExcepcion ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, ex.toString() + " (Nom Fecha Salida)"); 
                    flag = true;
                }
            break;    
            }
        }
        if(flag == false)
        {
            historia.setDtsPaciente(objP);
            historia.setDtsServicio(objS);
            objR.getListaH().add(historia);//adición a la lista
            JOptionPane.showMessageDialog(frmPrincipal, "Historia Clinica Registrada");
            //objR.getListaH().add(historia);//adición a la lista
            //JOptionPane.showMessageDialog(frmPrincipal, "Historia Clinica Registrada");
            if( !(objR.getListaH().get(objR.getListaH().size()-1).getDtsServicio() instanceof Laboratorios)){
                try{
                    String msj = datos(objR.getListaH().size()-1);
                    con.EscribeDatos(msj, "RegistroHospital.txt");
                }catch(IOException ex){
                    JOptionPane.showMessageDialog(frmConsultar, "Error al abrir el archivo");
                }   

            }
            //limpieza porque no hay jPanle
            frmRegistrar.getTxtNro().setText("");
            frmRegistrar.getTxtAno().setText("");
            frmRegistrar.getTxtDia().setText("");
            frmRegistrar.getTxtMes().setText("");
            frmRegistrar.getTxtIdentificacion().setText("");
            frmRegistrar.getTxtTelefono().setText("");
            frmRegistrar.getTxtaDescripcion().setText("");
            frmRegistrar.getTxtCodigo().setText("");
            frmRegistrar.getTxtDireccion().setText("");
            frmRegistrar.getTxtNombre().setText("");
        }
        
        //objR.getListaH().get(objR.getListaH().size()-1).setDtsServicio(objS);
        
        if(flag == true)
        {
                JOptionPane.showMessageDialog(frmPrincipal, "Paciente no registrado");
                flag = false;
        }
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
                /*try{
                    String msj = datos(objR.getListaH().size()-1);
                    con.EscribeDatos(msj, "RegistroHospital.txt");
                }catch(IOException exx){
                    JOptionPane.showMessageDialog(frmConsultar, "Error al abrir el archivo");
                }*/
     }
     if(ae.getSource() ==frmExamenes.getBtnFinalizar()){
         try{
            String msj = datos(objR.getListaH().size()-1);
            con.EscribeDatos(msj, "RegistroHospital.txt");
        }catch(IOException ex){
            JOptionPane.showMessageDialog(frmConsultar, "Error al abrir el archivo");
        }
        frmExamenes.setVisible(false); 
     }
    }
    
    /**
     * Método para agregar datos a la tabla de consulta de datos
     * @param tabla tabla a modificar
     */
    /*public void agregarDatos(JTable tabla) throws IOException
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
        
    }*/
    
    public void agregarDatosPersistencia(JTable tabla) throws IOException{
        DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
        plantilla.setRowCount(0);
        String datos = con.leerDatos("RegistroHospital.txt");
        archivoTabla(datos,frmConsultar.getTblConsulta());
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
    
    public void archivoTabla(String datos, JTable tabla){
        this.total = 0;
        DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
        String ListaHospital []=datos.split("\n");
        for (int i = 0; i < ListaHospital.length; i++) {
            String historia []= ListaHospital[i].split(";");
            Object fila[] = {historia[0], historia[1],
                historia[2], historia[3],
                historia[4], historia[5],
                historia[6], historia[7],
                Double.parseDouble(historia[8])};
            this.total += Double.parseDouble(historia[8]);
            plantilla.addRow(fila);
        }
    }
    
    public String datos(int i){
        String msj = "";
        if(objR.getListaH().get(i).getDtsServicio()instanceof CitaMedGenr || objR.getListaH().get(i).getDtsServicio()instanceof Vacunacion){
         msj = objR.getListaH().get(i).getNroHistoria()+";"
              +objR.getListaH().get(i).getFecha().toString()+";"
              +objR.getListaH().get(i).getDtsPaciente().toString()+";"
              +objR.getListaH().get(i).getDtsPaciente().afiliacion()+";"
              +objR.getListaH().get(i).getDtsServicio().getNombre()+";"
              +objR.getListaH().get(i).valor();   
        }
        if(objR.getListaH().get(i).getDtsServicio()instanceof Laboratorios){
         msj = objR.getListaH().get(i).getNroHistoria()+";"
              +objR.getListaH().get(i).getFecha().toString()+";"
              +objR.getListaH().get(i).getDtsPaciente().toString()+";"
              +objR.getListaH().get(i).getDtsPaciente().afiliacion()+";"
              +objR.getListaH().get(i).getDtsServicio().tiposervicio()+";"
              +objR.getListaH().get(i).valorLAB((Laboratorios) objR.getListaH().get(i).getDtsServicio());   
        }
        if(objR.getListaH().get(i).getDtsServicio()instanceof Hospitalizacion){
         msj = objR.getListaH().get(i).getNroHistoria()+";"
              +objR.getListaH().get(i).getFecha().toString()+";"
              +objR.getListaH().get(i).getDtsPaciente().toString()+";"
              +objR.getListaH().get(i).getDtsPaciente().afiliacion()+";"
              +objR.getListaH().get(i).getDtsServicio().getNombre()+";"
              +objR.getListaH().get(i).valorHOPS((Hospitalizacion) objR.getListaH().get(i).getDtsServicio());   
        }
        return msj;
    }
}