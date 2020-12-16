/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.*;

/**
 *
 * @author Estudiante
 */
public class Conexion {

    /**
     *
     */
    protected BufferedReader ent ;

    /**
     *
     */
    protected FileReader archLee;

    /**
     *
     */
    protected FileWriter archEscr;
 
    /**
     *
     */
    protected PrintWriter sal; 

    /**
     *
     * @param ent entrada para leer
     * @param archLee lector del archivo
     * @param archEscr escritor del archivo
     * @param sal salida para escrivir
     */
    public Conexion(BufferedReader ent, FileReader archLee, FileWriter archEscr, PrintWriter sal) {
        this.ent = ent;
        this.archLee = archLee;
        this.archEscr = archEscr;
        this.sal = sal;
    }

    /**
     *
     * @throws IOException
     */
    public Conexion() throws IOException {
       // this.ent = ent;
       this.archLee = null;
       this.archEscr = null;
       // this.sal = sal;
    }
  
    /**
     *
     * @param nomArchivo nombre del archivo
     * @return String
     * @throws IOException
     */
    public String leerDatos(String nomArchivo) throws IOException{
  //System.out.println("Entré...");
   this.archLee = new FileReader(nomArchivo);
   ent = new BufferedReader(archLee);
   String datos=" ";
   String linea = this.ent.readLine();
   while (linea != null) { 
        datos+=linea+"\n";
  //       System.out.println(" "+datos);
    linea = ent.readLine();
   }
    ent.close();
    return datos;
 }

    /**
     *
     * @param datos datos a escribir en el archivo
     * @param nomArchivo nombre del archivo
     * @throws IOException
     */
    public void EscribeDatos(String datos, String nomArchivo) throws IOException
 { 
   archEscr= new FileWriter(nomArchivo,true);
   sal = new PrintWriter(archEscr);
   sal.println(datos);
   System.out.println("Ejecuto accion");
   sal.close();
 } 

}
