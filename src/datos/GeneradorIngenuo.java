//**********************************************************
// FUNDAMENTOS DE ANÁLISIS Y DISEÑO DE ALGORITMOS
// MINIPROYECTO 1: SOLUCIÓN PARA UN JUEGO DE LÓGICA: AKARI
//
// ARCHIVO: GeneradorIngenuo.java
//
// FECHA:  01.06.12
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

/**
 * Class description
 *
 *
 * @version 12/05/28
 */
public class GeneradorIngenuo {
    AkariGame akari;
    boolean[] cromosoma;
    int       numeroCromosoma;
    boolean   stop;
    boolean[] sumando;

    /**
     * Constructs ...
     *
     *
     * @param tablero
     */
    public GeneradorIngenuo(AkariGame tablero) {
        numeroCromosoma = 0;
        this.akari      = tablero;
        this.stop       = false;
        this.akari      = tablero;

        int longitudCromosoma = tablero.getCasillasBlancas();

        this.cromosoma = new boolean[longitudCromosoma];
        this.sumando   = new boolean[longitudCromosoma];

        // Inicializar el cromosoma y el sumando
        for (int i = 0; i < sumando.length; i++) {
            sumando[i]   = false;
            cromosoma[i] = false;
        }

        // Terminando de Inicializar el sumando = (1)= 0000....0001
        sumando[sumando.length - 1] = true;
        System.out.println("Casillas en Blanco: " + longitudCromosoma);
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
                if (akari.getTableroCasillasNegras()[i][j] == 0) {
                    if (cromosoma[counter]) {
                        if (!akari.ponerBombillo(i, j)) {
                            return false;
                        }
                    }

                    counter++;
                }
            }
        }

        return akari.validation(false);
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
        boolean[] salida  = new boolean[cromosoma.length];
        boolean   acarreo = false;

        for (int i = salida.length - 1; i >= 0; i--) {
            if (cromosoma[i] && sumando[i]) {
                if (acarreo) {
                    salida[i] = true;
                    acarreo   = true;
                } else {
                    salida[i] = false;
                    acarreo   = true;
                }
            } else if (cromosoma[i] || sumando[i]) {
                if (acarreo) {
                    salida[i] = false;
                    acarreo   = true;
                } else {
                    salida[i] = true;
                    acarreo   = false;
                }
            } else {
                if (acarreo) {
                    salida[i] = true;
                    acarreo   = false;
                } else {
                    salida[i] = false;
                    acarreo   = false;
                }
            }
        }

//      check overflow
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
    public boolean solucionIngenua() {
        boolean exito;

        do {
            cromosoma = generarSiguiteCromosoma(cromosoma, sumando);
            akari.quitarBombillosEIluminacion();
            exito = applicarCromosoma();
        } while (!exito &&!stop);

        return exito;
    }
}
