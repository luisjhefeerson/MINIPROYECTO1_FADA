//**********************************************************
// FUNDAMENTOS DE ANÁLISIS Y DISEÑO DE ALGORITMOS
// MINIPROYECTO 1: SOLUCIÓN PARA UN JUEGO DE LÓGICA: AKARI
//
// ARCHIVO: AkariGame.java
//
// FECHA: 12/05/28
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

import java.util.StringTokenizer;

/**
 * Class description
 *
 *
 * @version 12/05/28
 */
public class AkariGame {

    private int casillasBlancas = 0;
    private int casillasNegras = 0;
    private String fileContents = null;
    private int numeroColumnas = 0;
    private int numeroFilas = 0;
    private int[][] restricciones = null;
    private byte[][] tablero = null,
            bombillos = null,
            iluminacion = null;

    /**
     * Constructs ...
     *
     */
    public AkariGame() {
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean validation() {

//      boolean valida = true;
        for (int i = 0; i < this.numeroFilas; i++) {
            for (int j = 0; j < this.numeroColumnas; j++) {
                if ((tablero[i][j] + iluminacion[i][j]) != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean procesarFileContents() {

        StringTokenizer tokens = new StringTokenizer(fileContents);

        try {
            numeroFilas = Integer.parseInt(tokens.nextToken());
            numeroColumnas = Integer.parseInt(tokens.nextToken());
            
            restricciones = new int[numeroFilas][numeroColumnas];
            iluminacion = new byte[numeroFilas][numeroColumnas];
            tablero = new byte[numeroFilas][numeroColumnas];
            bombillos = new byte[numeroFilas][numeroColumnas];
            
            for (int i = 0; i < iluminacion.length; i++) {
                for (int j = 0; j < iluminacion[i].length; j++) {
                    iluminacion[i][j] = 0;
                    bombillos[i][j] = 0;
                    tablero[i][j] = 0;
                }
            }
            
            for (int i = 0; i < restricciones.length; i++) {
                for (int j = 0; j < restricciones[i].length; j++) {
                    int valor = Integer.parseInt(tokens.nextToken());
                    
                    if (valor == 0) {
                        restricciones[i][j] = 8;    // para casillas blancas sin bombillo, NO SE PUEDE COLOCAR NULL
                        tablero[i][j] = 0;
                    }
                    
                    if (valor == 1) {
                        tablero[i][j] = 0;
                        bombillos[i][j] = 1;
                    }
                    
                    if (valor == 2) {
                        restricciones[i][j] = 8;    // PARA CASILLAS NEGRAS SIN NUMERO, NO SE PUEDE COLOCAR NULL
                        tablero[i][j] = 1;
                        casillasNegras++;
                    }
                    
                    if (valor == 3) {
                        restricciones[i][j] = 0;
                        tablero[i][j] = 1;
                        casillasNegras++;
                    }
                    
                    if (valor == 4) {
                        restricciones[i][j] = 1;
                        tablero[i][j] = 1;
                        casillasNegras++;
                    }
                    
                    if (valor == 5) {
                        restricciones[i][j] = 2;
                        tablero[i][j] = 1;
                        casillasNegras++;
                    }
                    
                    if (valor == 6) {
                        restricciones[i][j] = 3;
                        tablero[i][j] = 1;
                        casillasNegras++;
                    }
                    
                    if (valor == 7) {
                        restricciones[i][j] = 4;
                        tablero[i][j] = 1;
                        casillasNegras++;
                    }
                    
                    if (valor > 7) {
                        return false;
                    }
                    
                    
                    System.out.print(tablero[i][j] + " ");
                }
                
                System.out.print("\n");
            }
            casillasBlancas = (numeroFilas * numeroColumnas) - casillasNegras;
        } catch (Exception e) {
            System.err.println(e.toString());
            return false;
        }
        return true;
    }

    /**
     * Method description
     *
     *
     * @param i
     * @param j
     * @param n
     * @param m
     */
    public void iluminarFila(int i, int j, int n, int m) {
        for (int x = j; x < n; x++) {
            if (tablero[i][x] == 0) {
                iluminacion[i][x] = 1;
            } else {
                break;
            }
        }

        for (int x = j; x >= 0; x--) {
            if (tablero[i][x] == 0) {
                iluminacion[i][x] = 1;
            } else {
                break;
            }
        }
    }

    /**
     * Method description
     *
     *
     * @param i
     * @param j
     * @param m
     */
    public void iluminarColumna(int i, int j, int m) {
        for (int y = i; y < m; y++) {
            if (tablero[y][j] == 0) {
                iluminacion[y][j] = 1;
            } else {
                break;
            }
        }

        for (int y = i; y >= 0; y--) {
            if (tablero[y][j] == 0) {
                iluminacion[y][j] = 1;
            } else {
                break;
            }
        }
    }

    /**
     * Method description
     *
     *
     * @param fila
     * @param columna
     *
     * @return
     */
    public boolean ponerBombillo(int fila, int columna) {
        int m = numeroFilas;
        int n = numeroColumnas;

        if ((tablero[fila][columna] == 0) && (iluminacion[fila][columna] == 0)) {
            bombillos[fila][columna] = 1;
            iluminarFila(fila, columna, n, m);
            iluminarColumna(fila, columna, m);

            return true;
        } else {
            return false;
        }
    }

    /**
     * Method description
     *
     */
    public void inicializarMatriz() {
        for (int i = 0; i < numeroFilas; i++) {
            for (int j = 0; j < numeroColumnas; j++) {
                bombillos[i][j] = 0;
                iluminacion[i][j] = 0;
            }
        }
    }

    /**
     * Method description
     *
     *
     * @param selectedFile
     *
     * @return
     */
    public boolean loadFromFile(File selectedFile) {
        BufferedReader datos = null;
        String lectura;

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

    //<editor-fold defaultstate="collapsed" desc="GETTERS AND SETTERS">
    /**
     * Method description
     *
     *
     * @return
     */
    public byte[][] getBombillos() {
        return bombillos;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getCasillasBlancas() {
        return casillasBlancas;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getCasillasNegras() {
        return casillasNegras;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getFileContents() {
        return fileContents;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public byte[][] getIluminacion() {
        return iluminacion;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getNumeroColumnas() {
        return numeroColumnas;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getNumeroFilas() {
        return numeroFilas;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int[][] getRestricciones() {
        return restricciones;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public byte[][] getTablero() {
        return tablero;
    }

    /**
     * Method description
     *
     *
     * @param bombillos
     */
    public void setBombillos(byte[][] bombillos) {
        this.bombillos = bombillos;
    }

    /**
     * Method description
     *
     *
     * @param casillasBlancas
     */
    public void setCasillasBlancas(int casillasBlancas) {
        this.casillasBlancas = casillasBlancas;
    }

    /**
     * Method description
     *
     *
     * @param casillasNegras
     */
    public void setCasillasNegras(int casillasNegras) {
        this.casillasNegras = casillasNegras;
    }

    /**
     * Method description
     *
     *
     * @param fileContents
     */
    public void setFileContents(String fileContents) {
        this.fileContents = fileContents;
    }

    /**
     * Method description
     *
     *
     * @param iluminacion
     */
    public void setIluminacion(byte[][] iluminacion) {
        this.iluminacion = iluminacion;
    }

    /**
     * Method description
     *
     *
     * @param numeroColumnas
     */
    public void setNumeroColumnas(int numeroColumnas) {
        this.numeroColumnas = numeroColumnas;
    }

    /**
     * Method description
     *
     *
     * @param numeroFilas
     */
    public void setNumeroFilas(int numeroFilas) {
        this.numeroFilas = numeroFilas;
    }

    /**
     * Method description
     *
     *
     * @param restricciones
     */
    public void setRestricciones(int[][] restricciones) {
        this.restricciones = restricciones;
    }

    /**
     * Method description
     *
     *
     * @param tablero
     */
    public void setTablero(byte[][] tablero) {
        this.tablero = tablero;
    }
    //</editor-fold>
}


//~ Formatted by Jindent --- http://www.jindent.com
