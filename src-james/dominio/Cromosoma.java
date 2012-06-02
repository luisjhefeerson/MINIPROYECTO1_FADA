//**********************************************************
// FUNDAMENTOS DE ANÁLISIS Y DISEÑO DE ALGORITMOS
// MINIPROYECTO 1: SOLUCIÓN PARA UN JUEGO DE LÓGICA: AKARI
//
// ARCHIVO: Cromosoma.java
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
public class Cromosoma {
    private long datos;
    private int  numeroCelulas;

    /**
     * Constructs ...
     *
     *
     * @param numeroCelulas
     */
    public Cromosoma(int numeroCelulas) {
        if (numeroCelulas > 64) {
            throw new java.lang.IllegalArgumentException("no se pueden crear matrices binarios con mas de 64 celulas");
        }

        this.numeroCelulas = numeroCelulas;
    }

    /**
     * Method description
     *
     *
     * @param index
     * @param valor
     */
    public void asignarBit(int index, long valor) {
        if (index < numeroCelulas) {
            datos = (datos | valor << index);
        } else {
            throw new java.lang.IndexOutOfBoundsException("La posicion indicada no se encuentra en el cromosoma");
        }
    }

    /**
     * Method description
     *
     *
     * @param index
     *
     * @return
     */
    public long obtenerBit(int index) {
        if (index < numeroCelulas) {
            long mask = 1 << index;

            return (datos & mask) >> index;
        } else {
            throw new java.lang.IndexOutOfBoundsException("La posicion indicada no se encuentra en el cromosoma");
        }
    }

    /**
     * @return the datos
     */
    public long getDatos() {
        return datos;
    }

    /**
     * @return the numeroCelulas
     */
    public int getNumeroCelulas() {
        return numeroCelulas;
    }
}
