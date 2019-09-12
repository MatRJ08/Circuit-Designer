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
        while (current!= null){
            Entradas entrada = (Entradas)current.getData();
            if(entrada.GetValor()){
                this.OutputGates =  false;
                break;
            }else{
                current = current.getNext();
            }            
        }
        if(current == null)
            OutputGates =  true;
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
  
//class AND extends ClaseCompuertas{
//    
//    @Override
//    public void operacion(){
//        this.valor = !(InputGates.searchAmount(false)!=0);
//    }
//}
//
//class NAND extends ClaseCompuertas{
//
//    @Override
//    public void operacion(){
//        this.valor = (InputGates.searchAmount(false)!=0);
//    }
//}
//
//class OR extends ClaseCompuertas{
//    @Override
//    public void operacion(){
//        this.valor = (InputGates.searchAmount(true)!=0);
//    }
//}
//class NOR extends ClaseCompuertas{
//    @Override
//    public void operacion(){
//        this.valor = !(InputGates.searchAmount(true)!=0);
//    } 
//}
//class NOT extends ClaseCompuertas{
//    
//    @Override
//    public void operacion(){
//        this.valor= !((boolean)InputGates.getHead().getData()); 
//    }
//}
//
//class XOR extends ClaseCompuertas{
//    @Override
//    public void operacion(){
//        this.valor= (InputGates.searchAmount(true)%2!=0);
//    }
//}
//
//class XNOR extends ClaseCompuertas{
//    @Override
//    public void operacion(){
//        this.valor= !(InputGates.searchAmount(true)%2!=0);
//    }
//}