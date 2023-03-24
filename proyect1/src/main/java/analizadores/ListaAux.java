/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadores;

/**
 *
 * @author andre
 */
public class ListaAux {

    public nodo2 primero = null;
    public nodo2 ultimo = null;

    public void insertar(String sym, String numHoja, String sigpos) {
        nodo2 nuevo = new nodo2(sym, numHoja, sigpos);
        if (this.primero == null) {
            this.primero = nuevo;
        } else {
            nuevo.anterior = this.ultimo;
            this.ultimo.siguiente = nuevo;
        }
        this.ultimo = nuevo;
    }

    public void imprimir() {
        nodo2 aux = this.primero;
        while (aux != null) {
            System.out.println(aux.sym + "->" + aux.numHoja + "->" + aux.sigpos);
            aux = aux.siguiente;
        }
    }

    public void duplicados() {
        if (this.primero == this.ultimo) {

        } else {
            nodo2 aux = this.primero.siguiente;
            while (aux != null) {
                if (this.primero.sym == aux.sym) {
                    this.primero.sigpos = this.primero.sigpos + aux.sigpos + ",";
                    if (aux == this.primero) {
                        aux.siguiente.anterior = null;
                        this.primero = aux.siguiente;
                        aux.siguiente = null;
                    } else if (aux == this.ultimo) {
                        aux.anterior.siguiente = null;
                        this.ultimo = aux.anterior;
                        aux.anterior = null;
                    } else {
                        aux.anterior.siguiente = aux.siguiente;
                        aux.siguiente.anterior = aux.anterior;
                        aux.siguiente = null;
                        aux.anterior = null;
                    }
                    aux = this.primero;
                }
                aux = aux.siguiente;
            }
        }
    }

    public String getSym() {
        return this.primero.sym;
    }

    public String getHoja() {
        return this.primero.numHoja;
    }

    public String getSigpos() {
        return this.primero.sigpos;
    }

    public int size() {
        int size = 0;
        nodo2 aux = this.primero;
        while (aux != null) {
            size++;
            aux = aux.siguiente;
        }
        return size - 1;
    }

    public void duplicados2() {
        nodo2 aux = this.primero;
        while (aux != null) {
            
            nodo2 aux2 = this.primero;
            while (aux2 != null) {
                if (aux == aux2) {

                } else {
                    if (aux.sym == aux2.sym) {
                        aux.sigpos = aux.sigpos + aux2.sigpos;
                        
                        if (aux2 == this.primero) {
                            aux2.siguiente.anterior = null;
                            this.primero = aux2.siguiente;
                            aux2.siguiente = null;
                        } else if (aux2 == this.ultimo) {
                            aux2.anterior.siguiente = null;
                            this.ultimo = aux2.anterior;
                            aux2.anterior = null;
                        } else {
                            aux2.anterior.siguiente = aux2.siguiente;
                            aux2.siguiente.anterior = aux2.anterior;
                            aux2.siguiente = null;
                            aux2.anterior = null;
                        }
                        
                    }
                }

                aux2 = aux2.siguiente;
            }
            aux = aux.siguiente;
        }
    }

}
