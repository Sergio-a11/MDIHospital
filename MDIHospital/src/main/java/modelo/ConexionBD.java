/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sergio Cruz
 */
public class ConexionBD {
    private Connection conexion;
    private String bd, user, clave, msj;

    public ConexionBD(Connection conexion, String bd, String user, String clave, String msj) {
        this.conexion = conexion;
        this.bd = bd;
        this.user = user;
        this.clave = clave;
        this.msj = msj;
    }
    
    public ConexionBD() {
        this.conexion = null;
        this.bd = "hospital";
        this.user = "root";
        this.clave = "";
        this.msj = "";
    }
    
    public void conectar()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");//retorna la información de que tipo es un clase y el funcionamiento
            String ruta = "jdbc:mysql://localhost/" + bd;//inidca la ruta de la base de datos a consultar
            System.out.print(ruta);//comprobar ruta
            conexion = (Connection) DriverManager.getConnection(ruta, user, clave);//se conecta a la bd, con los datos dados, ruta, user y clave
            msj = "Se conecto";
        }catch(ClassNotFoundException | SQLException e)
        {
            msj = "NO se conecto";
        }
    }

    @Override
    public String toString() {
        return "ConexionBD{" + "conexion=" + conexion + ", bd=" + bd + ", user=" + user + ", clave=" + clave + ", msj=" + msj + '}';
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }
    
    
}
