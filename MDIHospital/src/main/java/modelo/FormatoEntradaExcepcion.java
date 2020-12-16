/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Sergio Cruz
 */
public class FormatoEntradaExcepcion extends Exception {
    private int nroError;
    private String msg;

    public FormatoEntradaExcepcion(int nroError, String msg) {
        this.nroError = nroError;
        this.msg = msg;
    }
    
    public FormatoEntradaExcepcion(int nroError) {
        this.nroError = nroError;
        switch(nroError)
        {
            case 101://nulo
            {
                this.msg = "Hay campos con valor nulo";
                break;
            }
            case 102://letras
            {
                this.msg = "Campo dedicado unicamente a letras";
                break;
            }
            case 103:
            {
                this.msg = "Campo dedicado unicamente a números";
                break;
            }
            case 104://tamaño cadena
            {
                this.msg = "Se ha superado el numero de caracteres maximo";
                break;
            }
            case 105:
            {
                this.msg = "El dato debe estar en el rango [7,10] números";
                break;
            }
            case 201://fecha formato
            {
                this.msg = "La fecha debe tener formato: dd/mm/aaaa";
                break;
            }
        }
    }
    
    public FormatoEntradaExcepcion() {
        this.nroError = 0;
        this.msg = "";
    }

    public int getNroError() {
        return nroError;
    }

    public void setNroError(int nroRegitro) {
        this.nroError = nroRegitro;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    @Override
    public String toString() {
        return "Error: " + nroError + ": "+ msg;
    }
    
}
