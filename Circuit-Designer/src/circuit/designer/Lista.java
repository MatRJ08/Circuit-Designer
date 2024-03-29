/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuit.designer;

/**
 *
 * @author Keons
 */
public class Lista {
    private Nodo head;
    private int size;
  
    public Lista(){
        this.head= null;
        this.size = 0;
    }
    /**
     * Función para saber si la lista está vacía
     * @return true si está vacía o false si no lo está
     */
    public boolean isEmpty(){
        return this.head == null;
    }
    
    
    /**
     * Función qe crea un nodo a partir de los datos que se ingresen y lo pone al inicio de la lista
     * @param data 
     */
    public void insertFirst(Object data){
        if (head==null){
            head = new Nodo(data);
            head.setNext(null);
        }
        else{
          Nodo temp = head;
          Nodo newNodo = new Nodo(data);
          newNodo.setNext(temp);
          head = newNodo;
          
        }
        this.size++;

    }
   
    /**
     * Función que elimina el primer nodo de una lista
     * @return El nodo que se eliminó o null si la lista estaba vacía
     */
    public Nodo deleteFirst(){

        if (this.head != null) {
            Nodo temp = this.head;
            this.head = this.head.getNext();
            this.size--;
            return temp;

        }else{
             return null;

        }
    }
    
    /**
     * Método para imprimir en consola una lista
     * @param list  Lista que se quiere imprimir
     */
    public void printList(Lista list) { 
        
        Nodo current = list.head; 
   
        System.out.print("Lista: "); 
        while (current != null) { 
            System.out.print(current.getData() + " "); 
   
            current = current.getNext(); 
        } 
    }

    public Nodo getHead() {
        return head;
    }
    /**
     * Función para saber el tamaño de la lista
     * @return El tamaño de la lista
     */
    public int getSize() {
        return size;
    }
    
}
