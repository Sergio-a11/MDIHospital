/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.MDIHospital;

import control.Controlador;
import java.io.IOException;

/**
 *
 * @author Sergio Cruz
 */
public class MDIhospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Controlador objC = new Controlador();
        objC.iniciar();
    }
    
}
