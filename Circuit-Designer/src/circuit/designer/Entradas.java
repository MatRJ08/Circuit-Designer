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
public class Entradas {
    private boolean valor;
    public Entradas(boolean valor){
        this.valor = valor;
    }
    private Boolean GetValorAux(){
        return this.valor;
    }
    public Boolean GetValor(){
        return this.GetValorAux();
    }
}
