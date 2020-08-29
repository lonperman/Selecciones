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
public class Ingenua {
    
    public void ingenua() {
    
        int Matriz_selecciones[][] = {{0,1,2,3,4,5,6,7,8,9},
                                      {1,0,0,1,0,0,1,1,0,0},
                                      {2,1,0,1,0,0,1,1,0,1},
                                      {3,0,1,0,0,0,1,1,0,1},
                                      {4,1,1,1,0,0,1,1,0,0},
                                      {5,1,1,1,1,0,1,1,0,1}};
        
        int TamañoX = Matriz_selecciones[0].length-1;
        int TamañoY = Matriz_selecciones.length;
        int TamañoM = 2;
        int Posicion_1 = 0;
        int Posicion_2 = 1;
        int [][]Selecciones_Salida = new int[TamañoY][TamañoM];
        int [][]Matriz_NR = new int[TamañoY][TamañoX];
        int []NoRelaciones = new int[TamañoX];
       
        for(int i = 1;i<TamañoY; i++){
             Selecciones_Salida[i][Posicion_1] = Matriz_selecciones[i][Posicion_1];
            //System.out.println("Seleccion Guardada: " + Selecciones_Salida[i][Posicion_1]);
        }
        Segmentador s = new Segmentador();
        Matriz_NR = s.selecciones(Matriz_selecciones);
        
        if(Selecciones_Salida[Posicion_2][Posicion_1+1] == 0){
            for(int k=0;k <Matriz_NR[0].length;k++){
                 
              if(Selecciones_Salida[Posicion_2][Posicion_1] == NoRelaciones[k]){
                  Selecciones_Salida[Posicion_2][Posicion_1+1] = 0;
              } else {Selecciones_Salida[Posicion_2][Posicion_1+1] = 1;}
            }
        }
        
        
      for(int i = 0;i < Selecciones_Salida.length;i++){
            //System.out.println("Seleccion: " + Selecciones_Salida[i][Posicion_1]);
            for(int k = 0; k < Selecciones_Salida[0].length;k++){
                 System.out.print(Selecciones_Salida[i][k]+" ");
                 
                  
            }
           System.out.println();
        }
}
    
}
