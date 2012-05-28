//**********************************************************
// FUNDAMENTOS DE ANÁLISIS Y DISEÑO DE ALGORITMOS
// MINIPROYECTO 1: SOLUCIÓN PARA UN JUEGO DE LÓGICA: AKARI
//
// ARCHIVO: AkariFile.java
//
// FECHA: 12/05/27
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class AkariFile {
    private int[][]  Restricciones   = null;
    private int      casillasBlancas = 0;
    private int      casillasNegras  = 0;
    private String   fileContents    = null;
    private int      numeroColumnas  = 0;
    private int      numeroFilas     = 0;
    private byte[][] Tablero         = null,
                     Bombillos       = null,
                     Iluminacion     = null;

    public AkariFile() {}

    public AkariFile(int numeoFilas, int numeroColumnas, int[][] restricciones, byte[][] Tablero, byte[][] Bombillos,
                     byte[][] Iluminacion, int CasillasNegras) {
        this.numeroFilas    = numeoFilas;
        this.numeroColumnas = numeroColumnas;
        this.Restricciones  = restricciones;
        this.Bombillos      = Bombillos;
        this.Tablero        = Tablero;
        this.Iluminacion    = Iluminacion;
        this.casillasNegras = CasillasNegras;
    }

    public boolean validation() {

//      boolean valida = true;
        for (int i = 0; i < this.numeroFilas; i++) {
            for (int j = 0; j < this.numeroColumnas; j++) {
                if ((Tablero[i][j] + Iluminacion[i][j]) != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public int getCasillasBlancas() {
        return casillasBlancas;
    }

    public void setCasillasBlancas(int casillasBlancas) {
        this.casillasBlancas = casillasBlancas;
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

    public byte[][] getTablero() {
        return Tablero;
    }

    public void setTablero(byte[][] tablero) {
        this.Tablero = tablero;
    }

    public byte[][] getIluminaciion() {
        return Iluminacion;
    }

    public void setIluminacion(byte[][] iluminacion) {
        this.Iluminacion = iluminacion;
    }

    public int[][] getRestricciones() {
        return Restricciones;
    }

    public void setRestricciones(int[][] restricciones) {
        this.Restricciones = restricciones;
    }

    public byte[][] getBombillos() {
        return Bombillos;
    }

    public void setBombillos(byte[][] bombillos) {
        this.Bombillos = bombillos;
    }

    public int getNumeroColumnas() {
        return numeroColumnas;
    }

    public void setNumeroColumnas(int numeroColumnas) {
        this.numeroColumnas = numeroColumnas;
    }

    public int getNumeoFilas() {
        return numeroFilas;
    }

    public void setNumeoFilas(int numeoFilas) {
        this.numeroFilas = numeoFilas;
    }

    public int getCasillasNegras() {
        return casillasNegras;
    }

    public void setCasillasNegras(int casillasnegras) {
        this.casillasNegras = casillasnegras;
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
            procesarFileContents();

            return true;
        } catch (IOException ex) {
            System.out.println(ex.toString());

            return false;
        }
    }

    private void procesarFileContents() {
        StringTokenizer tokens   = new StringTokenizer(fileContents);
        int             contador = 0;

        while (tokens.hasMoreTokens()) {
            contador++;

            if (contador == 1) {
                String f = (String) tokens.nextToken();

                numeroFilas = Integer.parseInt(f);
            }

            if (contador == 2) {
                String c = (String) tokens.nextToken();

                numeroColumnas = Integer.parseInt(c);
            }

            if (contador == 3) {

                // tablero = new int[numeoFilas][numeroColumnas];
                Restricciones = new int[numeroFilas][numeroColumnas];
                Iluminacion   = new byte[numeroFilas][numeroColumnas];
                Tablero       = new byte[numeroFilas][numeroColumnas];
                Bombillos     = new byte[numeroFilas][numeroColumnas];

                for (int i = 0; i < Iluminacion.length; i++) {
                    for (int j = 0; j < Iluminacion[i].length; j++) {
                        Iluminacion[i][j] = 0;
                        Bombillos[i][j]   = 0;
                        Tablero[i][j]     = 0;

                        // System.out.print(Tablero[i][j]+"\t");
                    }

                    // System.out.print("\n");
                }
            }

            if (contador >= 3) {
                for (int i = 0; i < Restricciones.length; i++) {
                    for (int j = 0; j < Restricciones[i].length; j++) {
                        String valor = (String) tokens.nextToken();

                        if (valor.equals("0")) {
                            Restricciones[i][j] = 8;    // para casillas blancas sin bombillo, NO SE PUEDE COLOCAR NULL
                            Tablero[i][j]       = 0;
                        }

                        if (valor.equals("1")) {
                            Tablero[i][j]   = 0;
                            Bombillos[i][j] = 1;
                        }

                        if (valor.equals("2")) {
                            Restricciones[i][j] = 8;    // PARA CASILLAS NEGRAS SIN NUMERO, NO SE PUEDE COLOCAR NULL
                            Tablero[i][j]       = 1;
                            casillasNegras++;
                        }

                        if (valor.equals("3")) {
                            Restricciones[i][j] = 0;
                            Tablero[i][j]       = 1;
                            casillasNegras++;
                        }

                        if (valor.equals("4")) {
                            Restricciones[i][j] = 1;
                            Tablero[i][j]       = 1;
                            casillasNegras++;
                        }

                        if (valor.equals("5")) {
                            Restricciones[i][j] = 2;
                            Tablero[i][j]       = 1;
                            casillasNegras++;
                        }

                        if (valor.equals("6")) {
                            Restricciones[i][j] = 3;
                            Tablero[i][j]       = 1;
                            casillasNegras++;
                        }

                        if (valor.equals("7")) {
                            Restricciones[i][j] = 4;
                            Tablero[i][j]       = 1;
                            casillasNegras++;
                        }

                        System.out.print(Tablero[i][j] + " ");
                    }

                    System.out.print("\n");
                }
            }
        }

        casillasBlancas = (numeroFilas * numeroColumnas) - casillasNegras;
    }

    public void iluminarFila(int i, int j, int n, int m) {
        for (int x = j; x < n; x++) {
            if (Tablero[i][x] == 0) {
                Iluminacion[i][x] = 1;
            } else {
                break;
            }
        }

        for (int x = j; x >= 0; x--) {
            if (Tablero[i][x] == 0) {
                Iluminacion[i][x] = 1;
            } else {
                break;
            }
        }
    }

    public void iluminarColumna(int i, int j, int m) {
        for (int y = i; y < m; y++) {
            if (Tablero[y][j] == 0) {
                Iluminacion[y][j] = 1;
            } else {
                break;
            }
        }

        for (int y = i; y >= 0; y--) {
            if (Tablero[y][j] == 0) {
                Iluminacion[y][j] = 1;
            } else {
                break;
            }
        }
    }

    public boolean ponerBombillo(int fila, int columna) {
        int m = numeroFilas;
        int n = numeroColumnas;

        if ((Tablero[fila][columna] == 0) && (Iluminacion[fila][columna] == 0)) {
            Bombillos[fila][columna] = 1;
            iluminarFila(fila, columna, n, m);
            iluminarColumna(fila, columna, m);

            return true;
        } else {
            return false;
        }
    }

    public void inicializarMatriz() {
        for (int i = 0; i < numeroFilas; i++) {
            for (int j = 0; j < numeroColumnas; j++) {
                Bombillos[i][j]   = 0;
                Iluminacion[i][j] = 0;
            }
        }
    }
}