/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.uttt.ejercicios;

import javax.swing.JOptionPane;

/**
 *
 * @author Donyo
 */
public class MatrizCuadrada {

    private int fila;
    private int columna;
    private int[][] matriz;

    public void setMatriz(int[][] arr) {
        this.matriz = arr;
    }

    public MatrizCuadrada(int fila, int columna) {
        if (validarMCuadrada(fila, columna)) {
            this.fila = fila;
            this.columna = columna;
        } else {
            this.fila = this.columna = fila;
        }
        matriz = new int[fila][columna];
    }

    private boolean validarMCuadrada(int fila, int columna) {
        return fila == columna;
    }

    public void llenarMatriz(int max, int min) {
        for (int i = 0; i < matriz.length; i++) {
            int j = 0;
            for (j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = (int) (Math.random() * ((max - min) + 1)) + min;
            }
        }
    }

    public String imprimir() {
        String cadena = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                cadena += matriz[i][j] + " ";
            }
            cadena += "\n";
        }
        return cadena;
    }

    public void llenarMatrizSecuencial() {
        int aux = 1;
        for (int i = 0; i < matriz.length; i++) {
            int j = 0;
            for (j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = aux;
                aux++;
            }
        }
    }

    public boolean validarN(String n) {
        try {
            Integer.parseInt(n);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("[Error] " + e);
            return false;
        }

    }

    public int[][] solicitarValoresMatriz(int tam) {
        int arr[][] = new int[tam][tam];
        String valor;
        int fila = 0;
        while (fila < arr.length) {
            for (int columna = 0; columna < arr.length; columna++) {
                do {
                    valor = JOptionPane.showInputDialog("Introduce el valor de la posición ["
                            + fila + "] [" + columna + "]");
                } while (!validarN(valor));
                arr[fila][columna] = Integer.parseInt(valor);
            }
            fila++;
        }
        return arr;
    }

    public int sumaFila() {
        String fila;
        int fila2;
        do {
            do {
                fila = JOptionPane.showInputDialog("Introduce una fila:");
            } while (!(validarN(fila)));
            fila2 = Integer.parseInt(fila);
        } while (fila2 > 4 && fila2 < -1);
        int suma = 0;
        for (int j = 0; j < matriz[0].length; j++) {
            suma += matriz[fila2][j];
        }
        return suma;
    }
    
    public int sumaColumna() {
        String fila;
        int fila2;
        do {
            do {
                fila = JOptionPane.showInputDialog("Introduce una fila:");
            } while (!(validarN(fila)));
            fila2 = Integer.parseInt(fila);
        } while (fila2 > 4 && fila2 < -1);
        int suma = 0;
        for (int j = 0; j < matriz[0].length; j++) {
            suma += matriz[j][fila2];
        }
        return suma;
    }
    
    public int sumaDiagonal() {
        int suma = 0;
        for (int j = 0; j < matriz[0].length; j++) {
            suma += matriz[j][j];
        }
        return suma;
    }
    
    public int sumaDiagonalInversa() {
        int suma = 0, aux=3;
        for (int j = 0; j < matriz[0].length; j++) {
            suma += matriz[j][aux];
            aux--;
        }
        return suma;
    }
    
    public int sumaMatriz() {
        int fila = 0, suma = 0;
        do {
            int columna = 0;
            while (columna < matriz[fila].length) {
                suma += matriz[fila][columna];
                columna++;
            }
            fila++;
        } while (fila < matriz.length);
        return suma;
    }
    
    public int obtenerTamanioMatriz() {
        return matriz.length * matriz[0].length;
    }

    public double media() {
        return sumaMatriz() / (obtenerTamanioMatriz() * 1.0);
    }

}
