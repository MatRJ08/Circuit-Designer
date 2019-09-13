package circuit.designer;


/**
 * @author Mathiw Rojas
 * @version 8V30B
 * @see https://es.stackoverflow.com/questions/26440/como-llama-a-un-metodo-desde-otra-class
 * se toma la como llamar a metodos de otras clases
 */
public class ClaseCompuertas{
    int id;
    Lista InputGates;
    boolean OutputGates;
    boolean valor;
    String tipo;
    
    
    public ClaseCompuertas(String tipo){
        this.tipo = tipo;
        InputGates=new Lista();
    }
    public void operacion( ){
        Nodo current = InputGates.getHead();
        if(current == null)
            OutputGates =  true;
        switch(this.tipo){
            
            case "XOR":
                this.OutputGates = false;
                Entradas entrada = (Entradas)current.getData();
                Boolean valorAnterior = entrada.GetValor();
                current = current.getNext();         
                while (current!= null){
                    entrada = (Entradas)current.getData();
                    if(entrada.GetValor() != valorAnterior){
                        this.OutputGates =  true;
                        break;
                    }
                current = current.getNext();         
                }
                break;   
                
            case "XNOR":
                this.OutputGates = true;
                entrada = (Entradas)current.getData();
                valorAnterior = entrada.GetValor();
                current = current.getNext();         
                while (current!= null){
                    entrada = (Entradas)current.getData();
                    if(entrada.GetValor() != valorAnterior){
                        this.OutputGates =  false;
                        break;
                    }
                current = current.getNext();         
                }
                break;   
            
            case "AND":
                this.OutputGates = true;
                while (current!= null){
                    entrada = (Entradas)current.getData();
                    if(!entrada.GetValor()){
                        this.OutputGates =  false;
                        break;
                    }else{
                        current = current.getNext();
                    }            
                }
                break;
                
            case "OR":
                this.OutputGates = false;
                while (current!= null){
                    entrada = (Entradas)current.getData();
                    if(entrada.GetValor()){
                        this.OutputGates =  true;
                        break;
                    }else{
                        current = current.getNext();
                    }            
                }
                break;                
                
            case "NAND":
                this.OutputGates = false;
                while (current!= null){
                    entrada = (Entradas)current.getData();
                    if(!entrada.GetValor()){
                        this.OutputGates =  true;
                        break;
                    }else{
                        current = current.getNext();
                    }            
                }
                break;                
                
            case "NOR":
                this.OutputGates = true;
                while (current!= null){
                    entrada = (Entradas)current.getData();
                    if(entrada.GetValor()){
                        this.OutputGates =  false;
                        break;
                    }else{
                        current = current.getNext();
                    }            
                }
                break;   
                
                
        }  
    }

    public int getId() {
        return id;
    }

    public boolean isValor() {
        return valor;
    }
    
    public Lista getEntradas(){
        return this.InputGates;
    }
    
    public Boolean getSalida(){
        operacion();
        return this.OutputGates;
    }
    
}