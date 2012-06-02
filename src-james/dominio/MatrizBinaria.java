//**********************************************************
// FUNDAMENTOS DE ANÁLISIS Y DISEÑO DE ALGORITMOS
// MINIPROYECTO 1: SOLUCIÓN PARA UN JUEGO DE LÓGICA: AKARI
//
// ARCHIVO: MatrizBinaria.java
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


package dominio;

/**
 *
 * @author jamespayan
 */
public class MatrizBinaria {
    private long[] datos;
    private int    numeroColumnas;
    private int    numeroFilas;

    /**
     * Constructs ...
     *
     *
     * @param numeroFilas
     * @param numeroColumnas
     */
    public MatrizBinaria(int numeroFilas, int numeroColumnas) {
        this(numeroFilas, numeroColumnas, false);
    }

    /**
     * Constructs ...
     *
     *
     * @param numeroFilas
     * @param numeroColumnas
     * @param unos
     */
    public MatrizBinaria(int numeroFilas, int numeroColumnas, boolean unos) {    // crea una matriz de unos si la unos es verdadero
        if (numeroColumnas > 64) {
            throw new java.lang.IllegalArgumentException("no se pueden crear matrices binarios con mas de 64 columnas");
        }

        this.numeroFilas    = numeroFilas;
        this.numeroColumnas = numeroColumnas;
        datos               = new long[numeroFilas];

        if (unos) {
            for (int i = 0; i < numeroFilas; i++) {
                datos[i] = (1l << numeroColumnas) - 1;
            }
        }
    }

    /**
     * Method description
     *
     *
     * @param matriz
     *
     * @return
     */
    public MatrizBinaria aplicarOR(MatrizBinaria matriz) {
        if ((matriz.getNumeroColumnas() == numeroColumnas) && (matriz.numeroFilas == numeroFilas)) {
            for (int i = 0; i < numeroColumnas; i++) {
                datos[i] = (datos[i] | matriz.datos[i]);
            }

            return this;
        } else {
            throw new java.lang.IllegalArgumentException("La matriz debe tener el mismo tamaño");
        }
    }

    /**
     * Method description
     *
     *
     * @param fila
     * @param columna
     * @param valor
     */
    public void asignarBitEnPosicion(int fila, int columna, long valor) {
        if ((columna < getNumeroColumnas()) && (fila < getNumeroFilas())) {
            datos[fila] = (datos[fila] | valor << columna);
        } else {
            throw new java.lang.IndexOutOfBoundsException("La posicion indicada no se encuentra en la matriz");
        }
    }

    /**
     * Method description
     *
     *
     * @param matriz
     *
     * @return
     */
    public boolean comparar(MatrizBinaria matriz) {
        if ((matriz.getNumeroColumnas() == numeroColumnas) && (matriz.numeroFilas == numeroFilas)) {
            for (int i = 0; i < numeroColumnas; i++) {
                if (datos[i] != matriz.datos[i]) {
                    return false;
                }
            }

            return true;
        } else {
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
    public long obtenerBirEnPosicion(int fila, int columna) {
        if ((columna < getNumeroColumnas()) && (fila < getNumeroFilas())) {
            long mask = 1 << columna;

            return (datos[fila] & mask) >> columna;
        } else {
            throw new java.lang.IndexOutOfBoundsException("La posicion indicada no se encuentra en la matriz");
        }
    }

    /**
     * @return the datos
     */
    public long[] getDatos() {
        return datos;
    }

    /**
     * @return the numeroColumnas
     */
    public int getNumeroColumnas() {
        return numeroColumnas;
    }

    /**
     * @return the numeroFilas
     */
    public int getNumeroFilas() {
        return numeroFilas;
    }
}
