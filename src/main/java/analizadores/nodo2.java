/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadores;

/**
 *
 * @author andre
 */
public class nodo2 {
    public String sym;
    public String numHoja;
    public String sigpos;
    public nodo2 anterior = null;
    public nodo2 siguiente = null;

    public nodo2(String sym, String numHoja, String sigpos) {
        this.sym = sym;
        this.numHoja = numHoja;
        this.sigpos = sigpos;
    }
    
}
