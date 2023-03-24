/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package analizadores;

/**
 *
 * @author andre
 */
public class Analizadores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        generarCompilador();
    }
    private static void generarCompilador() 
    {
        try {
            String ruta = "src/main/java/analizadores/";
            String opcFlex[] = {ruta + "Lexico.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);
            System.out.println("---------------------------------------done");
            
            
            String opcCUP[] = {"-destdir", ruta, "-parser", "parser", ruta + "Sintactico.cup"};
            java_cup.Main.main(opcCUP);
            System.out.println("---------------------------------------done");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("no se pudo");
            
        }
    }
    
}
