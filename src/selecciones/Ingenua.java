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
    
        int Matriz_selecciones[][] = {{0,1,2,3,4,5,6,7,8,9,10},
                                      {1,0,0,1,0,0,0,1,0,0,1},
                                      {2,0,0,1,0,0,0,0,1,0,0},
                                      {3,1,1,0,0,0,0,0,0,1,1},
                                      {4,0,0,0,0,0,1,1,1,0,1},
                                      {5,0,0,0,0,0,0,0,0,0,1},
                                      {6,0,0,0,1,0,0,0,0,0,1},
                                      {7,1,0,0,1,0,0,0,0,0,0},
                                      {8,0,1,0,1,0,0,0,0,0,1},
                                      {9,0,0,1,0,0,0,0,0,0,1},
                                      {10,1,0,1,1,1,1,0,1,1,0}};
        
        int TamañoX = Matriz_selecciones[0].length-1;
        int TamañoY = Matriz_selecciones.length;
        int Posicion_1 = 0;
        int Posicion_2 = 0;
        boolean Solucion = false;
        int [][]Selecciones_Salida = new int[TamañoY][TamañoX];
        int [][]Matriz_NR = new int[TamañoY][TamañoX];
      
       //El for reconstruye la matriz de salida con los elementos de la que ingresa, pero solamente los de la
       //Posicion 0 hacia abajo 
        for(int i = 1;i<TamañoY; i++){
             Selecciones_Salida[i][Posicion_1] = Matriz_selecciones[i][Posicion_1];
            // System.out.println("Seleccion Guardada: " + Selecciones_Salida[i][Posicion_1]);
        }
        //Instancio una funcion auxiliar que me ayudara a hallar los enemigos de las selecciones
        Segmentador s = new Segmentador();
        //Envio los datos y esta me devolcera una matriz asignada en la Matriz_NR
        //Donde solo estaran los enemigos de las naciones
        Matriz_NR = s.selecciones(Matriz_selecciones);
        
        Posicion_1 = 1;
        Posicion_2 = 1;
        int Elemento= 0;
        int Respuesta = 0;
        int Contador = 0 ;
        int Contador2 = Selecciones_Salida.length - 1;
        int Cantidad = 0;
        boolean Enemigo = false;
        //Comparador(1, Matriz_NR, 2);
        while(!Solucion){
         
            Selecciones_Salida[0][Posicion_1] = Posicion_1;
            if(Posicion_2 >= Selecciones_Salida.length){       
             Posicion_2 = 1;
            }else if(Posicion_2 <= Selecciones_Salida.length) {
                Elemento = Selecciones_Salida[Posicion_2][0];
             //   Contador = 0;
             //  System.out.println("Elemento Seleccionado: " + Elemento);
                
            }
           //For que me verifica si la seleccion a sido asignada en una villa
            for(int p = 1;p<TamañoX;p++){
                //verifica si en la casilla existe un digito 0
                if(Selecciones_Salida[Posicion_2][p] == 0){
                    //Por cada 0 el contador ira sumando
                    Contador++;
                }
            }
            //System.out.println("Tamaño Contador: " + Contador);
            //Si la villa tiene la cantidad de 0 que la matriz quiere decir que no a sido asignada
            if(Contador == TamañoX-1){
            //Recorre toda la matriz de salida    
            for(int i=1;i<=TamañoY-1;i++){
             //Verifica si en el la matriz hay selecciones asignadas
                if(Selecciones_Salida[i][Posicion_1] == 1){
                  //Se envia los datos para comparar los enemigos
                  //  System.out.println("Seleccion: " + Selecciones_Salida[i][0]+ " Elemento: " + Elemento);
                  //Se pregunta si el elemento es diferente de su seleccion  
                   if(Selecciones_Salida[i][0] != Elemento){
                       
                      Respuesta = Comparador(Selecciones_Salida[i][0], Matriz_NR, Elemento);
                 //Si el elemento no esta dentro de los enemigos de la seleccion la respuesta sera un 1
                       //System.out.println("Respuesta: " + Respuesta);
                   if(Respuesta == 1 && Enemigo == false){
                       //Se asigna el elemento en la matriz de salida
                       Selecciones_Salida[Posicion_2][Posicion_1] = 1;
                       //El contador lleva la cantidad de elemntos que no se han seleccionado
                       
                 //Si el elemnto esta dentro de los enemigos de la seleccion la respuesta sera 2
                   } else if(Respuesta == 2) {
                      Selecciones_Salida[Posicion_2][Posicion_1] = 0;
                      Enemigo = true;
                   }
                  
                   }
                 Contador = 0;
                //Por cada posicion en 0 dentro de la matriz sumara 1 hasta llegar a su limite   
                }if(Selecciones_Salida[i][Posicion_1] == 0 && Cantidad <=TamañoY){ 
                   Cantidad++;
                //Si en la busqueda de selecciones asignadas todas dan 0, envie el elemento a comparar   
                }if(Cantidad == TamañoY-1){
                        Selecciones_Salida[Posicion_2][Posicion_1]= 1;
                        Contador2 = Contador2 - 1;
                        Contador = 0;
                        Cantidad = 0;
                  
                }
            }
            } else {
                Contador=0;
                Contador2 = Contador2-1;
            }
            
           
       //   System.out.println("Contador Final: " + Contador2);
          //Se aumenta la posicion vertical para poder seleccionar las diferentes selecciones  
            Posicion_2 = Posicion_2 + 1;
          //  System.out.println("Posicion 2: " + Posicion_2);
          //Se coloca la cantidad en 0 para poder realizar comparaciones despues dentro el for  
            Cantidad = 0;
           
            Enemigo = false;
            
         
      //Verifica si hay mas elementos que no han sido asignados
            if(Contador2 > 0 && Elemento == TamañoY-1){
            //    System.out.println("Entrando al else");
                Posicion_1++;
                Posicion_2 = 1;
                Elemento = 0;
                Contador2 = Selecciones_Salida.length - 1;
                System.out.println("Posicion 1: " + Posicion_1);
      //Si la posicion sobre pasa el tamaño de la matriz se finalizara el bucle         
            }if(Posicion_1 >= TamañoX){
                Solucion = true;
      //Si no hay mas elementos que asignar se procedera a terminar el bucle
            }else if(Contador2 == 0){
               // System.out.println("Entro al True: " + Contador2 );
                Solucion = true;
            }
        }
        
        
      
        
        
        for(int i = 0;i < Selecciones_Salida.length;i++){
            //System.out.println("Seleccion: " + Selecciones_Salida[i][Posicion_1]);
            for(int k = 0; k <= Posicion_1;k++){
                 System.out.print(Selecciones_Salida[i][k]+" ");            
            }
           System.out.println();
        }
        
        System.out.println("--------------------------------------------------------------------");
        System.out.println();
         for(int i = 0;i < Matriz_NR.length;i++){
            //System.out.println("Seleccion: " + Selecciones_Salida[i][Posicion_1]);
            for(int k = 0; k < Matriz_NR[0].length;k++){
                 System.out.print(Matriz_NR[i][k]+" ");            
            }
           System.out.println();
        }
      
     
}
    public int Comparador(int Seleccion,int [][] Matriz,int Elemento){
        int Respuesta = 0;
        int Posicion = 0;
        
              //  System.out.println("Segundo Comparador");
        //El for recorre toda la matriz hasta encontrar la seleccion
                    for(int e =0 ;e<Matriz.length;e++){
                        //Si encuentra la seleccion se procede a verificar sus enemigos
                        if(Matriz[e][Posicion] == Seleccion){
                            //El for verifica a sus enemigos de forma horizontal
                            for(int i= 1; i<Matriz[0].length;i++){
                                //se verifica si el elemento esta dentro de los enemigos de la seleccion 
                                if(Matriz[e][i] == Elemento){
                                    //Si se encuentra su respuesta sera 2
                                    Respuesta = 2;
                                //Sino se encuentra la respuesta sera 1    
                                } else if(Respuesta != 2) {
                                    Respuesta = 1;
                                }
                            }
                        } 
                    }
                
            
            
        return Respuesta;
    }




    
}



