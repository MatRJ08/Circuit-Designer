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
     * Función que busca un objeto en la lista y retorna la cantidad de veces que se encontró dicho parámetro
     * @param x 
     * @return La cantidad de veces que encontró a x en la lista
     */
    public int searchAmount(boolean x){ 
        int amount=0;
        Nodo current = head;
        
        while (current != null){ 
            ClaseCompuertas actual =(ClaseCompuertas)current.getData();
            if (actual.valor == x) 
                amount++; 
                 
            current = current.getNext(); 
        } 
        return amount;     
    }
    
    
    /**
     * Función que permite buscar un nodo de la lista por el ídice en el que se encuentra
     * @param index Indice de la lista que se quiere buscar
     * @return datos que contiene el nodo que se encuetra en ese índice
     */
    public Object searchByIndex(int index){
        int counter=0;
        Nodo temp= head;
        while (counter<index){
            temp=temp.getNext();
            counter++;
            
        }
        return temp.getData();
    } 
    /**
     * Función que busca un nodo en una lista de instancias de ClaseCompuertas según su atributo de ID
     * @param id
     * @return La información del nodo que tiene esa ID o null si la ID no existe
     */
    public Object searchByID(int id){
        Nodo current=head;
        while(current!=null){
            ClaseCompuertas actual= (ClaseCompuertas)current.getData();
            if(actual.id==id){
                return current.getData();
            }
            else{
                current=current.getNext();
            }
        }
        return null;
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
    
    public void updateGates(Lista circuito){
        
        Nodo current = circuito.getHead();
        while (current != null){
            ClaseCompuertas actual = (ClaseCompuertas)current.getData();
            actual.operacion();
            current = current.getNext();
        }
    }
}
