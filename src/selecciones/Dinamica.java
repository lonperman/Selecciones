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
public class Dinamica {
    
    public void Dinamica(){
        
        int Matriz[][] = {{0,1,2,3,4,5,6,7,8,9,10},
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
        
        int y = Matriz.length, x = Matriz[0].length;
        int[][] Matriz_Enemigos = new int[y-1][x-1];
        int[][] Matriz_Pesos = new int[y-1][2];
        int[][] Matriz_Salida = new int[y][x];
        
        Segmentador s = new Segmentador();
        Contador_Peso c = new Contador_Peso();
        
        Matriz_Enemigos = s.selecciones(Matriz);
        Matriz_Pesos = c.Contador_Peso(Matriz_Enemigos);
        
         for(int i = 1;i<y; i++){
             Matriz_Salida[i][0] = Matriz[i][0];
           
        }
         
          for(int i = 0;i < Matriz_Pesos.length;i++){
            //System.out.println("Seleccion: " + Selecciones_Salida[i][Posicion_1]);
            for(int k = 0; k < Matriz_Pesos[0].length;k++){
                 System.out.print(Matriz_Pesos[i][k]+" ");            
            }
           System.out.println();
        } 
         
         
        Combinador(Matriz_Enemigos, Matriz_Pesos, Matriz_Salida);
    }
    
    public int[][]Combinador(int[][]Matriz_E,int[][]Matriz_P,int[][]Matriz_S){
        
        int TamañoX = Matriz_S[0].length; //Tamaño para crear las matrices de forma horizontal o las columnas
        int TamañoY = Matriz_S.length; //Tamaño para crear las matrices de forma vertical o filas
        int Posicion_1 = 1,Posicion_2 =0,Posicion_3 = 0,Posicion_4 = 0, //Posicion 1: Elemento; Posicion 2: Combinaciones;Posicion 3: No asignados
            Contador = 0,Contador2 = 0,Elemento = 0,Respuesta = 0; //Contador: Para saber si la seleccion fue asignada;Contador 2:No asignadas
            //Posicion 4:Datos ;Elemento: Seleccion para asignar; Respuesta: Verificacion de si es amiga o enemiga
        boolean Solucion = false,Enemigo = false,Asignado = false; //Solucion: Para cerrar el ciclo while; Enemigo: Para saber si el elemnto
        //Es enemiga de otra seleccion que no sea la primera; Asignado: Para evitar la asignacion continua en el for
        int[]No_Asignadas = new int[TamañoX]; //Selecciones no asignadas por ser enemigas
        int[][]Combinaciones = new int[TamañoY][TamañoX]; //Matriz donde se hacen combinciones con todas las selecciones enemigas
        int[][] Datos = new int[TamañoY][3]; //Matriz usada para guardar los datos sobre peso y cantidad de selecciones en las combinaciones
        Comparador c = new Comparador();
        
        
        while(!Solucion){
            
            if(Posicion_1 <= TamañoY){
            Elemento = Matriz_S[Posicion_1][0]; 
         }
        
         for(int p = 1;p<TamañoX;p++){
                //verifica si en la casilla existe un digito 0
                if(Matriz_S[Posicion_1][p] == 0){
                    //Por cada 0 el contador ira sumando
                    Contador++;
                }
            }
            
         
         if(Contador == TamañoX-1){
            //For que recorre las matriz de combinaciones
             for(int i=0;i<Combinaciones[0].length;i++){
                 //Pregunta si la las posiciones ya tiene elementos asignados
                 if(Combinaciones[Posicion_2][i] != 0){
                    System.out.println("Seleccion: " + Combinaciones[Posicion_2][i] + " Elemento: " + Elemento); 
                    //Usamos la funcion Comparador para verificar si el elemento no es enemiga de las otras selecciones ya asignadas
                    Respuesta = c.Comparador(Combinaciones[Posicion_2][i], Matriz_E, Elemento);
                    System.out.println("Respuesta: " + Respuesta);
                    //Si la respuesta es 1, sera por que no es enemiga y se procedera a buscar una posicion para asignarlo
                    if(Respuesta == 1 && Enemigo == false){
                        //Recorre la matriz para hallar una posicion con 0
                        for(int k=0;k<Combinaciones[0].length;k++){
                         //Al encontrar la posicion en 0 lo  asignamos el elemento   
                         if(Combinaciones[Posicion_2][k] == 0 && Asignado == false){
                            Combinaciones[Posicion_2][k] = Elemento; //Asignacion dentro de la matriz
                            Asignado = true; //Para evitar la reasignacion
                            //Elemento asignado se debe contar y agregar el peso para comparar despues
                            for(int d=0;d<Matriz_P.length;d++){
                                //Si encontramos el lemento dentro de la matriz peso
                                if(Matriz_P[d][0] == Elemento){
                                    Datos[Posicion_4][1] =  Datos[Posicion_4][1] + 1; //Sumamos la seleccion
                                    Datos[Posicion_4][2] =  Datos[Posicion_4][2] + Matriz_P[d][1];//Sumamos el peso
                                }
                            }
                            
                         }
                       }
                    }
                    //Si el elemento es enemigo de las selecciones de la combinacion
                    if(Respuesta == 2 && Enemigo == false){
                        //Buscamos dentro de la combinacion si fue asignado de no a ver sido antes enemigo de una seleccion
                        //Pero despues en otra ya asignada si encontramos la relacion negativa
                        for(int p=0;p<Combinaciones[0].length;p++){
                         //Buscamos en combinaciones el elemnto a eliminar   
                         if(Combinaciones[Posicion_2][p] == Elemento){
                            //Al encontrar lo definimos como 0 para que el espacio sea usado por otra seleccion
                            Combinaciones[Posicion_2][p] = 0;
                             //Recorremos la matriz de pesos
                              for(int d=0;d<Matriz_P.length;d++){
                                 //Encontramos el elemento  
                                 if(Matriz_P[d][0] == Elemento){
                                    Datos[Posicion_4][1] =  Datos[Posicion_4][1] - 1; //Lo eliminamos de la sumatoria
                                    Datos[Posicion_4][2] =  Datos[Posicion_4][2] - Matriz_P[d][1]; //Eliminamos el peso de la sumatoria
                                 }
                            }
                          }
                        }
                        
                         
                        Enemigo = true;
                        Posicion_3 = Contador2;
                        No_Asignadas[Posicion_3] = Elemento;
                        Contador2= Contador2 + 1;
                    }
                 }
                 if(Combinaciones[Posicion_2][i] == 0 && Asignado == false){
                     if(Enemigo != true){
                         Combinaciones[Posicion_2][i] = Elemento;
                             if(Datos[Posicion_4][0] == 0){
                                 Datos[Posicion_4][0] = Elemento;
                                for(int d=0;d<Matriz_P.length;d++){
                                  if(Matriz_P[d][0] == Elemento){
                                    Datos[Posicion_4][1] =  Datos[Posicion_4][1] + 1;
                                    Datos[Posicion_4][2] =  Datos[Posicion_4][2] + Matriz_P[d][1];
                                  }
                                }
                                 
                             }
                         
                     }
                     
                     Asignado = true;
                 }
             }
             Contador = 0;
             
         } else {
             Contador = 0;
         }
         
            System.out.println("Contador 2: " + Contador2);
            
            for(int i = 0;i<No_Asignadas.length;i++){
                System.out.println("No Asignadas: " + No_Asignadas[i]);
            }
        /* if(Contador2 > 0){
             
             Combinaciones[]
         }*/
         
         Posicion_1 = Posicion_1 + 1;
         Asignado = false;
         Enemigo = false;
         
         if(Posicion_1 == Matriz_S.length){
             Solucion = true;
         }
         
        }
        
         for(int i = 0;i < Combinaciones.length;i++){
            //System.out.println("Seleccion: " + Selecciones_Salida[i][Posicion_1]);
            for(int k = 0; k < Combinaciones[0].length;k++){
                 System.out.print(Combinaciones[i][k]+" ");            
            }
           System.out.println();
        }
         
        for(int i = 0;i < Datos.length;i++){
            //System.out.println("Seleccion: " + Selecciones_Salida[i][Posicion_1]);
            for(int k = 0; k < Datos[0].length;k++){
                 System.out.print(Datos[i][k]+" ");            
            }
           System.out.println();
        } 
        
        
        
        return Matriz_E;
    }
    
}
