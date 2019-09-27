package circuit.designer;
    
import javafx.application.Application;
import javafx.stage.Stage;

public class CircuitDesigner extends Application{
    
    /**
     * @param args the command line arguments
     */
    @Override
    public void start(Stage stage){
    Grafica grafica = new Grafica();
    grafica.start(new Stage());
    //        Circuito circuito = new Circuito();
    //        circuito.addCompuerta("OR");
    //        circuito.addCompuerta("NAND");
    //        circuito.addCompuerta("AND");
    //        circuito.addCompuerta("AND");
    //        circuito.Conectar(2,1);
    //        circuito.Conectar(3,2);
    //        circuito.Simular();
     }
    public static void main(String [] args){
        launch(args);
    }
    
}
