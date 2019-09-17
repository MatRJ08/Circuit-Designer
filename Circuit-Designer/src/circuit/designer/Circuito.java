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
    int i = 0;
    int o = 0;
    int cantCompuertas = 0;
    
    Lista circuito = new Lista();
    
    public void addCompuerta(String tipo){        
        Compuertas compuerta = new Compuertas(tipo,++cantCompuertas,++o);
        Entradas_Salidas entrada = new Entradas_Salidas(true,++i);
        Entradas_Salidas entrada2 = new Entradas_Salidas(true,++i);
        compuerta.getEntradas().insertFirst(entrada);
        compuerta.getEntradas().insertFirst(entrada2);
        circuito.insertFirst(compuerta);
    }
    
    public void Conectar(int id1, int id2){        
        Compuertas compuerta1 = buscarId(id1);
        Compuertas compuerta2 = buscarId(id2);
        compuerta1.conectarEntradas(compuerta2,++i);
        compuerta2.conectarSalida(compuerta1);
        System.out.print("Conectado "+compuerta1.getTipo()+" con "+compuerta2.getTipo()+"\n");
    }
    
    
    public Compuertas buscarId(int id){
        Nodo current =  circuito.getHead();
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
        
        Nodo current =  circuito.getHead();
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
