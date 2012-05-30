/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author jamespayan
 */
public class MatrizBinaria {
    private long [] datos;
    private int numeroFilas;
    private int numeroColumnas;
    
    public MatrizBinaria(int numeroFilas, int numeroColumnas){
        this(numeroFilas,numeroColumnas,false);
    }
    
    public MatrizBinaria(int numeroFilas, int numeroColumnas, boolean unos){ // crea una matriz de unos si la unos es verdadero
        if (numeroColumnas > 64)
            throw new java.lang.IllegalArgumentException("no se pueden crear matrices binarios con mas de 64 columnas");
        this.numeroFilas = numeroFilas;
        this.numeroColumnas = numeroColumnas;
        datos = new long[numeroFilas];
        if(unos){
            for (int i=0;i<numeroFilas;i++){
                datos[i]= (1l << numeroColumnas)-1;
            }
        }
    }
    
    public void asignarBitEnPosicion(int fila, int columna, long valor){
        if(columna<getNumeroColumnas() && fila < getNumeroFilas()){
            datos[fila] = (datos[fila] | valor << columna);
        }else{
            throw new java.lang.IndexOutOfBoundsException("La posicion indicada no se encuentra en la matriz");
        }
    }
    
    public long obtenerBirEnPosicion(int fila, int columna){
        if(columna<getNumeroColumnas() && fila < getNumeroFilas()){
            long mask = 1 << columna;
            return (datos[fila] & mask)>>columna;
        }else{
            throw new java.lang.IndexOutOfBoundsException("La posicion indicada no se encuentra en la matriz");
        }
    }
    
    public MatrizBinaria aplicarOR(MatrizBinaria matriz){
        if(matriz.getNumeroColumnas()==numeroColumnas && matriz.numeroFilas==numeroFilas){
            for(int i = 0; i<numeroColumnas;i++){
                datos[i] = (datos[i] | matriz.datos[i]);
            }
            return this;
        }else{
            throw new java.lang.IllegalArgumentException("La matriz debe tener el mismo tamaño");
        }
    }
    
    public boolean comparar(MatrizBinaria matriz){
        if(matriz.getNumeroColumnas()==numeroColumnas && matriz.numeroFilas==numeroFilas){
            for(int i = 0; i<numeroColumnas;i++){
                if(datos[i] != matriz.datos[i])
                    return false;
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * @return the datos
     */
    public long[] getDatos() {
        return datos;
    }



    /**
     * @return the numeroFilas
     */
    public int getNumeroFilas() {
        return numeroFilas;
    }



    /**
     * @return the numeroColumnas
     */
    public int getNumeroColumnas() {
        return numeroColumnas;
    }

}
