package circuit.designer;
/**
 * @author Mathiw Rojas
 * @version 8V30A
 */
public class ListaEntradas {
    Nodo primera = null;
    private class Nodo{
        private Boolean dato;
        public Nodo siguiente;
        public Nodo(Boolean dato){
            this.dato = dato;
        }
        
        public Boolean getDato(){
            return getDatoAux();
        }
        private Boolean getDatoAux(){
            return this.dato;
        }
        
        public void setDato(Boolean dato){
            setDatoAux(dato);
        }
        private void setDatoAux(Boolean dato){
            this.dato= dato;
        }
        
        public Nodo getSiguiente(){
            return getSiguienteAux();
        }
        private Nodo getSiguienteAux(){
            return this.siguiente;
        }
        
        public void setSiguiente(Nodo siguiente){
            setSiguienteAux(siguiente);
        }
        private void setSiguienteAux(Nodo siguiente){
            this.siguiente= siguiente;
        }
        
        
    }
    
    public void agregarEntrada(Boolean dato){
        Nodo nodo = new Nodo(dato);
        nodo.setSiguiente(primera);
        primera = nodo;
    }
    
}
