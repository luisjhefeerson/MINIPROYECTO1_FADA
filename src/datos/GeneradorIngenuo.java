//**********************************************************
// FUNDAMENTOS DE ANÁLISIS Y DISEÑO DE ALGORITMOS
// MINIPROYECTO 1: SOLUCIÓN PARA UN JUEGO DE LÓGICA: AKARI
//
// ARCHIVO: GeneradorIngenuo.java
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

import datos.AkariFile;

public class GeneradorIngenuo {

    AkariFile akari;
    int casillasEnBlanco;
    int numeroCromosoma;
    int[] cromosoma;

    public GeneradorIngenuo(AkariFile tablero) {
        numeroCromosoma = 0;
        this.akari = tablero;
        casillasEnBlanco = tablero.getCasillasBlancas();
        System.out.println("Casillas en Blanco: " + casillasEnBlanco);
    }

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
            cromosoma[cromosoma.length - 1 - i] = Integer.parseInt(numeroEnBinario.substring(numeroEnBinario.length() - 1 - i,
                    numeroEnBinario.length() - i));
        }
        System.out.print("\n");
        return cromosoma;
    }

    public boolean applicarCromosoma() {

        int counter = 0;

        for (int i = 0; i < akari.getNumeoFilas(); i++) {
            for (int j = 0; j < akari.getNumeroColumnas(); j++) {

                if (akari.getTablero()[i][j] == 0) {
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
        return akari.validation();
    }

    public boolean solucionIngenua() {

        generarSiguiteCromosoma();
        boolean b = applicarCromosoma();

        while ((!b) && (numeroCromosoma < Math.pow(2, casillasEnBlanco) - 1)) {
            System.out.println("Aplicar Cromosoma: " + numeroCromosoma + "Resultado: " + b);
            generarSiguiteCromosoma();
            akari.inicializarMatriz();
            b = applicarCromosoma();
        }
        return b;
    }
}
