/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadores;

/**
 *
 * @author andre
 */
public class nodoS {
    public String sInicial;
    public String sym;
    public String sigpos;
    public String sFinal;
    public nodoS anterior = null;
    public nodoS siguiente = null;

    public nodoS(String sInicial, String sym, String sigpos, String sFinal) {
        this.sInicial = sInicial;
        this.sym = sym;
        this.sigpos = sigpos;
        this.sFinal = sFinal;
    }
    
    
}
