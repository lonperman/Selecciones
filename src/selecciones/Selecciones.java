/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selecciones;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Selecciones {

    /**
     * @param args the command line arguments
     */
    

    static Scanner s = new Scanner(System.in);
    
    public static void main(String[] args) {
     
        // TODO code application logic here
        System.out.println("----------------------------------------------------------------");
        System.out.println("Ingrese la ruta del archivo: \n");
        
        String ruta = s.next();
        
        Lector lec = new Lector(ruta);
        Reductor_Matriz rec = new Reductor_Matriz();
        int [][] Matriz = lec.generarMatriz();
        Matriz = rec.Reductor_Matriz(Matriz);
        
       
       Ingenua I = new Ingenua();
       I.ingenua(Matriz);    
   
    }
    
}
