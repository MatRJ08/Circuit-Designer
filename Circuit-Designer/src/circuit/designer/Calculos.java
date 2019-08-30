package circuit.designer;

/**
 *
 * @author Keons
 */
public class Calculos {
    public Boolean calcularSalida(String operador,Boolean[] datos){
        if(operador.equals("And")){
            return calcularAnd(datos);
        }else{
            return false;
        }
    }
    
    private Boolean calcularAnd(Boolean[] datos){
        for(int i=0;i < datos.length-1 && datos.length > 2; i++){
            if(datos[i] != datos[i+1]){
                return false;
            }
        }
        return true;
    }
}
