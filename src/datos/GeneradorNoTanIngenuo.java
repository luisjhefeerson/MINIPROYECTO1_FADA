//**********************************************************
// FUNDAMENTOS DE ANÁLISIS Y DISEÑO DE ALGORITMOS
// MINIPROYECTO 1: SOLUCIÓN PARA UN JUEGO DE LÓGICA: AKARI
//
// ARCHIVO: GeneradorNoTanIngenuo.java
//
// FECHA: 12/05/30
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
import java.util.ArrayList;

/**
 * Class description
 *
 *
 * @version 12/05/28
 */
public class GeneradorNoTanIngenuo {

    ArrayList<RespuestaNoTanIngenua> Soluciones;
    AkariGame akari;
    private boolean[][] casillasNoIluminadas;
    private boolean[][] casillasTenidasEnCuenta;
    boolean[] cromosoma;
    boolean[] cromosomaNoIluminadas;
    boolean stop;
    boolean[] sumando;
    boolean[] sumandoNoIluminadas;

    /**
     * Constructs ...
     *
     *
     * @param tablero
     */
    public GeneradorNoTanIngenuo(AkariGame tablero) {
        this.stop = false;
        this.akari = tablero;
        Soluciones = new ArrayList<RespuestaNoTanIngenua>();

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
     *
     * @param matrizValidacion
     * @param cromosoma
     * @param type
     * @return
     */
    public boolean applicarCromosoma(boolean[][] matrizValidacion, boolean[] cromosoma, boolean type) {
        int counter = 0;

        for (int i = 0; i < akari.getNumeroFilas(); i++) {
            for (int j = 0; j < akari.getNumeroColumnas(); j++) {
                if (matrizValidacion[i][j]) {
                    if (cromosoma[counter]) {
                        if (!akari.ponerBombillo(i, j)) {
                            return false;
                        }
                    }

                    counter++;
                }
            }
        }

        return akari.validation(type);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    private int findCasillasATenerEnCuenta() {
        casillasTenidasEnCuenta = new boolean[akari.getNumeroFilas()][akari.getNumeroColumnas()];

        for (int i = 0; i < akari.getNumeroFilas(); i++) {
            for (int j = 0; j < akari.getNumeroColumnas(); j++) {
                casillasTenidasEnCuenta[i][j] = false;
            }
        }

        for (int i = 0; i < akari.getNumeroFilas(); i++) {
            for (int j = 0; j < akari.getNumeroColumnas(); j++) {
                if ((akari.getTalberoRestricciones()[i][j] >= 1) && (akari.getTalberoRestricciones()[i][j] <= 4)) {

                    // Suma en casos especiales
                    // 1. Esquina superior izquierda
                    if ((i == 0) && (j == 0)) {
                        if (akari.getTableroCasillasNegras()[i + 1][j] == 0) {
                            casillasTenidasEnCuenta[i + 1][j] = true;        // Abajo
                        }

                        if (akari.getTableroCasillasNegras()[i][j + 1] == 0) {
                            casillasTenidasEnCuenta[i][j + 1] = true;        // Derecha
                        }
                    } // 2. Esquina superior derecha
                    else if ((i == 0) && (j == (akari.getNumeroColumnas() - 1))) {
                        if (akari.getTableroCasillasNegras()[i + 1][j] == 0) {
                            casillasTenidasEnCuenta[i + 1][j] = true;        // Abajo
                        }

                        if (akari.getTableroCasillasNegras()[i][j - 1] == 0) {
                            casillasTenidasEnCuenta[i][j - 1] = true;        // Izquierda
                        }
                    } // 3. Esquina inferior izquierda
                    else if ((i == (akari.getNumeroFilas() - 1)) && (j == 0)) {
                        if (akari.getTableroCasillasNegras()[i - 1][j] == 0) {
                            casillasTenidasEnCuenta[i - 1][j] = true;        // Arriba
                        }

                        if (akari.getTableroCasillasNegras()[i][j + 1] == 0) {
                            casillasTenidasEnCuenta[i][j + 1] = true;        // Derecha
                        }
                    } // 4. Esquina inferior derecha
                    else if ((i == (akari.getNumeroFilas() - 1)) && (j == (akari.getNumeroColumnas() - 1))) {
                        if (akari.getTableroCasillasNegras()[i - 1][j] == 0) {
                            casillasTenidasEnCuenta[i - 1][j] = true;        // Arriba
                        }

                        if (akari.getTableroCasillasNegras()[i][j - 1] == 0) {
                            casillasTenidasEnCuenta[i][j - 1] = true;        // Izquierda
                        }
                    } else {

                        // 5. Primera fila, pero no esquina superior
                        if (i == 0) {
                            if (akari.getTableroCasillasNegras()[i + 1][j] == 0) {
                                casillasTenidasEnCuenta[i + 1][j] = true;    // Abajo
                            }

                            if (akari.getTableroCasillasNegras()[i][j + 1] == 0) {
                                casillasTenidasEnCuenta[i][j + 1] = true;    // Derecha
                            }

                            if (akari.getTableroCasillasNegras()[i][j - 1] == 0) {
                                casillasTenidasEnCuenta[i][j - 1] = true;    // Izquierda
                            }
                        } // 6. Ultima Fila, pero no esquina inferior
                        else if (i == (akari.getNumeroFilas() - 1)) {
                            if (akari.getTableroCasillasNegras()[i - 1][j] == 0) {
                                casillasTenidasEnCuenta[i - 1][j] = true;    // Arriba
                            }

                            if (akari.getTableroCasillasNegras()[i][j + 1] == 0) {
                                casillasTenidasEnCuenta[i][j + 1] = true;    // Derecha
                            }

                            if (akari.getTableroCasillasNegras()[i][j - 1] == 0) {
                                casillasTenidasEnCuenta[i][j - 1] = true;    // Izquierda
                            }
                        } // 7. Primera columna, pero no esquina izquierda
                        else if (j == 0) {
                            if (akari.getTableroCasillasNegras()[i + 1][j] == 0) {
                                casillasTenidasEnCuenta[i + 1][j] = true;    // Abajo
                            }

                            if (akari.getTableroCasillasNegras()[i - 1][j] == 0) {
                                casillasTenidasEnCuenta[i - 1][j] = true;    // Arriba
                            }

                            if (akari.getTableroCasillasNegras()[i][j + 1] == 0) {
                                casillasTenidasEnCuenta[i][j + 1] = true;    // Derecha
                            }
                        } // 8. Ultima columna, pero no esquina derecha
                        else if (j == (akari.getNumeroColumnas() - 1)) {
                            if (akari.getTableroCasillasNegras()[i + 1][j] == 0) {
                                casillasTenidasEnCuenta[i + 1][j] = true;    // Abajo
                            }

                            if (akari.getTableroCasillasNegras()[i - 1][j] == 0) {
                                casillasTenidasEnCuenta[i - 1][j] = true;    // Arriba
                            }

                            if (akari.getTableroCasillasNegras()[i][j - 1] == 0) {
                                casillasTenidasEnCuenta[i][j - 1] = true;    // Izquierda
                            }
                        } // Para todos los demas casos
                        else {
                            if (akari.getTableroCasillasNegras()[i + 1][j] == 0) {
                                casillasTenidasEnCuenta[i + 1][j] = true;    // Abajo
                            }

                            if (akari.getTableroCasillasNegras()[i - 1][j] == 0) {
                                casillasTenidasEnCuenta[i - 1][j] = true;    // Arriba
                            }

                            if (akari.getTableroCasillasNegras()[i][j + 1] == 0) {
                                casillasTenidasEnCuenta[i][j + 1] = true;    // Derecha
                            }

                            if (akari.getTableroCasillasNegras()[i][j - 1] == 0) {
                                casillasTenidasEnCuenta[i][j - 1] = true;    // Izquierda
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

                if (casillasTenidasEnCuenta[i][j]) {
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
    private int findCasillasNoIluminadas() {
        int nCasillasNoIluminadas = 0;

        this.casillasNoIluminadas = new boolean[akari.getNumeroFilas()][akari.getNumeroColumnas()];

        for (int i = 0; i < akari.getNumeroFilas(); i++) {
            for (int j = 0; j < akari.getNumeroColumnas(); j++) {
                if (akari.getTableroIluminacion()[i][j] + akari.getTableroCasillasNegras()[i][j] == 1) {
                    casillasNoIluminadas[i][j] = false;
                    System.out.print(0 + " ");
                } else {
                    casillasNoIluminadas[i][j] = true;
                    System.out.print(1 + " ");
                }

                if (casillasNoIluminadas[i][j]) {
                    nCasillasNoIluminadas++;
                }
            }

            System.out.println();
        }

        System.out.println("\nCantidad de casillas si ilunimar:" + nCasillasNoIluminadas);

        return nCasillasNoIluminadas;
    }

    /**
     * Method description
     *
     *
     *
     * @param cromosoma
     * @param sumando
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

//      check overflow
        if (acarreo) {
            stop = true;
        }

        return salida;
    }

    private void guardarSolucion(boolean[] cromosoma, boolean[] cromosomaNoIluminadas, boolean[][] casillasNoIluminadas) {
        Soluciones.add(new RespuestaNoTanIngenua(cromosoma, cromosomaNoIluminadas, casillasNoIluminadas));
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean intentarIluminar() {
        int longitudCromosoma = findCasillasNoIluminadas();

        if (longitudCromosoma > 0) {
            this.cromosomaNoIluminadas = new boolean[longitudCromosoma];
            this.sumandoNoIluminadas = new boolean[longitudCromosoma];

            // Inicializar el cromosoma y el sumando
            for (int i = 0; i < cromosomaNoIluminadas.length; i++) {
                sumandoNoIluminadas[i] = false;
                cromosomaNoIluminadas[i] = false;
            }

            // Terminando de Inicializar el sumando = (1)= 0000....0001
            sumandoNoIluminadas[sumandoNoIluminadas.length - 1] = true;

            byte[][] tableroBombillos = new byte[akari.getNumeroFilas()][akari.getNumeroColumnas()];
            byte[][] tableroIluminacion = new byte[akari.getNumeroFilas()][akari.getNumeroColumnas()];

            for (int i = 0; i < akari.getNumeroFilas(); i++) {
                for (int j = 0; j < akari.getNumeroColumnas(); j++) {
                    tableroBombillos[i][j] = akari.getTableroBombillos()[i][j];
                    tableroIluminacion[i][j] = akari.getTableroIluminacion()[i][j];
                }
            }

            boolean exito;

            do {
                cromosomaNoIluminadas = generarSiguiteCromosoma(cromosomaNoIluminadas, sumandoNoIluminadas);
                exito = applicarCromosoma(casillasNoIluminadas, cromosomaNoIluminadas, false);

                if (!exito) {
                    akari.setTableroBombillos(tableroBombillos);
                    akari.setTableroIluminacion(tableroIluminacion);
                }
            } while (!exito && !stop);

            if (stop) {
                stop = false;

                return solucionNoTanIngenua();
            } else {
                guardarSolucion(cromosoma, cromosomaNoIluminadas, casillasNoIluminadas);

                return exito;
            }
        } else {
            guardarSolucion(cromosoma, cromosomaNoIluminadas, casillasNoIluminadas);

            return true;
        }
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
            akari.quitarBombillosEIluminacion();
            exito = applicarCromosoma(casillasTenidasEnCuenta, cromosoma, true);
        } while (!exito && !stop);

        if (exito) {
            return intentarIluminar();
        } else {
            return false;
        }
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getNumeroSoluciones() {
        return Soluciones.size();
    }

    /**
     * Method description
     *
     *
     * @param respuesta
     */
    public void setSolucion(int i) {
        
        RespuestaNoTanIngenua respuesta = Soluciones.get(i);
        akari.quitarBombillosEIluminacion();
        applicarCromosoma(casillasTenidasEnCuenta, respuesta.getCromosoma(), true);
        applicarCromosoma(respuesta.getCasillasNoIluminadas(), respuesta.getCromosomaNoIluminadas(), false);

    }
}
