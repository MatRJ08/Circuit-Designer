/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuit.designer;

import javax.swing.JOptionPane;

/**
 *
 * @author Keons
 */
public class Circuito {
    private int i;
    private int o;
    
    Lista circuitList = new Lista();
    
    public Circuito(){
        o = 0;
        i=0;
    }

    public int getI() {
        return i;
    }
    
    
    
    public Compuertas addCompuerta(String tipo,int id){        
        Compuertas compuerta = new Compuertas(tipo,id,++o);
//        Entradas_Salidas entrada = new Entradas_Salidas(true,++i);
//        Entradas_Salidas entrada2 = new Entradas_Salidas(true,++i);
//        compuerta.getEntradas().insertFirst(entrada);
//        compuerta.getEntradas().insertFirst(entrada2);
        circuitList.insertFirst(compuerta);
        return compuerta;
    }
    
    
    public void Conectar(int id1, int id2){        
        Compuertas compuerta1 = buscarId(id1);
        Compuertas compuerta2 = buscarId(id2);
        compuerta2.conectarEntradas(compuerta1,++i);
        compuerta1.conectarSalida(compuerta2);
        System.out.print("Conectado "+compuerta1.getTipo()+" con "+compuerta2.getTipo()+"\n");
    }
    
    
    public void ConectarBool(String valor, int id2){ 
        System.out.print(valor);
        Compuertas compuerta1 = new Compuertas(valor, 0, 0);
        Compuertas compuerta2 = buscarId(id2);
        compuerta2.conectarEntradas(compuerta1,++i);
        compuerta1.conectarSalida(compuerta2);
        System.out.print("Conectado "+compuerta1.getTipo()+" con "+compuerta2.getTipo()+"\n");
    }
    
    
    public Compuertas buscarId(int id){
        Nodo current =  circuitList.getHead();
        Compuertas compuerta;
        while(current != null){
            compuerta = (Compuertas)current.getData();
            
            if(compuerta.getId() == id){
                return compuerta;         
            }else{
                current = current.getNext();                
            }
            
        }
        
        return null;
    }
    
    
    public void Simular(){
        Compuertas compuerta = buscarFinal();
        if(compuerta == null){
            System.err.print("No se puede simular");
        }else
            System.out.print(compuerta.getSalida().getValor());
    }
    
    
    public Compuertas buscarFinal(){
        
        Nodo current =  circuitList.getHead();
        Compuertas compuerta;
        Compuertas ultima = null;
        int bandera = 0;
        
        while(current != null){
            
            compuerta = (Compuertas)current.getData();
            Entradas_Salidas salida = compuerta.getSalida();
            
            if(salida.getCompuerta() == null){
                
                if(bandera > 0){
                    JOptionPane.showMessageDialog(null,"No se puede simular, una o más de las compuertas, no se encuentran conectadas al circuito", "Fallo de simulación",JOptionPane.ERROR_MESSAGE);
                    return null;
                }
                
                ultima = compuerta;  
                bandera++;
                current = current.getNext();  
                
            }else{
                current = current.getNext();                
            }
            
        }
        
        if(bandera == 0){            
            JOptionPane.showMessageDialog(null,"No se puede simular, el circuito no posee una salida definida", "Fallo de simulación",JOptionPane.ERROR_MESSAGE);
        }
        
        return ultima;
    }
    
    
    
}
