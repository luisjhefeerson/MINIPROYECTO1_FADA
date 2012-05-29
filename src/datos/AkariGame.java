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

    private String textoEnArchivo = null;
    private int casillasBlancas = 0;
    private int casillasNegras = 0;
    private int numeroColumnas = 0;
    private int numeroFilas = 0;
    private int[][] tableroRestricciones = null;
    private byte[][] tableroCasillasNegras = null;
    private byte[][] tableroBombillos = null;
    private byte[][] tableroIluminacion = null;

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
     * @param numeroFilas
     */
    public void iluminarColumna(int i, int j) {

        // Iluminar Hacia Abajo        
        for (int y = i; y < numeroFilas; y++) {
            if (tableroCasillasNegras[y][j] == 0) {
                tableroIluminacion[y][j] = 1;
            } else {
                break;
            }
        }

        // Iluminar Hacia Arriba
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
     * @param fila
     * @param columna
     * @param numeroColumnas
     * @param m
     */
    public void iluminarFila(int fila, int columna) {

        // Iluminar hacia la derecha
        for (int x = columna; x < numeroColumnas; x++) {
            if (tableroCasillasNegras[fila][x] == 0) {
                tableroIluminacion[fila][x] = 1;
            } else {
                break;
            }
        }

        // Iluminar hacia la izquierda
        for (int x = columna; x >= 0; x--) {
            if (tableroCasillasNegras[fila][x] == 0) {
                tableroIluminacion[fila][x] = 1;
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

            textoEnArchivo = bufer.toString();
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
     * @param i
     * @param j
     *
     * @return
     */
    public boolean ponerBombillo(int i, int j) {

        if ((tableroCasillasNegras[i][j] == 0) && (tableroIluminacion[i][j] == 0)) {
            tableroBombillos[i][j] = 1;
            iluminarFila(i, j);
            iluminarColumna(i, j);
            return true;
        } else {
            return false;
        }
    }

    public boolean quitarBombillo(int fila, int columna) {

        if (tableroBombillos[fila][columna] == 1) {
            
            tableroBombillos[fila][columna] = 0;
            for (int i = 0; i < numeroFilas; i++) 
                for (int j = 0; j < numeroColumnas; j++) 
                    tableroIluminacion[i][j] = 0;

            for (int i = 0; i < numeroFilas; i++) {
                for (int j = 0; j < numeroColumnas; j++) {
                    if (tableroBombillos[i][j] == 1) {
                        iluminarFila(i, j);
                        iluminarColumna(i, j);
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean procesarFileContents() {
        StringTokenizer tokens = new StringTokenizer(textoEnArchivo);

        try {
            numeroFilas = Integer.parseInt(tokens.nextToken());
            numeroColumnas = Integer.parseInt(tokens.nextToken());
            tableroRestricciones = new int[numeroFilas][numeroColumnas];
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
                        tableroRestricciones[i][j] = 8;    // para casillas blancas sin bombillo, NO SE PUEDE COLOCAR NULL
                        tableroCasillasNegras[i][j] = 0;
                    }

                    if (valor == 1) {
                        tableroRestricciones[i][j] = 8;
                        tableroCasillasNegras[i][j] = 0;
                        tableroBombillos[i][j] = 1;

                    }

                    if (valor == 2) {
                        tableroRestricciones[i][j] = 8;    // PARA CASILLAS NEGRAS SIN NUMERO, NO SE PUEDE COLOCAR NULL
                        tableroCasillasNegras[i][j] = 1;
                        casillasNegras++;
                    }

                    if (valor == 3) {
                        tableroRestricciones[i][j] = 0;
                        tableroCasillasNegras[i][j] = 1;
                        casillasNegras++;
                    }

                    if (valor == 4) {
                        tableroRestricciones[i][j] = 1;
                        tableroCasillasNegras[i][j] = 1;
                        casillasNegras++;
                    }

                    if (valor == 5) {
                        tableroRestricciones[i][j] = 2;
                        tableroCasillasNegras[i][j] = 1;
                        casillasNegras++;
                    }

                    if (valor == 6) {
                        tableroRestricciones[i][j] = 3;
                        tableroCasillasNegras[i][j] = 1;
                        casillasNegras++;
                    }

                    if (valor == 7) {
                        tableroRestricciones[i][j] = 4;
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

        // OR operation
        for (int i = 0; i < this.numeroFilas; i++) {
            for (int j = 0; j < this.numeroColumnas; j++) {

                if ((tableroCasillasNegras[i][j] + tableroIluminacion[i][j]) != 1) {
                    return false;
                }

                if (tableroRestricciones[i][j] >= 0 && tableroRestricciones[i][j] <= 4) {
                    int suma = 0;

                    // Suma en casos especiales

                    // 1. Esquina superior izquierda
                    if (i == 0 && j == 0) {
                        suma = tableroBombillos[i + 1][j] // Abajo
                                + tableroBombillos[i][j + 1]; // Derecha

                    } // 2. Esquina superior derecha
                    else if (i == 0 && j == (numeroColumnas - 1)) {
                        suma = tableroBombillos[i + 1][j] // Abajo 
                                + tableroBombillos[i][j - 1]; // Izquierda

                    } // 3. Esquina inferior izquierda
                    else if (i == (numeroFilas - 1) && j == 0) {
                        suma = tableroBombillos[i - 1][j] // Arriba
                                + tableroBombillos[i][j + 1]; // Derecha

                    } // 4. Esquina inferior derecha
                    else if (i == (numeroFilas - 1) && j == (numeroColumnas - 1)) {
                        suma = tableroBombillos[i - 1][j] // Arriba
                                + tableroBombillos[i][j - 1]; // Izquierda

                    } else {

                        // 5. Primera fila, pero no esquina superior
                        if (i == 0) {
                            suma = tableroBombillos[i + 1][j] // Abajo
                                    + tableroBombillos[i][j + 1] // Derecha
                                    + tableroBombillos[i][j - 1]; // Izquierda

                        } //6. Ultima Fila, pero no esquina inferior
                        else if (i == (numeroFilas - 1)) {
                            suma = tableroBombillos[i - 1][j] //Arriba
                                    + tableroBombillos[i][j + 1] //Derecha
                                    + tableroBombillos[i][j - 1]; //Izquierda

                        } //7. Primera columna, pero no esquina izquierda
                        else if (j == 0) {
                            suma = tableroBombillos[i + 1][j] // Abajo
                                    + tableroBombillos[i - 1][j] // Arriba
                                    + tableroBombillos[i][j + 1]; // Derecha

                        } // 8. Ultima columna, pero no esquina derecha
                        else if (j == (numeroColumnas - 1)) {
                            suma = tableroBombillos[i + 1][j] // Arriba
                                    + tableroBombillos[i - 1][j] // Abajo
                                    + tableroBombillos[i][j - 1]; // Izquierda

                        } // Para todos los demas casos 
                        else {
                            suma = tableroBombillos[i + 1][j] // Abajo
                                    + tableroBombillos[i - 1][j] // Arriba
                                    + tableroBombillos[i][j + 1] // Derecha
                                    + tableroBombillos[i][j - 1]; // Izquierda
                        }
                    }

                    if (suma != tableroRestricciones[i][j]) {
                        return false;
                    }
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
        return tableroRestricciones;
    }

    public void setTalberoRestricciones(int[][] talberoRestricciones) {
        this.tableroRestricciones = talberoRestricciones;
    }

    public String getTextoEnArchivo() {
        return textoEnArchivo;
    }

    public void setTextoEnArchivo(String textoEnArchivo) {
        this.textoEnArchivo = textoEnArchivo;
    }
    // </editor-fold>
}


//~ Formatted by Jindent --- http://www.jindent.com
