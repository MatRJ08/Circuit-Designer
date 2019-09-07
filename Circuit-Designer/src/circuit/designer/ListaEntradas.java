package circuit.designer;
/**
 * @author Mathiw Rojas
 * @version 9V06A
 */
public class ListaEntradas {
    private Nodo head = null;
    private class Nodo{
        private Boolean dato;
        private Nodo Next;
        public Nodo(Boolean dato){
            this.dato = dato;
        }
        
        //*@version 08v30A*/
        public Boolean getDato(){
            return getDatoAux();
        }
        //*@version 08v30A*/
        private Boolean getDatoAux(){
            return this.dato;
        }
        
        //*@version 08v30A*/
        public void setDato(Boolean dato){
            setDatoAux(dato);
        }
        //*@version 08v30A*/
        private void setDatoAux(Boolean dato){
            this.dato= dato;
        }
        
        //*@version 08v30A*/
        public Nodo getNext(){
            return getNextAux();
        }
        //*@version 08v30A*/
        private Nodo getNextAux(){
            return this.Next;
        }
        
        //*@version 08v30A*/
        public void setNext(Nodo Next){
            setNextAux(Next);
        }
        //*@version 08v30A*/
        private void setNextAux(Nodo Next){
            this.Next= Next;
        }
        
    }
    //*@version 08v30A*/
    
    
    public Nodo getHead(){
        return getHeadAux();
    }
    //*@version 08v30A*/
    private Nodo getHeadAux(){
        return head;
    }               
                

    //*@version 08v30A*/
    public void agregarEntrada(Boolean dato){
        agregarEntradaAux(dato);
    }
    //*@version 09v09B*/
    public void agregarEntradaAux(Boolean dato){
        Nodo newnodo = new Nodo(dato);
        if(head != null){
            newnodo.setNext(head);
            head = newnodo;
        }
    }
    

    //*@version 09v09A*/
    public Boolean calcularOperacion(){
        if(head.getDato().equals("AND")){
            return calcularAnd();
        }
        else
            return false;
    }
    
    
    //*@version 09v09A*/
    private Boolean calcularAnd(){
        Nodo curr = head;
        while(curr != null){
            if(curr.getDato() == false){
                return false;
            }
        }
        return true;
    }
    
    
}
