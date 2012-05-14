//**********************************************************
// FUNDAMENTOS DE ANÁLISIS Y DISEÑO DE ALGORITMOS
// MINIPROYECTO 1: SOLUCIÓN PARA UN JUEGO DE LÓGICA: AKARI
//
// ARCHIVO: AkariFile.java
//
// FECHA: 12/05/14
//
// AUTORES:
//     Marx Arturo Arias - 0840247-3743
//     marxarturoariasescobar@gmail.com
//
//     Luis Jeferson Gallardo - 
//     luisjhefeerson@gmail.com
//
//     Fidel Herney Palacios - 0832691-3743
//     herney400@gmail.com
//
//     James Andrés Payan - 0957150-2711
//     jamespayan@gmail.com
//
//     Gustavo Adolfo Rodriguez - 0932979-3743
//     gustalibreros@gmail.com
//
// ESCUELA DE INGENIERIA DE SISTEMAS Y COMPUTACION
// UNIVERSIDAD DEL VALLE
//**********************************************************



package datos;

//~--- JDK imports ------------------------------------------------------------

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AkariFile {
    private String  fileContents   = null;
    private int     numeoFilas     = 0;
    private int     numeroColumnas = 0;
    private int[][] tablero        = null;

    public AkariFile() {}

    public AkariFile(int numeoFilas, int numeroColumnas, int[][] tablero) {
        this.numeoFilas     = numeoFilas;
        this.numeroColumnas = numeroColumnas;
        this.tablero        = tablero;
    }

    public String getFileContents() {
        return fileContents;
    }

    public void setFileContents(String fileContents) {
        this.fileContents = fileContents;
    }

    public boolean loadFromFile(String fileName) {
        return true;
    }

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public int getNumeroColumnas() {
        return numeroColumnas;
    }

    public void setNumeroColumnas(int numeroColumnas) {
        this.numeroColumnas = numeroColumnas;
    }

    public int getNumeoFilas() {
        return numeoFilas;
    }

    public void setNumeoFilas(int numeoFilas) {
        this.numeoFilas = numeoFilas;
    }

    public boolean loadFromFile(File selectedFile) {
        BufferedReader datos = null;
        String         lectura;

        try {
            datos = new BufferedReader(new FileReader(selectedFile));

            StringBuffer bufer = new StringBuffer();

            while ((lectura = datos.readLine()) != null) {
                bufer.append(lectura + "\n");
            }

            fileContents = bufer.toString();

            return true;
        } catch (IOException ex) {
            System.out.println(ex.toString());

            return false;
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
