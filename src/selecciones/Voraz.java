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
    public void Voraz(){
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
        
        int Tamaño= Matriz.length;
        int Matriz_Peso[][]=new int[Tamaño][2];
        Contador_Peso c = new Contador_Peso();
        Matriz_Peso= c.Contador_Peso(Matriz);
        
        int Primer_variable= Matriz_Peso[1][0];
      //  System.out.println("Seleccion "+Primer_variable);
        
        int Segunda_variable=Matriz_Peso[1][1];
       // System.out.println("Peso "+Segunda_variable);
        
        int Posicion_1=1;
        int TamañoY = Matriz.length;
        //Variable de filas
        
        int TamañoX= Matriz[0].length;
        //Variable de columnas
        
        int Elemento=0,Respuesta = 0, Contador = 0,Posicion_P =0,Villa = 1;
        //Seleccion de candidatos de la villa
        
        int[][] Matriz_S = new int[TamañoY][TamañoX];
        //Matriz de salida 
        
        Comparador c1 = new Comparador();
        
        int[][] Matriz_Enemigos = new int[TamañoY][TamañoX];
        
        Segmentador s1 = new Segmentador();
        
        Matriz_Enemigos= s1.selecciones(Matriz);
        
        
        boolean Candidato_Asignado = false,Solucion = false, Enemigo = false;
        
        int Pendientes = TamañoY-1; 
        
        
        
        
        
        for(int i=1;i<Matriz_S.length;i++){
             Matriz_S[i][0] = Matriz[i][0];
        } //Reconstruir la matriz de salida
        
        /*  for(int i = 0;i < Matriz_S.length;i++){
            //System.out.println("Seleccion: " + Selecciones_Salida[i][Posicion_1]);
            for(int k = 0; k < Matriz_S[0].length;k++){
                 System.out.print(Matriz_S[i][k]+" ");            
            }
           System.out.println();
        }*/
    while(!Solucion){  
        
        for (int i=1; i< Matriz_Peso.length;i++){
            if (Matriz_Peso[i][1]>Segunda_variable && Candidato_Asignado == false){
                Primer_variable=Matriz_Peso[i][0];
                Segunda_variable=Matriz_Peso[i][1];
                Posicion_P = i;
                
            }
            if(i>Matriz_Peso.length) {
               Matriz_Peso[Posicion_P][1]=0;
               Candidato_Asignado = true;
            }
            
        }
       // System.out.println("Seleccion "+Primer_variable+" Peso_Final  "+Segunda_variable);
       // System.out.println("Pendientes " + Pendientes);
        
        for(int i=1; i<Matriz_S.length; i++){
            if(Matriz_S[i][0]==Primer_variable){
                Matriz_S[i][Villa]=1;
               
            }
        }
        
         if(Posicion_1 <= TamañoY-1){
            Elemento = Matriz_S[Posicion_1][0]; 
         }
         if(Posicion_1 > TamañoY-1){
             Posicion_1 = 1;
         }
         
         for(int p = 1;p<TamañoX;p++){
                //verifica si en la casilla existe un digito 0
                if(Matriz_S[Posicion_1][p] == 0){
                    //Por cada 0 el contador ira sumando
                    Contador++;
                }
       
                    
                   
             
        }
         if(Contador==TamañoX-1){
            for(int i=1;i<Matriz_S.length;i++){
                if(Matriz_S[i][Villa]==1){
                   System.out.println("Seleccion " + Matriz_S[i][0] + " Elemento "+ Elemento); 
                   Respuesta = c1.Comparador(Matriz_S[i][0], Matriz_Enemigos, Elemento);
                    System.out.println("Valor Respuesta "+Respuesta);
                   
                    if(Respuesta == 1 && Enemigo == false){
                        for(int p=0;p<Matriz_S.length;p++){
                            if(Elemento == Matriz_S[p][0]){
                                Matriz_S[p][Villa] = 1;
                              //  System.out.println("Seleccion " + Elemento + " Posicion Y " + p + " Posicion X "+ Villa);
                            }
                        }
                    }
                    if(Respuesta == 2){
                        for(int p=0;p<Matriz_S.length;p++){
                            if(Elemento == Matriz_S[p][0]){
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
         
       
        for(int p = 1;p<Matriz_S.length;p++){
            if(Matriz_S[p][Villa]==1){ 
                for(int i=0;i<Matriz_Peso.length;i++){
                    if(Matriz_S[p][0] == Matriz_Peso[i][0]){
                        Matriz_Peso[i][1] = 0;
                        
                    }
                }
            }
           /* if(Matriz_S[p][Villa]==0){
                Pendientes++;
                System.out.println("Pendientes " + Pendientes);
            }*/
        }
        
        Posicion_1 = Posicion_1 + 1;
        Enemigo = false;
       
        
        
        if(Villa < TamañoX-1 && Posicion_1 == TamañoY-1){
         //   System.out.println("Entrando al if");
            Villa = Villa + 1;
            Matriz_S[0][Villa] = Villa;
            Candidato_Asignado = false;
            Posicion_1 = 1;
            Primer_variable = 0;
            Segunda_variable = 0;
            Pendientes = TamañoY-1;
            
        }
        if(Pendientes == 0 ){
            Solucion = true;
        }
        
       
       
    }
         for(int i = 0;i < Matriz_S.length;i++){
            //System.out.println("Seleccion: " + Selecciones_Salida[i][Posicion_1]);
            for(int k = 0; k < Matriz_S[0].length;k++){
                 System.out.print(Matriz_S[i][k]+" ");            
            }
           System.out.println();
        }
         
    }
}
