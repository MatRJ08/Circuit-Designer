
package javaconfigmx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author Pablo Armando SaGoz
 */
public class Lineas extends Application {
    
    // Se genera el objeto Raíz         
    Group root = new Group();
    // Se le dan propiedades de incio a la Escena
    Scene scene = new Scene(root,350,270, Color.BURLYWOOD);
    @Override
    public void start(Stage primaryStage) {        
        
        // Linea 1
        // se contruye un objeto de tipo linea con las coordenas
        // de donde debe de aparecer dentro de Scene
        Line linea001 = new Line(10,10,340,10);
        // Se asina el color de relleno de la linea
        linea001.setStroke(Color.STEELBLUE);
        // Se indica el grosor que tendra nuestra linea 
        linea001.setStrokeWidth(10);
        // se indica el tipo de punta que tendra la linea
        linea001.setStrokeLineCap(StrokeLineCap.ROUND);
        // se agrega la linea al Scene.
        root.getChildren().add(linea001);        

    // se crea el titulo para presentar el escenario principal
    primaryStage.setTitle("JavaConfigMx ~ Lineas");
    primaryStage.setScene(scene);
    primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
