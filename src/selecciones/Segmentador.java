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
public class Segmentador {

    public int[][] selecciones(int[][] Matriz_selecciones) {

        int x = 0, y = 0;
        int Arreglo[][];
        int SX = Matriz_selecciones[0].length - 1;
        int SY = Matriz_selecciones.length - 1;
        Arreglo = new int[SY][SX];

        for (int i = 1; i <= SY; i++) {
            y = 0;
            Arreglo[i - 1][y] = Matriz_selecciones[i][y];
            for (int p = 1; p <= SX; p++) {
                if (Matriz_selecciones[i][p] == 1) {
                    y++;
                    Arreglo[i - 1][y] = Matriz_selecciones[0][p];
                }
            }
        }

        return Arreglo;
    }
}
