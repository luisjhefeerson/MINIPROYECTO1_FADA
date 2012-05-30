//**********************************************************
// FUNDAMENTOS DE ANÁLISIS Y DISEÑO DE ALGORITMOS
// MINIPROYECTO 1: SOLUCIÓN PARA UN JUEGO DE LÓGICA: AKARI
//
// ARCHIVO: GeneradorNoTanIngenuo.java
//
// FECHA:  12/05/30
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
/**
 * Class description
 *
 *
 * @version 12/05/28
 */
public class GeneradorNoTanIngenuo {

    AkariGame akari;
    private int[][] casillasNoIluminadas;
    private int[][] casillasTenidasEnCuenta;
    boolean[] cromosoma;
    boolean[] sumando;
    boolean stop;
    int nCasillasNoIluminadas;

    /**
     * Constructs ...
     *
     *
     * @param tablero
     */
    public GeneradorNoTanIngenuo(AkariGame tablero) {

        this.stop = false;
        this.akari = tablero;
        int longitudCromosoma = findCasillasATenerEnCuenta();
        this.cromosoma = new boolean[longitudCromosoma];
        this.sumando = new boolean[longitudCromosoma];

        // Inicializar el cromosoma y el sumando
        for (int i = 0; i < sumando.length; i++) {
            sumando[i] = false;
            cromosoma[i] = false;
        }

        // Terminando de Inicializar el sumando = (1)= 0000....0001
        sumando[sumando.length - 1] = true;


        System.out.println("Casillas a tener en cuenta!: " + longitudCromosoma);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean applicarCromosoma(int[][] matrizValidacion, boolean [] cromosoma) {

        int counter = 0;
        for (int i = 0; i < akari.getNumeroFilas(); i++) {
            for (int j = 0; j < akari.getNumeroColumnas(); j++) {
                if (matrizValidacion[i][j] == 1) {
                    if (cromosoma[counter]) {
                        if (!akari.ponerBombillo(i, j)) {
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
    private int findCasillasATenerEnCuenta() {

        casillasTenidasEnCuenta = new int[akari.getNumeroFilas()][akari.getNumeroColumnas()];

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
                    } // 2. Esquina superior derecha
                    else if ((i == 0) && (j == (akari.getNumeroColumnas() - 1))) {
                        if (akari.getTableroCasillasNegras()[i + 1][j] == 0) {
                            casillasTenidasEnCuenta[i + 1][j] = 1;        // Abajo
                        }

                        if (akari.getTableroCasillasNegras()[i][j - 1] == 0) {
                            casillasTenidasEnCuenta[i][j - 1] = 1;        // Izquierda
                        }
                    } // 3. Esquina inferior izquierda
                    else if ((i == (akari.getNumeroFilas() - 1)) && (j == 0)) {
                        if (akari.getTableroCasillasNegras()[i - 1][j] == 0) {
                            casillasTenidasEnCuenta[i - 1][j] = 1;        // Arriba
                        }

                        if (akari.getTableroCasillasNegras()[i][j + 1] == 0) {
                            casillasTenidasEnCuenta[i][j + 1] = 1;        // Derecha
                        }
                    } // 4. Esquina inferior derecha
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
                        } // 6. Ultima Fila, pero no esquina inferior
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
                        } // 7. Primera columna, pero no esquina izquierda
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
                        } // 8. Ultima columna, pero no esquina derecha
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
                        } // Para todos los demas casos
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

    /**
     * Method description
     *
     */
    private void findCasillasNoIluminadas() {
        this.nCasillasNoIluminadas = 0;
        this.casillasNoIluminadas = new int[akari.getNumeroFilas()][akari.getNumeroColumnas()];

        for (int i = 0; i < akari.getNumeroFilas(); i++) {
            for (int j = 0; j < akari.getNumeroColumnas(); j++) {
                casillasNoIluminadas[i][j] = akari.getTableroIluminacion()[i][j]
                        + akari.getTableroCasillasNegras()[i][j];

                if (casillasNoIluminadas[i][j] == 0) {
                    nCasillasNoIluminadas++;
                }

                System.out.print(casillasNoIluminadas[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println("\nCantidad de casillas si ilunimar:" + nCasillasNoIluminadas);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean[] generarSiguiteCromosoma(boolean[] cromosoma, boolean[] sumando) {

        // Inicializar Cromosoma Salida
        boolean[] salida = new boolean[cromosoma.length];

        boolean acarreo = false;

        for (int i = salida.length - 1; i >= 0; i--) {
            if (cromosoma[i] && sumando[i]) {
                if (acarreo) {
                    salida[i] = true;
                    acarreo = true;
                } else {
                    salida[i] = false;
                    acarreo = true;
                }
            } else if (cromosoma[i] || sumando[i]) {
                if (acarreo) {
                    salida[i] = false;
                    acarreo = true;
                } else {
                    salida[i] = true;
                    acarreo = false;
                }
            } else {
                if (acarreo) {
                    salida[i] = true;
                    acarreo = false;
                } else {
                    salida[i] = false;
                    acarreo = false;
                }
            }
        }

//         check overflow
        if (acarreo) {
            stop = true;
        }

        return salida;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean solucionNoTanIngenua() {

        boolean exito;
        do {
            cromosoma = generarSiguiteCromosoma(cromosoma, sumando);
            akari.inicializarMatriz();
            exito = applicarCromosoma(casillasTenidasEnCuenta, cromosoma);
        } while (!exito && !stop);
        findCasillasNoIluminadas();
        return exito;

//        while(!stop){
//            String numero = "";
//            System.out.println("\nNuevo Cromosoma:");
//            cromosoma = generarSiguiteCromosoma(cromosoma, sumando);
//            for (int i = 0; i < cromosoma.length; i++) {
//                if (cromosoma[i]) {
//                    numero += 1;
//                    System.out.print(1 + " ");
//                } else {
//                    System.out.print(0 + " ");
//                    numero += 0;
//                }
//            }
//            System.out.println("Numero:" + Integer.parseInt(numero, 2));
//        }
//        return true;
        
    }
}
