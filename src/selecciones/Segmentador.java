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
    
      public void selecciones(){
        int Matriz_selecciones[][] = {{0,1,2,3,4,5,6,7,8,9},
                                      {1,0,1,1,0,0,1,1,0,1},
                                      {2,1,0,1,0,0,1,1,0,1},
                                      {3,0,1,1,0,0,1,1,0,1},
                                      {4,1,1,1,0,0,1,1,0,1},
                                      {5,1,1,1,0,0,1,1,0,1}};
           
        int x = 0,y=0;
        int Arreglo[][];
       
         // System.out.println(Matriz_selecciones.length);        
         // System.out.println(Matriz_selecciones[0].length);
        int SX = Matriz_selecciones[0].length - 1;
        int SY = Matriz_selecciones.length -1;
        Arreglo = new int[SY][SX];
        for(int i = 1;i<= SY; i++){
         //  System.out.println("Seleccion: " + Matriz_selecciones[i][y]);
            y = 0;
            Arreglo[i-1][y] = Matriz_selecciones[i][y];
                    
            for(int p = 1;p<=SX;p++){
               // System.out.println("Seleccion: " + Matriz_selecciones[0][p] + " " + "Relacion: " + Matriz_selecciones[i][p]);
                if(Matriz_selecciones[i][p] == 1){
                    y++;
                   Arreglo[i-1][y] = Matriz_selecciones[0][p];
                }
            }
        } 
        
        //  System.out.println("Filas: " + Arreglo.length);
         // System.out.println("Columnas: " + Arreglo[0].length);
        
        for(int i = 0;i < Arreglo.length;i++){
            System.out.println("Seleccion: " + Arreglo[i][x]);
            for(int k = 1; k < Arreglo[0].length;k++){
                 System.out.println("No relaciones: " + Arreglo[i][k]);
                  
            }
           
        }
       
    }
}
