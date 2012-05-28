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
    private int[][] talberoRestricciones = null;
    private byte[][] tableroCasillasNegras = null,
            tableroBombillos = null,
            tableroIluminacion = null;

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
     * @param i
     * @param j
     * @param m
     */
    public void iluminarColumna(int i, int j, int m) {
        for (int y = i; y < m; y++) {
            if (tableroCasillasNegras[y][j] == 0) {
                tableroIluminacion[y][j] = 1;
            } else {
                break;
            }
        }

        for (int y = i; y >= 0; y--) {
            if (tableroCasillasNegras[y][j] == 0) {
                tableroIluminacion[y][j] = 1;
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
     * @param n
     * @param m
     */
    public void iluminarFila(int i, int j, int n, int m) {
        for (int x = j; x < n; x++) {
            if (tableroCasillasNegras[i][x] == 0) {
                tableroIluminacion[i][x] = 1;
            } else {
                break;
            }
        }

        for (int x = j; x >= 0; x--) {
            if (tableroCasillasNegras[i][x] == 0) {
                tableroIluminacion[i][x] = 1;
            } else {
                break;
            }
        }
    }

    /**
     * Method description
     *
     */
    public void inicializarMatriz() {
        for (int i = 0; i < numeroFilas; i++) {
            for (int j = 0; j < numeroColumnas; j++) {
                tableroBombillos[i][j] = 0;
                tableroIluminacion[i][j] = 0;
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
            return procesarFileContents();

        } catch (IOException ex) {

            System.out.println(ex.toString());
            return false;
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

        if ((tableroCasillasNegras[fila][columna] == 0) && (tableroIluminacion[fila][columna] == 0)) {
            tableroBombillos[fila][columna] = 1;
            iluminarFila(fila, columna, n, m);
            iluminarColumna(fila, columna, m);

            return true;
        } else {
            return false;
        }
    }

    private boolean procesarFileContents() {
        StringTokenizer tokens = new StringTokenizer(fileContents);

        try {
            numeroFilas = Integer.parseInt(tokens.nextToken());
            numeroColumnas = Integer.parseInt(tokens.nextToken());
            talberoRestricciones = new int[numeroFilas][numeroColumnas];
            tableroIluminacion = new byte[numeroFilas][numeroColumnas];
            tableroCasillasNegras = new byte[numeroFilas][numeroColumnas];
            tableroBombillos = new byte[numeroFilas][numeroColumnas];

            for (int i = 0; i < numeroFilas; i++) {
                for (int j = 0; j < numeroColumnas; j++) {
                    tableroIluminacion[i][j] = 0;
                    tableroBombillos[i][j] = 0;
                    tableroCasillasNegras[i][j] = 0;
                }
            }

            for (int i = 0; i < numeroFilas; i++) {
                for (int j = 0; j < numeroColumnas; j++) {
                    int valor = Integer.parseInt(tokens.nextToken());

                    if (valor == 0) {
                        talberoRestricciones[i][j] = 8;    // para casillas blancas sin bombillo, NO SE PUEDE COLOCAR NULL
                        tableroCasillasNegras[i][j] = 0;
                    }

                    if (valor == 1) {
                        tableroCasillasNegras[i][j] = 0;
                        tableroBombillos[i][j] = 1;
                    }

                    if (valor == 2) {
                        talberoRestricciones[i][j] = 8;    // PARA CASILLAS NEGRAS SIN NUMERO, NO SE PUEDE COLOCAR NULL
                        tableroCasillasNegras[i][j] = 1;
                        casillasNegras++;
                    }

                    if (valor == 3) {
                        talberoRestricciones[i][j] = 0;
                        tableroCasillasNegras[i][j] = 1;
                        casillasNegras++;
                    }

                    if (valor == 4) {
                        talberoRestricciones[i][j] = 1;
                        tableroCasillasNegras[i][j] = 1;
                        casillasNegras++;
                    }

                    if (valor == 5) {
                        talberoRestricciones[i][j] = 2;
                        tableroCasillasNegras[i][j] = 1;
                        casillasNegras++;
                    }

                    if (valor == 6) {
                        talberoRestricciones[i][j] = 3;
                        tableroCasillasNegras[i][j] = 1;
                        casillasNegras++;
                    }

                    if (valor == 7) {
                        talberoRestricciones[i][j] = 4;
                        tableroCasillasNegras[i][j] = 1;
                        casillasNegras++;
                    }

                    if (valor > 7) {
                        return false;
                    }

                    System.out.print(tableroCasillasNegras[i][j] + " ");
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
     * @return
     */
    public boolean validation() {

//      boolean valida = true;
        for (int i = 0; i < this.numeroFilas; i++) {
            for (int j = 0; j < this.numeroColumnas; j++) {
                if ((tableroCasillasNegras[i][j] + tableroIluminacion[i][j]) != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    // <editor-fold defaultstate="collapsed" desc="GETTERS AND SETTERS">
    public int getCasillasBlancas() {
        return casillasBlancas;
    }

    public void setCasillasBlancas(int casillasBlancas) {
        this.casillasBlancas = casillasBlancas;
    }

    public int getCasillasNegras() {
        return casillasNegras;
    }

    public void setCasillasNegras(int casillasNegras) {
        this.casillasNegras = casillasNegras;
    }

    public String getFileContents() {
        return fileContents;
    }

    public void setFileContents(String fileContents) {
        this.fileContents = fileContents;
    }

    public int getNumeroColumnas() {
        return numeroColumnas;
    }

    public void setNumeroColumnas(int numeroColumnas) {
        this.numeroColumnas = numeroColumnas;
    }

    public int getNumeroFilas() {
        return numeroFilas;
    }

    public void setNumeroFilas(int numeroFilas) {
        this.numeroFilas = numeroFilas;
    }

    public byte[][] getTableroBombillos() {
        return tableroBombillos;
    }

    public void setTableroBombillos(byte[][] tableroBombillos) {
        this.tableroBombillos = tableroBombillos;
    }

    public byte[][] getTableroCasillasNegras() {
        return tableroCasillasNegras;
    }

    public void setTableroCasillasNegras(byte[][] tableroCasillasNegras) {
        this.tableroCasillasNegras = tableroCasillasNegras;
    }

    public byte[][] getTableroIluminacion() {
        return tableroIluminacion;
    }

    public void setTableroIluminacion(byte[][] tableroIluminacion) {
        this.tableroIluminacion = tableroIluminacion;
    }

    public int[][] getTalberoRestricciones() {
        return talberoRestricciones;
    }

    public void setTalberoRestricciones(int[][] talberoRestricciones) {
        this.talberoRestricciones = talberoRestricciones;
    }
    // </editor-fold>
}


//~ Formatted by Jindent --- http://www.jindent.com
