package circuit.designer;

import circuit.designer.Calculos;

/**
 * @author Mathiw Rojas
 * @version 8V30B
 * @see https://es.stackoverflow.com/questions/26440/como-llama-a-un-metodo-desde-otra-class
 * se toma la como llamar a metodos de otras clases
 */
public class ClaseCompuertas {
    
    private Calculos misCalculos = new Calculos();
    private String operador = null;
    
    public ClaseCompuertas(String operador){
        this.operador = operador;
    }
    
    public String getOperador(){
        return getOperadorAux();
    }
    private String getOperadorAux(){
        return this.operador;
    }
    
    public Boolean getSalida(){
        return getSalidaAux();
    }
    public Boolean getSalidaAux(){
        Boolean lol[]={true};
        return misCalculos.calcularSalida(operador, lol);
    }
    
}