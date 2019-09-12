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
public class Nodo {
    
    private Object data;
    private Nodo next;

    public Nodo(Object data){
        this.next= null;
        this.data = data;
    }

    public Object getData(){
        return this.data;

    }

    public void setData(Object data){
        this.data = data;

    }

    public Nodo getNext(){
        return this.next;

    }

    public void setNext(Nodo nodo){
        this.next = nodo;

    } 
}
