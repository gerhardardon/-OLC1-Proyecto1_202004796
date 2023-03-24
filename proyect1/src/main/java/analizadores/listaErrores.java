/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadores;

/**
 *
 * @author andre
 */
public class listaErrores {
        String lexema;
    int linea;
    int columna;
    String tipo;
    
    public listaErrores(String lexema, int linea, int columna, String tipo){
 
        this.lexema=lexema;
        this.linea=linea;
        this.columna=columna;
        this.tipo=tipo;
    }


    public String getLexema() {
        return lexema;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public String getTipo() {
        return tipo;
    }
    
}
