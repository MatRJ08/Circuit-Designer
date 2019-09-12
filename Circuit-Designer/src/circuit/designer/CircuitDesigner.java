package circuit.designer;

    public class CircuitDesigner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista l2 = new Lista();
        ClaseCompuertas compuerta = new ClaseCompuertas("And");
        Entradas entrada1 = new Entradas(true);
        Entradas entrada2 = new Entradas(false);
        l2.insertFirst(compuerta);
        ClaseCompuertas entrada = (ClaseCompuertas)l2.getHead().getData();
        entrada.getEntradas().insertFirst(entrada1);
        entrada.getEntradas().insertFirst(entrada2);
        System.out.print(entrada.getSalida());
        //l2.ConectarEntrada(true);
        //System.out.print(l2.getSalida());
    }
    
}
