
package circuit.designer;

/**
 * @author Mathiw Rojas
 @version 09v09A
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
        
        
        //*@version 09v09A*/
        public Nodo getSiguiente(){
            return getSiguienteAux();
        }
        //*@version 09v09A*/
        private Nodo getSiguienteAux(){
            return this.siguiente;
        }
        
        
        //*@version 09v09A*/
        public void setSiguiente(Nodo siguiente){
            setSiguienteAux(siguiente);
        }
        //*@version 09v09A*/
        private void setSiguienteAux(Nodo siguiente){
            this.siguiente= siguiente;
        }
        
        
        //*@version 09v09A*/
        public void AgregarCompuerta(String operador){
            Nodo nodo = new Nodo(operador);
            nodo.setSiguiente(primera);
            primera = nodo;
        }
        
    }
}
