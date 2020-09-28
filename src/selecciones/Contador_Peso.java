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
public class Contador_Peso {

    public int[][] Contador_Peso(int[][] Matriz) {

        int y = Matriz.length;
        int Contador = 0;
        int[][] Matriz_salida = new int[y][2];
        //se hace un recorrido de la matriz
        for (int i = 0; i < Matriz.length; i++) {
            for (int p = 1; p < Matriz[0].length; p++) {
                if (Matriz[i][p] != 0) {
                    Contador++;
                }
            }
            Matriz_salida[i][0] = Matriz[i][0]; //Se asigna la seleccion 
            Matriz_salida[i][1] = Contador;//Se asigna el peso de la seleccion
            Contador = 0;//Se reinicia el contador
        }

        return Matriz_salida;
    }

}
