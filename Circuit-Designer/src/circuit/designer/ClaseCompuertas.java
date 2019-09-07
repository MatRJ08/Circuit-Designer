package circuit.designer;


/**
 * @author Mathiw Rojas
 * @version 8V30B
 * @see https://es.stackoverflow.com/questions/26440/como-llama-a-un-metodo-desde-otra-class
 * se toma la como llamar a metodos de otras clases
 */
public class ClaseCompuertas {
    
    private String operador = null;
    private boolean salida = true;
    private ListaEntradas entrada;
    
    public ClaseCompuertas(String operador){
        this.operador = operador;
    }
    
    public String getOperador(){
        return this.getOperadorAux();
    }
    private String getOperadorAux(){
        return this.operador;
    }
    
    public Boolean getSalida(){
        return this.getSalidaAux();
    }
    public Boolean getSalidaAux(){
        if(entrada.getHead() != null){
            return entrada.calcularOperacion();
        }
        return true;
    }
    
}