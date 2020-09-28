/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selecciones;

/**
 *
 * @author Usuario
 */
public class Reductor_Matriz {

    public int[][] Reductor_Matriz(int[][] Matriz) {

        int Horizontal = 0;
        int Vertical = 0;
        int[][] Matriz_Aux;

        for (int i = 1; i < Matriz.length; i++) {
            if (Matriz[i][0] != 0) {
                Vertical++;
            }
            if (Matriz[0][i] != 0) {
                Horizontal++;
            }
        }

        Matriz_Aux = new int[Vertical + 1][Horizontal + 1];

        if (Horizontal == Vertical) {
            for (int k = 0; k <= Horizontal; k++) {
                for (int p = 0; p <= Horizontal; p++) {
                    Matriz_Aux[k][p] = Matriz[k][p];
                }
            }
        }
        if (Horizontal != Vertical) {
            for (int k = 0; k <= Vertical; k++) {
                for (int p = 0; p <= Horizontal; p++) {
                    Matriz_Aux[k][p] = Matriz[k][p];
                }
            }
        }

        return Matriz_Aux;
    }

}
