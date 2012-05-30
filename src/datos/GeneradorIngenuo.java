//**********************************************************
// FUNDAMENTOS DE ANÁLISIS Y DISEÑO DE ALGORITMOS
// MINIPROYECTO 1: SOLUCIÓN PARA UN JUEGO DE LÓGICA: AKARI
//
// ARCHIVO: GeneradorIngenuo.java
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
 * @version        12/05/28
 */
public class GeneradorIngenuo {
    AkariGame akari;
    int       casillasEnBlanco;
    int[]     cromosoma;
    int       numeroCromosoma;

    /**
     * Constructs ...
     *
     *
     * @param tablero
     */
    public GeneradorIngenuo(AkariGame tablero) {
        numeroCromosoma  = 0;
        this.akari       = tablero;
        casillasEnBlanco = tablero.getCasillasBlancas();
        System.out.println("Casillas en Blanco: " + casillasEnBlanco);
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
        cromosoma = new int[casillasEnBlanco];

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
                if (akari.getTableroCasillasNegras()[i][j] == 0) {
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

        return akari.validation(false);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean solucionIngenua() {
        generarSiguiteCromosoma();

        boolean b = applicarCromosoma();

        while ((!b) && (numeroCromosoma < Math.pow(2, casillasEnBlanco) - 1)) {
            generarSiguiteCromosoma();
            akari.inicializarMatriz();
            b = applicarCromosoma();
            System.out.println("Aplicar Cromosoma: " + numeroCromosoma + " Resultado: " + b + "\n\n");
        }

        return b;
    }
}
