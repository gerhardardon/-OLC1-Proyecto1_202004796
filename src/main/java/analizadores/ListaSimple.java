/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadores;

import static analizadores.parser.arrayId;
import static analizadores.parser.tablaSiguientes;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author andre
 */
public class ListaSimple {

    public nodoS primero = null;
    public nodoS ultimo = null;

    public void insertar(String sInicial, String sym, String sigpos, String sFinal) {
        nodoS nuevo = new nodoS(sInicial, sym, sigpos, sFinal);
        if (this.primero == null) {
            this.primero = nuevo;
        } else {
            nuevo.anterior = this.ultimo;
            nuevo.siguiente = this.primero;
            this.ultimo.siguiente = nuevo;
            this.primero.anterior = nuevo;
        }
        this.ultimo = nuevo;
    }

    public String imprimir() {
        String txt="";
        nodoS aux = this.primero;
        while (aux != null) {
            txt += "<tr><td>" + aux.sInicial + "</td><td>" + aux.sym + "</td><td>" + aux.sigpos + "</td><td>" + aux.sFinal + "</td></tr>";
                
            while (aux.siguiente == this.primero) {
                return txt;
            }
            aux = aux.siguiente;
        }
        return txt;
    }

    public void transicionesDot(String nombre) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombre + "_transiciones.dot");
            pw = new PrintWriter(fichero);
            String texto = """
                         digraph tabla {
                             node [shape=plaintext]
                             tabla [label=<<table border="1" cellspacing="0">
                                 <tr><td bgcolor="#c1e1c1"><b> Estado </b></td><td bgcolor="#c1e1c1"><b> Sym </b></td><td bgcolor="#c1e1c1"><b> Sigpos </b></td><td bgcolor="#c1e1c1"><b> Estado </b></td></tr>
                                 
                         """;
            
            texto += this.imprimir();
            
            texto += "</table>>];}";
            System.out.println(texto);
            pw.println(texto);

        } catch (Exception e) {
            System.out.println("error, no se realizo el archivo" + e);
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        //para compilar el archivo dot y obtener la imagen
        try {
            //dirección doonde se ecnuentra el compilador de graphviz
            String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
            //dirección del archivo dot
            String fileInputPath = nombre + "_transiciones.dot";
            //dirección donde se creara la magen
            String fileOutputPath = "TRANSICIONES_202004796\\"+nombre + "_transiciones.jpg";
            //tipo de conversón
            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);
            System.out.println("######listo, transiciones hecho###############");

        } catch (Exception e) {

        }

    }
    
    public void eliminar(){
        this.primero=null;
        this.ultimo=null;
    }

}
