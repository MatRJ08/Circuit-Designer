package circuit.designer;

import com.sun.org.apache.bcel.internal.util.SecuritySupport;

import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Background;
import javafx.scene.shape.Line;

/**
 *
 * @author Keons
 */
public class Grafica extends Application{
    
    Group root = new Group();
    Scene scene = new Scene(root, 1300, 725, Color.WHITE);
    @Override
    /**
     * @see https://docs.oracle.com/javafx/2/scenegraph/jfxpub-scenegraph.htm 
     * @see https://docs.oracle.com/javafx/2/ui_controls/label.htm
     * @see https://www.tutorialspoint.com/javafx/2dshapes_line.htm
    */
     public void start(Stage stage){
         
        stage.setTitle("Circuit Designer");
        stage.setScene(scene);
         //Creating a line object
        Line line = new Line(); 

        //Setting the properties to a line 
        line.setStartX(100.0); 
        line.setStartY(150.0); 
        line.setEndX(500.0); 
        line.setEndY(150.0); 
        root.getChildren().add(line);
        stage.show();
        
        addObjeto("AND");
        addObjeto("OR");
        addObjeto("NOT");
        addObjeto("NAND");
        addObjeto("NOR");
        addObjeto("XOR");
        addObjeto("XNOR");
        addObjeto("ADD");
        
    }
    
     
    public static void main(String [] args){
        launch(args);
    }
    
    
    /**
    * @see https://stackoverflow.com/questions/29684450/javafx-positioning-of-a-button?rq=1
    * se saca como reposicionar un obejeto
    * 
    * @see  https://docs.oracle.com/javafx/2/drag_drop/HelloDragAndDrop.java.html
    * se saca logica del drag & drop, este depues es modificado a prueba y error
    * @verion 24M9A 
    */
    public void addObjeto(String tipo){
        Objeto objeto = new Objeto(tipo);
        if(tipo.equals("OR")){
            objeto.relocate(1150,190);
        }
        else if(tipo.equals("AND")){
            objeto.relocate(1150,10);
        }
        else if(tipo.equals("NAND")){
            objeto.relocate(1150,100);
        }
        else if(tipo.equals("NOT")){
            objeto.relocate(1150,280);
        }
        else if(tipo.equals("NOR")){
            objeto.relocate(1150,370);
        }
        else if(tipo.equals("XOR")){
            objeto.relocate(1150,460);
        }
        else if(tipo.equals("XNOR")){
            objeto.relocate(1150,550);
        }
        else if(tipo.equals("ADD")){
            objeto.relocate(350,550);
        }
//        objeto.relocate(200,200);   

        objeto.setOnMouseDragged(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");
                objeto.relocate(event.getSceneX(),event.getSceneY());
                addObjeto(tipo);
//                /* allow any transfer mode */
//                Dragboard db = objeto.startDragAndDrop(TransferMode.MOVE);
//                
//                /* put a string on dragboard */
//                ClipboardContent content = new ClipboardContent();
//                content.putString(objeto.getText());
//                db.setContent(content);
//                
                event.consume();
            }
        });
        objeto.setOnDragOver(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                System.out.println("onDragOver");
                
                /* accept it only if it is  not dragged from the same node 
                 * and if it has a string data */
//                if (event.getGestureSource() != target &&
//                        event.getDragboard().hasString()) {
//                    /* allow for both copying and moving, whatever user chooses */
//                }
                
                event.acceptTransferModes(TransferMode.MOVE);
                event.consume();
            }
        });
        System.out.print("Nuevo "+tipo+" creado \n");
        root.getChildren().add(objeto);
    }
    
    public class Objeto extends Label{
        String tipo;
        Boolean movido = false;
        public Objeto(String tipo){
            Image image = new Image(getClass().getResourceAsStream("/Imagenes/"+tipo+".png"));
            this.tipo = tipo;
            setBackground(Background.EMPTY);
            setGraphic(new ImageView(image));
        }
        
       
        
    }
}
