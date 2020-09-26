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
    
    public void Dinamica(int [][] Matriz){
        
        /*int Matriz[][] = {{0,1,2,3,4,5,6,7,8,9,10},
                         {1,0,0,1,0,0,0,1,0,0,1},
                         {2,0,0,1,0,0,0,0,1,0,0},
                         {3,1,1,0,0,0,0,0,0,1,1},
                         {4,0,0,0,0,0,1,1,1,0,1},
                         {5,0,0,0,0,0,0,0,0,0,1},
                         {6,0,0,0,1,0,0,0,0,0,1},
                         {7,1,0,0,1,0,0,0,0,0,0},
                         {8,0,1,0,1,0,0,0,0,0,1},
                         {9,0,0,1,0,0,0,0,0,0,1},
                         {10,1,0,1,1,1,1,0,1,1,0}};*/
        
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
         
        /*  for(int i = 0;i < Matriz_Pesos.length;i++){
            //System.out.println("Seleccion: " + Selecciones_Salida[i][Posicion_1]);
            for(int k = 0; k < Matriz_Pesos[0].length;k++){
                 System.out.print(Matriz_Pesos[i][k]+" ");            
            }
           System.out.println();
        } */
         
         
        Combinador(Matriz_Enemigos, Matriz_Pesos, Matriz_Salida);
    }
    
    public int[][]Combinador(int[][]Matriz_E,int[][]Matriz_P,int[][]Matriz_S){
        
        int TamañoX = Matriz_S[0].length; //Tamaño para crear las matrices de forma horizontal o las columnas
        int TamañoY = Matriz_S.length; //Tamaño para crear las matrices de forma vertical o filas
        int Posicion_1 = 1,Posicion_2 =0,Posicion_3 = 0,Posicion_4 = 0, //Posicion 1: Elemento; Posicion 2: Combinaciones;Posicion 3: No asignados
            Contador = 0,Contador2 = Matriz_S.length - 1,Elemento = 0,Respuesta = 0; //Contador: Para saber si la seleccion fue asignada;Contador 2:No asignadas
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
                   // System.out.println("Seleccion: " + Combinaciones[Posicion_2][i] + " Elemento: " + Elemento); 
                    //Usamos la funcion Comparador para verificar si el elemento no es enemiga de las otras selecciones ya asignadas
                    //Para no comparar la seleccion entre ella misma, verificamos que no sean iguales
                    
                        Respuesta = c.Comparador(Combinaciones[Posicion_2][i], Matriz_E, Elemento);
                       //System.out.println("Respuesta: " + Respuesta);
                    
                    
                    //Si la respuesta es 1, sera por que no es enemiga y se procedera a buscar una posicion para asignarlo
                    if(Respuesta == 1 && Enemigo == false){
                        //Verificamos si la seleccion escogida no es igual al elemento
                        if(Combinaciones[Posicion_2][i] != Elemento){
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
                    //Si el elemento es igual a la seleccion, cambios la varible a true, para indicar que esta asignada    
                    }else{
                            Asignado = true;
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
                        //Para evitar hacer combinaciones con "id" repetidos en la tabla combinaciones hacemos
                        //Las verificaciones que eviten la repeticion en el arreglo de no asignados
                        //Tanto que no se repitan en el arreglo,como el de agregar elementos a los que ya se le asignos valores en "Datos"
                        boolean esta_elemento = false;
                        //Recorremos el arreglo de no asignados
                        for(int s=0;s<No_Asignadas.length;s++){
                            //Verificamos si el elemento ya fue asignado antes
                            //Si ya esta dentro del arreglo la variable "esta elemento" pasa true
                            if(No_Asignadas[s]== Elemento){
                               esta_elemento = true;
                            }
                            //Si el ellemento no esta asignado,ya que la variable no esta en true
                            //Lo asignamos al arreglo
                            if(No_Asignadas[s] == 0 && esta_elemento == false){
                                //Recorremos la matriz datos, para saber si el elemento no a sido ya asignado junto a sus valores
                                for(int n=0;n<Datos.length;n++){
                                    //Si ya fue asignado, la variable pasa a true
                                    if(Datos[n][0] == Elemento){
                                        esta_elemento = true;
                                    }
                                    //Sino a sido asignado, se procedera a agregarlo en el arreglo
                                    if(esta_elemento != true){
                                         No_Asignadas[s] = Elemento; //Agregando elemento en una posicion con valor 0
                                         esta_elemento = true;//Cambiamos para true, para indicar que ya fue asignado
                                    }
                                }
                            }
                        }
                         
                        Enemigo = true;//Al verificar un elemento, en la funcion auxiliar y si la respuesta es "2" se indica true
                                       //Ya que indica enemigo de alguna de la combinacion
                        esta_elemento = false;//Se reinicia la variable, en caso que se halla cambiado a true
                       
                    }
                 }
                 //Si la posicion en la combinacion es cero
                 //Y para evitar que se sobreescriba esta la varible Asignado
                 if(Combinaciones[Posicion_2][i] == 0 && Asignado == false){
                     //Si el al iniciar la asignacion, el elemento no a sido, catalogado como enemigo de otra seleccion
                     if(Enemigo != true){
                         //Se procede a asignarlo en la posicion con valor 0
                         Combinaciones[Posicion_2][i] = Elemento;
                         //Si es el primer elemento de las combinaciones
                         //Se asignara como el elemento que identificara a la combinacion, en la matriz datos
                             if(Datos[Posicion_4][0] == 0){
                                 //Asignamos el elemento a la tabla datos
                                 Datos[Posicion_4][0] = Elemento;
                                 //Recorremos la matriz pesos, a donde este el peso total que tiene la seleccion a asignar
                                 //Al encontrarlo procedemos a sumar el elemento, a la campo de total de selecciones
                                for(int d=0;d<Matriz_P.length;d++){
                                  if(Matriz_P[d][0] == Elemento){
                                    Datos[Posicion_4][1] =  Datos[Posicion_4][1] + 1;
                                    Datos[Posicion_4][2] =  Datos[Posicion_4][2] + Matriz_P[d][1];
                                  }
                                }
                                 
                             }  
                     }
                     
                     Asignado = true;//Para evitar repeteciones o sobreinscripciones en la matriz combinaciones
                 }
             }
             Contador = 0;//Para volver a reiniciar la varible
             
         } else {
             Contador = 0;//En caso que la seleccion halla sido asignada a una villa, se reinicia la variable, para verificar otra seleccion
             Contador2 = Contador2 - 1;
         }
         
           System.out.println("Contador 2: " + Contador2);
            
           /* for(int i = 0;i<No_Asignadas.length;i++){
                System.out.println("No Asignadas: " + No_Asignadas[i]);
            }*/
        /* if(Contador2 > 0){
             
             Combinaciones[]
         }*/
          //  System.out.println("Valor Posicion 1: " + Posicion_1);
         //Verificamos si La variable Posicion 1, llego hasta el limite total de selecciones
         if(Posicion_1 == Matriz_S.length-1){
          //   System.out.println("Entrando al if" + "Posicion 3: " +Posicion_3);
             //Verificamos si la varible no excede el limite del arreglo
             if(Posicion_3 < No_Asignadas.length){
                 //Verificamos si en la poscion hay un elemento diferente a 0
                 if(No_Asignadas[Posicion_3] != 0){
                    Posicion_2 = Posicion_2 + 1; //Combinaciones en vertical
                    Posicion_4 = Posicion_4 + 1;//Datos  
                    Combinaciones[Posicion_2][0] = No_Asignadas[Posicion_3];    
                    Datos[Posicion_4][0] = No_Asignadas[Posicion_3];

                    for(int d=0;d<Matriz_P.length;d++){
                                 //Encontramos el elemento  
                                 if(Matriz_P[d][0] == No_Asignadas[Posicion_3]){
                                    Datos[Posicion_4][1] =  Datos[Posicion_4][1] + 1; //Sumamos la seleccion en la tabla datos
                                    Datos[Posicion_4][2] =  Datos[Posicion_4][2] + Matriz_P[d][1]; //Sumamos el peso en la tabla datos
                                 }
                            }
                   
                    Posicion_1 = 0;
                    Posicion_3 = Posicion_3 + 1;
                  }
                }
         }    
         Posicion_1 = Posicion_1 + 1;//Aummenta la variable para recorrer todos los elementos de la matriz de salida;
         Asignado = false;//Se reinicia la variable a su estado normal
         Enemigo = false;//Se reinicia la variable a su estado normal
         
        if(Posicion_1 == Matriz_S.length){
                 
            No_Asignadas = Seleccionador(Datos, Combinaciones);
            
                Posicion_3 = 0;
                for(int k=0;k<No_Asignadas.length;k++){
                    System.out.println("Seleccion " + No_Asignadas[k]);
                    if(No_Asignadas[k] != 0){
                        Posicion_3 = Posicion_3 + 1;  
                    }
                }
                Contador2 = Contador2 - Posicion_3;
                System.out.println("Posicion 3 " + Posicion_3);
                System.out.println("Contador 4: " + Contador2);
            }
         
         //Si no mas combinaciones por hacer y la varible llego a su estado final, se cierra el while
         if(Posicion_1 == Matriz_S.length){
             Solucion = true;//Se cambia a true para poder cerrar el while
         }
         
         
         
        }
        
         for(int i = 0;i < Combinaciones.length;i++){
            //System.out.println("Seleccion: " + Selecciones_Salida[i][Posicion_1]);
            for(int k = 0; k < Combinaciones[0].length;k++){
                 System.out.print(Combinaciones[i][k]+" ");            
            }
           System.out.println();
        }
         
        System.out.println("--------------------------------------------------------------------");
        System.out.println();
        
        for(int i = 0;i < Datos.length;i++){
            //System.out.println("Seleccion: " + Selecciones_Salida[i][Posicion_1]);
            for(int k = 0; k < Datos[0].length;k++){
                 System.out.print(Datos[i][k]+" ");            
            }
           System.out.println();
        } 
        
        
        
        return Matriz_E;
    }
    
    public int[] Seleccionador(int[][]Datos,int[][]Combinaciones){
        int Identificador = Datos[0][0];
        int T_Selecciones = Datos[0][1];
        int T_Peso = Datos[0][2];
        int Tamaño = Combinaciones[0].length;
        int[] Combinacion = new int[Tamaño];
        
        System.out.println("Identificador " + Identificador + " Cantida Selecciones " + T_Selecciones + " Total Peso " + T_Peso);
        
        for(int i=0;i<Datos.length;i++){
            if(Datos[i][1] > T_Selecciones){
                if(Datos[i][2] > T_Peso){
                    Identificador = Datos[i][0];
                }
            }
            if(Datos[i][1] == T_Selecciones){
                if(Datos[i][2] > T_Peso){
                    Identificador = Datos[i][0];
                }
            }
            if(Datos[i][1] > T_Selecciones){
                if(Datos[i][2] == T_Peso){
                    Identificador = Datos[i][0];
                }
            }
        }
        
         System.out.println("Identificador " + Identificador + " Cantida Selecciones " + T_Selecciones + " Total Peso " + T_Peso);
        
        for(int n=0;n<Combinaciones.length;n++){
            if(Combinaciones[n][0] == Identificador){
                for(int e=0;e<Combinaciones[0].length;e++){
                    Combinacion[e] =  Combinaciones[n][e];
                }
            }
        }
        
        return Combinacion;
    }
    
}
