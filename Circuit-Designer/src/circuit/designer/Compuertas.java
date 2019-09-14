package circuit.designer;


/**
 * @author Mathiw Rojas
 * @version 9V13B
 * @see https://es.stackoverflow.com/questions/26440/como-llama-a-un-metodo-desde-otra-class
 * se toma la como llamar a metodos de otras clases
 */
public class Compuertas{
    private int id = 0;
    private Lista InputGates;
    private Entradas_Salidas OutputGate;
    private String tipo;
    
    
    public Compuertas(String tipo,int id, int o){
        this.tipo = tipo;
        this.id = id;
        System.out.print(id);
        this.InputGates=new Lista();
        this.OutputGate = new Entradas_Salidas(true, o);
    }
    
    public void operacion( ){
        Nodo current = InputGates.getHead();
        if(current == null)
            OutputGate.setValor(true);
        switch(this.tipo){
            
            case "XOR":
                this.OutputGate.setValor(false);
                Entradas_Salidas entrada = (Entradas_Salidas)current.getData();
                Boolean valorAnterior = entrada.getValor();
                current = current.getNext();         
                while (current!= null){
                    entrada = (Entradas_Salidas)current.getData();
                    if(entrada.getValor() != valorAnterior){
                        this.OutputGate.setValor(true);
                        break;
                    }
                current = current.getNext();         
                }
                break;   
                
            case "XNOR":
                this.OutputGate.setValor(true);
                entrada = (Entradas_Salidas)current.getData();
                valorAnterior = entrada.getValor();
                current = current.getNext();         
                while (current!= null){
                    entrada = (Entradas_Salidas)current.getData();
                    if(entrada.getValor() != valorAnterior){
                        this.OutputGate.setValor(false);
                        break;
                    }
                current = current.getNext();         
                }
                break;   
            
            case "AND":
                this.OutputGate.setValor(true);
                while (current!= null){
                    entrada = (Entradas_Salidas)current.getData();
                    if(!entrada.getValor()){
                        this.OutputGate.setValor(false);
                        break;
                    }else{
                        current = current.getNext();
                    }            
                }
                break;
                
            case "OR":
                this.OutputGate.setValor(false);
                while (current!= null){
                    entrada = (Entradas_Salidas)current.getData();
                    if(entrada.getValor()){
                        this.OutputGate.setValor(true);
                        break;
                    }else{
                        current = current.getNext();
                    }            
                }
                break;                
                
            case "NAND":
                this.OutputGate.setValor(false);
                while (current!= null){
                    entrada = (Entradas_Salidas)current.getData();
                    if(!entrada.getValor()){
                        this.OutputGate.setValor(true);
                        break;
                    }else{
                        current = current.getNext();
                    }            
                }
                break;                
                
            case "NOR":
                this.OutputGate.setValor(true);
                while (current!= null){
                    entrada = (Entradas_Salidas)current.getData();
                    if(entrada.getValor()){
                        this.OutputGate.setValor(false);
                        break;
                    }else{
                        current = current.getNext();
                    }            
                }
                break;   
                
                
        }  
    }

    
    private int getIdAux() {
        return id;
    }
    public int getId(){
        return getIdAux();
    }
    
    
    public Lista getEntradas(){
        return this.InputGates;
    }
    
    public Entradas_Salidas getSalida(){
        operacion();
        return this.OutputGate;
    }
    
    
    private void conectarEntradasAux(Compuertas compuerta, int i){ 
        Entradas_Salidas entrada = new Entradas_Salidas(compuerta.getSalida().getValor(),i);    
        entrada.setCompuerta(compuerta);
        this.InputGates.insertFirst(entrada);
    }
    public void conectarEntradas(Compuertas compuerta, int i){
        this.conectarEntradasAux(compuerta,i);
    }
    
    
    private void conectarSalidaAux(Compuertas compuerta){ 
        this.OutputGate.setCompuerta(compuerta);
    }
    public void conectarSalida(Compuertas compuerta){
        this.conectarSalidaAux(compuerta);
    }
    
    
    public String getTipoAux(){
        return this.tipo;
    }
    public String getTipo(){
        return this.getTipoAux();
    }
    
    
    
}