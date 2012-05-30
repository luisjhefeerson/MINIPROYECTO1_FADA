/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author jamespayan
 */
public class Cromosoma {
    private long datos;
    private int numeroCelulas;
    
    public Cromosoma(int numeroCelulas){
        if (numeroCelulas > 64)
            throw new java.lang.IllegalArgumentException("no se pueden crear matrices binarios con mas de 64 celulas");
        this.numeroCelulas=numeroCelulas;
    }
    
    public void asignarBit(int index, long valor){
        if(index<numeroCelulas){
            datos= (datos | valor << index);
        }else{
            throw new java.lang.IndexOutOfBoundsException("La posicion indicada no se encuentra en el cromosoma");
        }
    }
    
    public long obtenerBit(int index){
        if(index<numeroCelulas){
            long mask = 1 << index;
            return (datos & mask)>>index;
        }else{
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
