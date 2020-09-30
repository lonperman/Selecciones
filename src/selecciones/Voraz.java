/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selecciones;

/**
 *
 * @author Cristian Camilo
 */
public class Voraz {

    public void Voraz(int[][] Matriz) {

        Contador_Peso c = new Contador_Peso();
        Comparador c1 = new Comparador();
        Segmentador s1 = new Segmentador();
              
        int Tamaño = Matriz.length;
        int Matriz_Peso[][] = new int[Tamaño][2];     
        int Primer_variable = Matriz_Peso[1][0];
        int Segunda_variable = Matriz_Peso[1][1];
        int Posicion_1 = 1;
        int TamañoY = Matriz.length;
        //Variable de filas
        int TamañoX = Matriz[0].length;
        //Variable de columnas
        int Elemento = 0, Respuesta = 0, Contador = 0, Posicion_P = 0, Villa = 1;
        //Seleccion de candidatos de la villa
        int[][] Matriz_S = new int[TamañoY][TamañoX];
        //Matriz de salida  
        int[][] Matriz_Enemigos = new int[TamañoY][TamañoX];   
        
        boolean Candidato_Asignado = false, Solucion = false, Enemigo = false;
        int Pendientes = TamañoY - 1;
        
        Matriz_Peso = c.Contador_Peso(Matriz);
        Matriz_Enemigos = s1.selecciones(Matriz);
        
        for (int i = 1; i < Matriz_S.length; i++) {
            Matriz_S[i][0] = Matriz[i][0];
        } //Reconstruir la matriz de salida
        
        while (Pendientes > 0) {
            for (int i = 1; i < Matriz_Peso.length; i++) {
                if (Matriz_Peso[i][1] > Segunda_variable && Candidato_Asignado == false) {
                    Primer_variable = Matriz_Peso[i][0];
                    Segunda_variable = Matriz_Peso[i][1];
                    Posicion_P = i;
                }
                if (i > Matriz_Peso.length) {
                    Matriz_Peso[Posicion_P][1] = 0;
                    Candidato_Asignado = true;
                }
            }
            for (int i = 1; i < Matriz_S.length; i++) {
                if (Matriz_S[i][0] == Primer_variable) {
                    Matriz_S[i][Villa] = 1;
                }
            }
            if (Posicion_1 <= TamañoY - 1) {
                Elemento = Matriz_S[Posicion_1][0];
            }
            if (Posicion_1 > TamañoY - 1) {
                Posicion_1 = 1;
            }
            for (int p = 1; p < TamañoX; p++) {
                //verifica si en la casilla existe un digito 0
                if (Matriz_S[Posicion_1][p] == 0) {
                    //Por cada 0 el contador ira sumando
                    Contador++;
                }
            }
            if (Contador == TamañoX - 1) {
                for (int i = 1; i < Matriz_S.length; i++) {
                    if (Matriz_S[i][Villa] == 1) {
                        Respuesta = c1.Comparador(Matriz_S[i][0], Matriz_Enemigos, Elemento);
                        if (Respuesta == 1 && Enemigo == false) {
                            for (int p = 0; p < Matriz_S.length; p++) {
                                if (Elemento == Matriz_S[p][0]) {
                                    Matriz_S[p][Villa] = 1;
                                }
                            }
                        }
                        if (Respuesta == 2) {
                            for (int p = 0; p < Matriz_S.length; p++) {
                                if (Elemento == Matriz_S[p][0]) {
                                    Matriz_S[p][Villa] = 0;
                                    Enemigo = true;
                                }
                            }
                        }
                    }
                }
                Contador = 0;
            } else {
                Contador = 0;
                Pendientes = Pendientes - 1;
            }
            for (int p = 1; p < Matriz_S.length; p++) {
                if (Matriz_S[p][Villa] == 1) {
                    for (int i = 0; i < Matriz_Peso.length; i++) {
                        if (Matriz_S[p][0] == Matriz_Peso[i][0]) {
                            Matriz_Peso[i][1] = 0;
                        }
                    }
                }
            }
            Posicion_1 = Posicion_1 + 1;
            Enemigo = false;
           
            if (Pendientes > 0 && Elemento == TamañoY - 1) {
                Matriz_S[0][Villa] = Villa;
                Villa = Villa + 1;
                Candidato_Asignado = false;
                Posicion_1 = 1;
                Primer_variable = 0;
                Segunda_variable = 0;
                Pendientes = TamañoY - 1;
            }
          /*  if (Pendientes == 0) {
                Solucion = true;
            }*/
        }//Terminacion While
        for (int i = 0; i < Matriz_S.length; i++) {          
            for (int k = 0; k <= Villa-1; k++) {
                System.out.print(Matriz_S[i][k] + " ");
            }
            System.out.println();
        }
    }
}
