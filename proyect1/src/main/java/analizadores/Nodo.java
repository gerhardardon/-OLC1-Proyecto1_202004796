/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadores;



/**
 *
 * @author andre
 */
public class Nodo {

    public Nodo hijoIzq;
    public Nodo hijoDer;
    public String valor;
    public int idNodo;
    public int idHoja;
    public boolean anulable;
    public String primero;
    public String ultimo;

    public Nodo(Nodo hijoIzq, Nodo hijoDer, String valor, int idNodo, int idHoja, boolean anulable, String primero, String ultimo) {
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
        this.valor = valor;
        this.idNodo = idNodo;
        this.idHoja = idHoja;
        this.anulable = anulable;
        this.primero = primero;
        this.ultimo = ultimo;
    }

    public Nodo getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public Nodo getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getIdNodo() {
        return idNodo;
    }

    public void setIdNodo(int idNodo) {
        this.idNodo = idNodo;
    }

    public int getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(int idHoja) {
        this.idHoja = idHoja;
    }

    public boolean isAnulable() {
        return anulable;
    }

    public void setAnulable(boolean anulable) {
        this.anulable = anulable;
    }

    public String getPrimero() {
        return primero;
    }

    public void setPrimero(String primero) {
        this.primero = primero;
    }

    public String getUltimo() {
        return ultimo;
    }

    public void setUltimo(String ultimo) {
        this.ultimo = ultimo;
    }

    public String getCodigoInterno() {
        String etiqueta;
        if (hijoIzq == null && hijoDer == null) {
            etiqueta = "nodo" + idNodo + " [ label =\"" + valor + "\n\nfirst: " + primero + "\nlast: " + ultimo + "\nan: " + anulable + "\nhoja: " + idHoja + "\"]; \n";
        } else {
            etiqueta = "nodo" + idNodo + " [ label =\"" + valor + "\n\nfirst: " + primero + "\nlast: " + ultimo + "\nan: " + anulable + "\"]; \n";
        }
        if (hijoIzq != null) {
            etiqueta = etiqueta + hijoIzq.getCodigoInterno()
                    + "nodo" + idNodo + "->nodo" + hijoIzq.idNodo + "\n";
        }
        if (hijoDer != null) {
            etiqueta = etiqueta + hijoDer.getCodigoInterno()
                    + "nodo" + idNodo + "->nodo" + hijoDer.idNodo + "\n";
        }
        return etiqueta;
    }
}
