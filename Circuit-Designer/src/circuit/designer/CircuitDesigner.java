package circuit.designer;
    
    public class CircuitDesigner {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circuito circuito = new Circuito();
        circuito.addCompuerta("OR");
        circuito.addCompuerta("NAND");
        circuito.addCompuerta("AND");
        circuito.Conectar(2,1);
        circuito.Conectar(3,2);
        circuito.Simular();
//        Lista l2 = new Lista();
//        ClaseCompuertas compuerta = new ClaseCompuertas("XNOR");
//        Entradas entrada1 = new Entradas(false,1);
//        Entradas entrada2 = new Entradas(true,2);
//        l2.insertFirst(compuerta);
//        ClaseCompuertas entrada = (ClaseCompuertas)l2.getHead().getData();
//        entrada.getEntradas().insertFirst(entrada1);
//        entrada.getEntradas().insertFirst(entrada1);
//        entrada.getEntradas().insertFirst(entrada1);
//        entrada.getEntradas().insertFirst(entrada1);
//        ClaseCompuertas compuerta2 = new ClaseCompuertas("AND");
//        compuerta2.getEntradas().insertFirst(entrada2);
//        compuerta2.getEntradas().insertFirst(entrada2);
//        l2.insertFirst(compuerta2);
//        entrada.conectarCompuertas(compuerta2);
//        System.out.print(entrada.getSalida());
;
        
    }
    
}
