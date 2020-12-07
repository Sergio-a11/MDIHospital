/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 * Clase de la entidad Laboratorios
 * @author dadxc
 */
public class Laboratorios extends Servicio{
    private ArrayList<Examen> examenes;

    /**
     * Constructor Paramétrico, llama al contructor padre
     * @param examenes lista de examenes del paciente
     * @param Codigo codigo de servicio, derivado del padre (Servivio)
     * @param Nombre nombre de servicio, derivado del padre (Servivio)
     * @param Descripcion descripción de servicio, derivado del padre (Servivio)
     */
    public Laboratorios(ArrayList<Examen> examenes, String Codigo, String Nombre, String Descripcion) {
        super(Codigo, Nombre, Descripcion);
        this.examenes = examenes;
    }

    /**
     * Construcor básico, llama al constructor padre e inicializa la lista de examenes
     */
    public Laboratorios() {
        super();
        this.examenes = new ArrayList<Examen>();
    }

    /**
     * Método para obtener la lista de examenes del paciente
     * @return ArrayList
     */
    public ArrayList<Examen> getExamenes() {
        return examenes;
    }

    /**
     * Método para modificar la lista de examenes del paciente
     * @param examenes lista de examenes modificada
     */
    public void setExamenes(ArrayList<Examen> examenes) {
        this.examenes = examenes;
    }

    /**
     * Método que describe el tipo del servicio especifico dentro de un servicio a un cliente
     * @return String
     */
    @Override
    public String tiposervicio() {
        return "Laboratorios";
    }

    /**
     * Método para obtener la lista de examenes del paciente, en formato string de texto
     * @return String
     */
    @Override
    public String toString() {
        String msj = "";
        for (int i = 0; i < examenes.size(); i++) {
            msj+=examenes.get(i).toString();
        }
        return msj;
    }
    
    
}
