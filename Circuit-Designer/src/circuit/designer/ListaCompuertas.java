
package circuit.designer;

/**
 * @author Mathiw Rojas
 * @version 8V30A
 *@see  https://www.youtube.com/watch?v=TjlPQPRfWFk
 *se saca el machote para la lista enlazada
 */
public class ListaCompuertas {
    private Nodo primera;
    private class Nodo{
        public ClaseCompuertas compuerta;
        public Nodo siguiente;
        public Nodo(String operador){
            compuerta = new ClaseCompuertas(operador);
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
    public void AgregarCompuerta(String operador){
        Nodo nodo = new Nodo(operador);
        nodo.setSiguiente(primera);
        primera = nodo;
    }
}
