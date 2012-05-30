//**********************************************************
// FUNDAMENTOS DE ANÁLISIS Y DISEÑO DE ALGORITMOS
// MINIPROYECTO 1: SOLUCIÓN PARA UN JUEGO DE LÓGICA: AKARI
//
// ARCHIVO: GeneradorNoTanIngenuo.java
//
// FECHA: 12/05/29
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

//~--- non-JDK imports --------------------------------------------------------

import datos.AkariGame;

/**
 * Class description
 *
 *
 * @version 12/05/28
 */
public class GeneradorNoTanIngenuo {
    private byte[][] casillasTenidasEnCuenta = null;
    AkariGame        akari;
    int[]            cromosoma;
    int              longitudCromosoma;
    int              numeroCromosoma;

    /**
     * Constructs ...
     *
     *
     * @param tablero
     */
    public GeneradorNoTanIngenuo(AkariGame tablero) {
        this.numeroCromosoma   = 0;
        this.akari             = tablero;
        this.longitudCromosoma = findCasillasATenerEnCuenta();
        System.out.println("Casillas a tener en cuenta!: " + longitudCromosoma);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int[] generarSiguiteCromosoma() {
        numeroCromosoma++;

        String numeroEnBinario = Integer.toBinaryString(numeroCromosoma);

        System.out.println("Cromosoma: " + numeroCromosoma);
        System.out.println("En Binario: " + numeroEnBinario);

        // Inicializar Cromosoma
        cromosoma = new int[longitudCromosoma];

        for (int i = 0; i < cromosoma.length; i++) {
            cromosoma[i] = 0;
        }

        for (int i = 0; i < numeroEnBinario.length(); i++) {
            cromosoma[cromosoma.length - 1 - i] = Integer.parseInt(numeroEnBinario.substring(numeroEnBinario.length()
                    - 1 - i, numeroEnBinario.length() - i));
        }

        return cromosoma;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean applicarCromosoma() {
        int counter = 0;

        for (int i = 0; i < akari.getNumeroFilas(); i++) {
            for (int j = 0; j < akari.getNumeroColumnas(); j++) {
                if (casillasTenidasEnCuenta[i][j] == 1) {
                    if (cromosoma[counter] == 1) {
                        if (!akari.ponerBombillo(i, j)) {
                            System.out.println("No permite colocar Bombillo en: " + i + "," + j);

                            return false;
                        }
                    }

                    counter++;
                }
            }
        }

        return akari.validation(true);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean solucionNoTanIngenua() {
        generarSiguiteCromosoma();

        boolean b = applicarCromosoma();

        while ((!b) && (numeroCromosoma < Math.pow(2, longitudCromosoma) - 1)) {
            generarSiguiteCromosoma();
            akari.inicializarMatriz();
            b = applicarCromosoma();
            System.out.println("Aplicar Cromosoma: " + numeroCromosoma + " Resultado: " + b + "\n\n");
        }

        return b;
    }

    private int findCasillasATenerEnCuenta() {
        casillasTenidasEnCuenta = new byte[akari.getNumeroFilas()][akari.getNumeroColumnas()];

        for (int i = 0; i < akari.getNumeroFilas(); i++) {
            for (int j = 0; j < akari.getNumeroColumnas(); j++) {
                casillasTenidasEnCuenta[i][j] = 0;
            }
        }

        for (int i = 0; i < akari.getNumeroFilas(); i++) {
            for (int j = 0; j < akari.getNumeroColumnas(); j++) {
                if ((akari.getTalberoRestricciones()[i][j] >= 1) && (akari.getTalberoRestricciones()[i][j] <= 4)) {

                    // Suma en casos especiales
                    // 1. Esquina superior izquierda
                    if ((i == 0) && (j == 0)) {
                        if (akari.getTableroCasillasNegras()[i + 1][j] == 0) {
                            casillasTenidasEnCuenta[i + 1][j] = 1;        // Abajo
                        }

                        if (akari.getTableroCasillasNegras()[i][j + 1] == 0) {
                            casillasTenidasEnCuenta[i][j + 1] = 1;        // Derecha
                        }
                    }                                                     // 2. Esquina superior derecha
                            else if ((i == 0) && (j == (akari.getNumeroColumnas() - 1))) {
                        if (akari.getTableroCasillasNegras()[i + 1][j] == 0) {
                            casillasTenidasEnCuenta[i + 1][j] = 1;        // Abajo
                        }

                        if (akari.getTableroCasillasNegras()[i][j - 1] == 0) {
                            casillasTenidasEnCuenta[i][j - 1] = 1;        // Izquierda
                        }
                    }                                                     // 3. Esquina inferior izquierda
                            else if ((i == (akari.getNumeroFilas() - 1)) && (j == 0)) {
                        if (akari.getTableroCasillasNegras()[i - 1][j] == 0) {
                            casillasTenidasEnCuenta[i - 1][j] = 1;        // Arriba
                        }

                        if (akari.getTableroCasillasNegras()[i][j + 1] == 0) {
                            casillasTenidasEnCuenta[i][j + 1] = 1;        // Derecha
                        }
                    }                                                     // 4. Esquina inferior derecha
                            else if ((i == (akari.getNumeroFilas() - 1)) && (j == (akari.getNumeroColumnas() - 1))) {
                        if (akari.getTableroCasillasNegras()[i - 1][j] == 0) {
                            casillasTenidasEnCuenta[i - 1][j] = 1;        // Arriba
                        }

                        if (akari.getTableroCasillasNegras()[i][j - 1] == 0) {
                            casillasTenidasEnCuenta[i][j - 1] = 1;        // Izquierda
                        }
                    } else {

                        // 5. Primera fila, pero no esquina superior
                        if (i == 0) {
                            if (akari.getTableroCasillasNegras()[i + 1][j] == 0) {
                                casillasTenidasEnCuenta[i + 1][j] = 1;    // Abajo
                            }

                            if (akari.getTableroCasillasNegras()[i][j + 1] == 0) {
                                casillasTenidasEnCuenta[i][j + 1] = 1;    // Derecha
                            }

                            if (akari.getTableroCasillasNegras()[i][j - 1] == 0) {
                                casillasTenidasEnCuenta[i][j - 1] = 1;    // Izquierda
                            }
                        }                                                 // 6. Ultima Fila, pero no esquina inferior
                                else if (i == (akari.getNumeroFilas() - 1)) {
                            if (akari.getTableroCasillasNegras()[i - 1][j] == 0) {
                                casillasTenidasEnCuenta[i - 1][j] = 1;    // Arriba
                            }

                            if (akari.getTableroCasillasNegras()[i][j + 1] == 0) {
                                casillasTenidasEnCuenta[i][j + 1] = 1;    // Derecha
                            }

                            if (akari.getTableroCasillasNegras()[i][j - 1] == 0) {
                                casillasTenidasEnCuenta[i][j - 1] = 1;    // Izquierda
                            }
                        }                                                 // 7. Primera columna, pero no esquina izquierda
                                else if (j == 0) {
                            if (akari.getTableroCasillasNegras()[i + 1][j] == 0) {
                                casillasTenidasEnCuenta[i + 1][j] = 1;    // Abajo
                            }

                            if (akari.getTableroCasillasNegras()[i - 1][j] == 0) {
                                casillasTenidasEnCuenta[i - 1][j] = 1;    // Arriba
                            }

                            if (akari.getTableroCasillasNegras()[i][j + 1] == 0) {
                                casillasTenidasEnCuenta[i][j + 1] = 1;    // Derecha
                            }
                        }                                                 // 8. Ultima columna, pero no esquina derecha
                                else if (j == (akari.getNumeroColumnas() - 1)) {
                            if (akari.getTableroCasillasNegras()[i + 1][j] == 0) {
                                casillasTenidasEnCuenta[i + 1][j] = 1;    // Abajo
                            }

                            if (akari.getTableroCasillasNegras()[i - 1][j] == 0) {
                                casillasTenidasEnCuenta[i - 1][j] = 1;    // Arriba
                            }

                            if (akari.getTableroCasillasNegras()[i][j - 1] == 0) {
                                casillasTenidasEnCuenta[i][j - 1] = 1;    // Izquierda
                            }
                        }                                                 // Para todos los demas casos
                                else {
                            if (akari.getTableroCasillasNegras()[i + 1][j] == 0) {
                                casillasTenidasEnCuenta[i + 1][j] = 1;    // Abajo
                            }

                            if (akari.getTableroCasillasNegras()[i - 1][j] == 0) {
                                casillasTenidasEnCuenta[i - 1][j] = 1;    // Arriba
                            }

                            if (akari.getTableroCasillasNegras()[i][j + 1] == 0) {
                                casillasTenidasEnCuenta[i][j + 1] = 1;    // Derecha
                            }

                            if (akari.getTableroCasillasNegras()[i][j - 1] == 0) {
                                casillasTenidasEnCuenta[i][j - 1] = 1;    // Izquierda
                            }
                        }
                    }
                }
            }
        }

        System.out.print("\n\nMatriz Casillas Tenidas en Cuenta\n\n");

        int numeroDeCasillas = 0;

        for (int i = 0; i < akari.getNumeroFilas(); i++) {
            for (int j = 0; j < akari.getNumeroColumnas(); j++) {
                System.out.print(casillasTenidasEnCuenta[i][j] + " ");

                if (casillasTenidasEnCuenta[i][j] == 1) {
                    numeroDeCasillas++;
                }
            }

            System.out.println("");
        }

        return numeroDeCasillas;
    }
}
