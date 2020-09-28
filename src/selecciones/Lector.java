/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selecciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Lector {

    int num_vert = 30;
    int[][] matriz = new int[num_vert][num_vert];
    String Ruta_Matriz = " ";

    public Lector(String Ruta_Matriz) {
        this.Ruta_Matriz = Ruta_Matriz;
    }

    public int[][] generarMatriz() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            archivo = new File(this.Ruta_Matriz);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String temp = "";
            String linea;

            int ln = 0;
            while ((linea = br.readLine()) != null) {
                temp = temp + linea;
                String elementos[] = linea.split(" ");
                for (int j = 0; j < elementos.length; j++) {
                    matriz[ln][j] = Integer.parseInt(elementos[j]);
                }
                ln++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matriz;

    }

}
