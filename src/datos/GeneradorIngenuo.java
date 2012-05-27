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
    AkariFile tablero;

    public GeneradorIngenuo(AkariFile tablero) {

        contador = 0;
        this.tablero = tablero;
        casillasEnBlanco = tablero.getCasillasBlancas();
    }

    public int[] generarSiguiteCromosoma() {

        contador++;
        String binario = Integer.toBinaryString(contador);

//        System.out.println("Casillas en Blanco: "+casillasEnBlanco);
        int[] cromosoma = new int[casillasEnBlanco];

        for (int i = 0; i < cromosoma.length; i++) {
            cromosoma[i] = 0;
        }
        
//        System.out.println("String Binario: "+binario);

        for (int i = 0; i < binario.length(); i++) {
            cromosoma[cromosoma.length-1-i] = Integer.parseInt(binario.substring(binario.length()-1-i, binario.length()-i));
        }

//        System.out.println("Cromosoma: " + contador);
        for (int i = 0; i < cromosoma.length; i++) {
//            System.out.print(cromosoma[i] + " ");

        }
        
//        System.out.println("");
        

        return cromosoma;
    }
    
    
    public void crearTodosLosCromosomas(){
        
        for (int i = 0; i < Math.pow(2, casillasEnBlanco); i++) {
            generarSiguiteCromosoma();
        }
        
                System.exit(0);
    }
}
