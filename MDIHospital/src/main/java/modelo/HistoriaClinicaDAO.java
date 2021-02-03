/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sergio Cruz
 */
public class HistoriaClinicaDAO {
    HistoriaClinica objH;

    public HistoriaClinicaDAO(HistoriaClinica objH) {
        this.objH = objH;
    }
    
    public HistoriaClinicaDAO() {
        this.objH = new HistoriaClinica();
    }
    
    public DefaultTableModel consultar() //tabla de entrada o salida
    {
        DefaultTableModel plantilla = new DefaultTableModel();
        ConexionBD con = new ConexionBD();//objeto con datos de la base de datos y capaz de conectarse a ella
        try {
            con.conectar();
            Statement consulta = con.getConexion().createStatement();//se crea la instancia para madar peticiones a la bd
            ResultSet datos = consulta.executeQuery("select * from historias_clinicas");//devuelve el resultado a de la consulta a bd
            ResultSetMetaData campos = datos.getMetaData();//devuelve, numeros, tipos y propiedaddes de los objetos en las columnas
            
            for (int i = 1; i <= campos.getColumnCount(); i++) 
            {
                plantilla.addColumn(campos.getColumnName(i));//se añaden las columnas a la tabla
            }
            
            while(datos.next())
            {
                Object fila[] = new Object[campos.getColumnCount()];
                for (int i = 0; i < campos.getColumnCount(); i++) //menor que el número de columnas
                {
                    fila[i] = datos.getObject(i+1);//se guardan los datos de las filas, desde la fila 1, la cero son los nombres de las columnas
                
                }
                plantilla.addRow(fila);
            }
            datos.close();
            con.getConexion().close();
            
        }catch (SQLException e)
        {
           JOptionPane.showMessageDialog(null, e.toString()); 
        }
        return plantilla;        
    }
    
    public String insertar()
    {
        String msj="";
        try
        {
            ConexionBD conexion = new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando = "insert into historias_clinicas values(?,?,?,?,?,?,?,?,?)";
            consulta = conexion.getConexion().prepareStatement(comando);
            consulta.setString(1, objH.getNroHistoria());
            consulta.setString(2, objH.getFecha().toString());
            consulta.setString(3, objH.getDtsPaciente().getNombre());
            consulta.setString(4, objH.getDtsPaciente().getIdentificacion());
            consulta.setString(5, objH.getDtsPaciente().getDireccion());
            consulta.setString(6, objH.getDtsPaciente().getTelefono());
            consulta.setString(7, String.valueOf(objH.getDtsPaciente().afiliacion()));
            if(objH.getDtsServicio() instanceof Vacunacion)
            {
                consulta.setString(8, "Vacunacion");
                consulta.setDouble(9, objH.valor());
            }
            if(objH.getDtsServicio() instanceof Hospitalizacion)
            {
                consulta.setString(8, "Hospitalizacion");
                consulta.setDouble(9, objH.valorHOPS((Hospitalizacion) objH.getDtsServicio()));
            }
            if(objH.getDtsServicio() instanceof Laboratorios)
            {
                consulta.setString(8, "Laboratorios");
                consulta.setDouble(9, objH.valorLAB((Laboratorios) objH.getDtsServicio()));
            }
            if(objH.getDtsServicio() instanceof CitaMedGenr)
            {
                consulta.setString(8, "Cita Medicina General");
                consulta.setDouble(9, objH.valor());
            }
            
            consulta.execute();
            msj = "Registro exitoso";
            consulta.close();
            conexion.getConexion().close();
        }catch(SQLException e)
        {
            msj = "Error al ingreso de datos" + e.toString();
        }
        return msj;
    }

    public HistoriaClinica getObjH() {
        return objH;
    }

    public void setObjH(HistoriaClinica objH) {
        this.objH = objH;
    }

    @Override
    public String toString() {
        return objH.toString();
    }
    
    
}
