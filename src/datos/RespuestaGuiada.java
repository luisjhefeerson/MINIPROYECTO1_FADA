//**********************************************************
// FUNDAMENTOS DE ANÁLISIS Y DISEÑO DE ALGORITMOS
// MINIPROYECTO 1: SOLUCIÓN PARA UN JUEGO DE LÓGICA: AKARI
//
// ARCHIVO: RespuestaNoTanIngenua.java
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
 * @version        12/05/30
 */
public class RespuestaGuiada {
    private boolean[][] casillasNoIluminadas;
    boolean[]           cromosoma;
    boolean[]           cromosomaNoIluminadas;

    /**
     * Constructs ...
     *
     *
     * @param cromosoma
     * @param cromosomaNoIluminadas
     * @param casillasNoIluminadas
     */
    public RespuestaGuiada(boolean[] cromosoma, boolean[] cromosomaNoIluminadas,
                                 boolean[][] casillasNoIluminadas) {
        this.cromosoma             = cromosoma;
        this.cromosomaNoIluminadas = cromosomaNoIluminadas;
        this.casillasNoIluminadas  = casillasNoIluminadas;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean[][] getCasillasNoIluminadas() {
        return casillasNoIluminadas;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean[] getCromosoma() {
        return cromosoma;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean[] getCromosomaNoIluminadas() {
        return cromosomaNoIluminadas;
    }
}
