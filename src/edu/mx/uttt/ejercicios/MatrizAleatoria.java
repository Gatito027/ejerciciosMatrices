/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.uttt.ejercicios;

/**
 *
 * @author Donyo
 */
public class MatrizAleatoria {
    private int fila;
    private int columna;
    private int [][] matriz;
    
    public MatrizAleatoria(int fila, int columna) {
        if (validarMAleatoria(fila, columna)) {
            this.fila=fila;
            this.columna=columna;
        }else{
            this.fila = fila;
            this.columna = columna + 1;
        }
        matriz= new int [fila][columna];
    }
    
    private boolean validarMAleatoria(int fila, int columna){
        return fila != columna;
    }
    
    public void llenarMatrizAleatoria(int max, int min){
        for (int i = 0; i < matriz.length; i++) {
            int j=0;
            for (j = 0; j < matriz[0].length; j++) {
                matriz[i][j]=(int) (Math.random()*((max-min)+1))+min;
            }
        }
    }
    
    public String imprimir(){
        String cadena="";
        for (int i = 0; i < matriz.length; i++) {
            for (int j=0; j < matriz[0].length; j++) {
                cadena+= matriz[i][j] + " ";
            }
            cadena+="\n";
        }
        return cadena;
    }
}
