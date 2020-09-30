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

    public void ingenua(int Matriz_selecciones[][]) {
      
        int TamañoX = Matriz_selecciones[0].length - 1;//Tamaño de columnas
        int TamañoY = Matriz_selecciones.length;//Tamaño filas
        int Villa = 0;//Recorre las selecciones candidatas
        int Posicion = 0;//Variable para las 
        boolean Solucion = false;
        int[][] Selecciones_Salida = new int[TamañoY][TamañoX];
        int[][] Matriz_NR = new int[TamañoY][TamañoX];
       //El for reconstruye la matriz de salida con los elementos de la que ingresa, pero solamente los de la
        //Posicion 0 hacia abajo 
        for (int i = 1; i < TamañoY; i++) {
            Selecciones_Salida[i][Villa] = Matriz_selecciones[i][Villa];      
        }
        //Instancio una funcion auxiliar que me ayudara a hallar los enemigos de las selecciones
        Segmentador s = new Segmentador();
        Comparador c = new Comparador();
        Selecciones e = new Selecciones();
        //Envio los datos y esta me devolcera una matriz asignada en la Matriz_NR
        //Donde solo estaran los enemigos de las naciones
        Matriz_NR = s.selecciones(Matriz_selecciones);
        Villa = 1;
        Posicion = 1;
        int Elemento = 0;
        int Respuesta = 0;
        int Contador = 0;
        int Contador2 = Selecciones_Salida.length - 1;
        int Cantidad = 0;
        boolean Enemigo = false;
        
        while (Contador2 > 0) {
            Selecciones_Salida[0][Villa] = Villa;
            if (Posicion >= Selecciones_Salida.length) {
                Posicion = 1;
            } else if (Posicion <= Selecciones_Salida.length) {
                Elemento = Selecciones_Salida[Posicion][0];
             //   Contador = 0;          
            }
            //For que me verifica si la seleccion a sido asignada en una villa
            for (int p = 1; p < TamañoX; p++) {
                //verifica si en la casilla existe un digito 0
                if (Selecciones_Salida[Posicion][p] == 0) {
                    //Por cada 0 el contador ira sumando
                    Contador++;
                }
            }
            //Si la villa tiene la cantidad de 0 que la matriz quiere decir que no a sido asignada
            if (Contador == TamañoX - 1) {
                //Recorre toda la matriz de salida    
                for (int i = 1; i <= TamañoY - 1; i++) {
                    //Verifica si en el la matriz hay selecciones asignadas
                    if (Selecciones_Salida[i][Villa] == 1) {
                  //Se envia los datos para comparar los enemigos                    
                        //Se pregunta si el elemento es diferente de su seleccion  
                        if (Selecciones_Salida[i][0] != Elemento) {
                            Respuesta = c.Comparador(Selecciones_Salida[i][0], Matriz_NR, Elemento);
                 //Si el elemento no esta dentro de los enemigos de la seleccion la respuesta sera un 1                
                            if (Respuesta == 1 && Enemigo == false) {
                                //Se asigna el elemento en la matriz de salida
                                Selecciones_Salida[Posicion][Villa] = 1;
                       //El contador lleva la cantidad de elemntos que no se han seleccionado
                                //Si el elemnto esta dentro de los enemigos de la seleccion la respuesta sera 2
                            } else if (Respuesta == 2) {
                                Selecciones_Salida[Posicion][Villa] = 0;
                                Enemigo = true;
                            }
                        }
                        Contador = 0;
                        //Por cada posicion en 0 dentro de la matriz sumara 1 hasta llegar a su limite   
                    }
                    if (Selecciones_Salida[i][Villa] == 0 && Cantidad <= TamañoY) {
                        Cantidad++;
                        //Si en la busqueda de selecciones asignadas todas dan 0, envie el elemento a comparar   
                    }
                    if (Cantidad == TamañoY - 1) {
                        Selecciones_Salida[Posicion][Villa] = 1;
                        Contador2 = Contador2 - 1;
                        Contador = 0;
                        Cantidad = 0;
                    }
                }
            } else {
                Contador = 0;
                Contador2 = Contador2 - 1;
            }
            //Se aumenta la posicion vertical para poder seleccionar las diferentes selecciones  
            Posicion = Posicion + 1;        
            //Se coloca la cantidad en 0 para poder realizar comparaciones despues dentro el for  
            Cantidad = 0;
            Enemigo = false;
            //Verifica si hay mas elementos que no han sido asignados
            if (Contador2 > 0 && Elemento == TamañoY - 1) {              
                Villa++;
                Posicion = 1;
                Elemento = 0;
                Contador2 = Selecciones_Salida.length - 1;           
                //Si la posicion sobre pasa el tamaño de la matriz se finalizara el bucle         
            }
            /*if (Villa >= TamañoX) {
                Solucion = true;
                //Si no hay mas elementos que asignar se procedera a terminar el bucle
            } else if (Contador2 == 0) {               
                Solucion = true;
            }*/
        }//Final While
        for (int i = 0; i < Selecciones_Salida.length; i++) {         
            for (int k = 0; k <= Villa; k++) {
                System.out.print(Selecciones_Salida[i][k] + " ");
            }
            System.out.println();
        }
    }
}
