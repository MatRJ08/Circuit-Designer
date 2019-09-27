package circuit.designer;

/**
 *
 * @author Mat
 */
public class Entradas_Salidas {
    private boolean valor;
    private Compuertas compuerta = null;
    private int indice;
    
    public Entradas_Salidas(boolean valor, int indice){
        this.valor = valor;
        this.indice = indice;
    }
    
    
    private Boolean getValorAux(){
        return this.valor;
    }    
    public Boolean getValor(){
        return this.getValorAux();
    }
    
    
    private void setValorAux(Boolean valor){
         this.valor = valor ;
    }    
    public void setValor(Boolean valor){
        this.setValorAux(valor);
    }
    
    
    private Compuertas getCompuertaAux(){
        return this.compuerta;
    }    
    public Compuertas getCompuerta(){
        return this.getCompuertaAux();
    }
    
    
    private void setCompuertaAux(Compuertas compuerta){
        this.compuerta = compuerta;
    }
    public void setCompuerta(Compuertas compuerta){
        this.setCompuertaAux(compuerta);
    }
    
    
    private int getIndiceAux(){
        return this.indice;
    }
    public int getIndice(){
        return this.getIndiceAux();
    }
    
    
}
