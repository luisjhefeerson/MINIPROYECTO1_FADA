//**********************************************************
// FUNDAMENTOS DE ANÁLISIS Y DISEÑO DE ALGORITMOS
// MINIPROYECTO 1: SOLUCIÓN PARA UN JUEGO DE LÓGICA: AKARI
//
// ARCHIVO: AkariFile.java
//
// FECHA: 12/05/14
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

    int contador;
    int casillasEnBlanco;
    AkariFile akari;
    int[] cromosoma;

    public GeneradorIngenuo(AkariFile tablero) {

        contador = 0;
        this.akari = tablero;
        casillasEnBlanco = tablero.getCasillasBlancas();
    }

    public int[] generarSiguiteCromosoma() {

        contador++;
        String binario = Integer.toBinaryString(contador);

        System.out.println("Casillas en Blanco: " + casillasEnBlanco);
        cromosoma = new int[casillasEnBlanco];

        for (int i = 0; i < cromosoma.length; i++) {
            cromosoma[i] = 0;
        }

        System.out.println("String Binario: " + binario);

        for (int i = 0; i < binario.length(); i++) {
            cromosoma[cromosoma.length - 1 - i] = Integer.parseInt(binario.substring(binario.length() - 1 - i, binario.length() - i));
        }

        System.out.println("Cromosoma: " + contador);
        for (int i = 0; i < cromosoma.length; i++) {
            System.out.print(cromosoma[i] + " ");

        }

        System.out.println("");


        return cromosoma;
    }

    public boolean applicarCromosoma() {

        int counter = 0;
        
        
        for (int i = 0; i < akari.getNumeoFilas(); i++) {
            for (int j = 0; j < akari.getNumeroColumnas(); j++) {

                if (akari.getTablero()[i][j] == 0) {
                    if (cromosoma[counter] == 1) {
                        if (!akari.ponerBombillo(i, j)) {
                            return false;
                        }
                    }
                    counter++;
                }
            }
        }
        return akari.validation();
    }
    
    
    public boolean solucionIngenua(){
        
        generarSiguiteCromosoma();
        boolean b = applicarCromosoma(); 
        while ((!b) && contador<Math.pow(2, casillasEnBlanco)-1) {            
            System.out.println("Aplicar Cromosoma: "+contador+"Resultado: "+b );
            
            generarSiguiteCromosoma();
            akari.inicializarMatriz();
            b = applicarCromosoma();
//            if(contador == Math.pow(2, casillasEnBlanco)-1 && !b){
//                return false;
//            }
        }
        
        return b;
        
    }
}
