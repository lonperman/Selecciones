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
public class Comparador {

    public int Comparador(int Seleccion, int[][] Matriz, int Elemento) {
        int Respuesta = 0;
        int Posicion = 0;

       
        //El for recorre toda la matriz hasta encontrar la seleccion
        for (int e = 0; e < Matriz.length; e++) {
            //Si encuentra la seleccion se procede a verificar sus enemigos
            if (Matriz[e][Posicion] == Seleccion) {
                //El for verifica a sus enemigos de forma horizontal
                for (int i = 1; i < Matriz[0].length; i++) {
                    //se verifica si el elemento esta dentro de los enemigos de la seleccion 
                    if (Matriz[e][i] == Elemento) {
                        //Si se encuentra su respuesta sera 2
                        Respuesta = 2;
                        //Sino se encuentra la respuesta sera 1    
                    } else if (Respuesta != 2) {
                        Respuesta = 1;
                    }
                }
            }
        }

        return Respuesta;
    }

}
