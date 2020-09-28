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

        Ingenua I = new Ingenua();
        Dinamica D = new Dinamica();
        Voraz V = new Voraz();

        // TODO code application logic here
        System.out.println("----------------------------------------------------------------");
        System.out.println("Ingrese la ruta del archivo: \n");

        String ruta = s.next();

        Lector lec = new Lector(ruta);
        Reductor_Matriz rec = new Reductor_Matriz();
        int[][] Matriz = lec.generarMatriz();
        Matriz = rec.Reductor_Matriz(Matriz);
        int Opcion = 0;
        boolean Salida = false;
        System.out.println("Escoga una opcion \n");
        System.out.println("Solucion Ingenua - Opcion 1");
        System.out.println("Solucion Voraz - Opcion 2");
        System.out.println("Solucion Dinamica - Opcion 3");
        System.out.println("\n");
        Opcion = s.nextInt();

        switch (Opcion) {
            case 1:
                I.ingenua(Matriz);
                Opcion = 0;
                break;
            case 2:
                V.Voraz(Matriz);
                Opcion = 0;
                break;
            case 3:
                D.Dinamica(Matriz);
                Opcion = 0;
                break;
            case 4:
                Salida = true;
                break;
        }
    }

}
