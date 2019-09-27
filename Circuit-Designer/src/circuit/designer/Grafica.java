package circuit.designer;

import com.sun.org.apache.bcel.internal.util.SecuritySupport;
import javafx.event.ActionEvent;
import java.util.Random;

import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Background;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;

/**
 *
 * @author Mat
 * @version 25M09A
 */

public class Grafica extends Application{
    
    Group root = new Group();
    Scene scene = new Scene(root, 1300, 725, Color.WHITE);
    int lineasIds = 0;
    int objetosIds = 0;
    Random rand = new Random();
    
    Circuito circuito = new Circuito();
    boolean drawing = false;
    Objeto entrada = null;
    Objeto salida = null;
    
    Lista entradas = new Lista();
    
    int oIds = 0;
    int iIds = 0;
    
    
//    static Stage classStage = new Stage();
    
    @Override
    /**
     * @see https://docs.oracle.com/javafx/2/scenegraph/jfxpub-scenegraph.htm 
     * @see https://docs.oracle.com/javafx/2/ui_controls/label.htm
     * @see http://www.java2s.com/Code/Java/JavaFX/AddClickactionlistenertoButton.htmS
    */
     public void start(Stage stage){
        
//        classStage = stage;
         
        stage.setTitle("Circuit Designer");
        stage.setScene(scene);
        
        stage.show();
       
        Button simular =new Button("Simular");
        simular.relocate(50, 675);
        Button btngenerarTabla =new Button("Generar Tabla");
        simular.relocate(100, 675);
        simular.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                circuito.Simular();
            }
        });
        btngenerarTabla.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                generarTabla();
            }
        });
        root.getChildren().addAll(simular,btngenerarTabla);
        addObjeto("AND");
        addObjeto("OR");
        addObjeto("NOT");
        addObjeto("NAND");
        addObjeto("NOR");
        addObjeto("XOR");
        addObjeto("XNOR");
        addObjeto("TRUE");
        addObjeto("FALSE");
        
    }
    
     
    public static void main(String [] args){
        launch(args);
    }
    
    
    public void generarTabla(){
        TableView tablaEntradas = new TableView();
        TableColumn col;
        int i = 0;
        Nodo current = entradas.getHead();
        while( current != null){
            Objeto entrada = (Objeto)current.getData();
            col = new TableColumn("Entrada numero "+String.valueOf(++i));
            current.setNext(current.getNext());
        }
        root.getChildren().addAll(tablaEntradas);
    }
    
    
    /**
    * @see https://stackoverflow.com/questions/29684450/javafx-positioning-of-a-button?rq=1
    * se saca como reposicionar un obejeto
    * 
    * @see  https://docs.oracle.com/javafx/2/drag_drop/HelloDragAndDrop.java.html
    * se saca logica del drag & drop, este depues es modificado a prueba y error
    * 
    * @verion 24K09C 
    */
    public void addObjeto(String tipo){
        Objeto objeto = new Objeto(tipo);
        switch (tipo) {
            case "OR":
                objeto.relocate(1150,190);
                break;
            case "AND":
                objeto.relocate(1150,10);
                break;
            case "NAND":
                objeto.relocate(1150,100);
                break;
            case "NOT":
                objeto.relocate(1150,280);
                break;
            case "NOR":
                objeto.relocate(1150,370);
                break;
            case "XOR":
                objeto.relocate(1150,460);
                break;
            case "XNOR":
                objeto.relocate(1150,550);
                break;
            case "TRUE":
                objeto.relocate(1150,675);
                break;
            case "FALSE":
                objeto.relocate(1200,675);
                break;
            default:
                break;
        }
        addEvents(objeto);        
        
        System.out.print("Nuevo "+tipo+" creado \n");
        root.getChildren().add(objeto);
    }
    
    
    
    /**
     * @version 25M09K
     * @param objeto 
     */
    private void addEvents(Objeto objeto){
    
        objeto.setOnMouseClicked(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
                
                if(event.getButton().equals(MouseButton.SECONDARY)){
                    if(salida == null){
                        salida = objeto;
                    }
                    else{
                        if(salida.getTipo() != "FALSE" && salida.getTipo() != "TRUE"){
                            entrada = objeto;
                            circuito.Conectar(salida.getObjetoId(),objeto.getObjetoId());
                            
                        }else{
                            circuito.ConectarBool(salida.getTipo(), objeto.getObjetoId());
                            
                        }
                        drawLines(salida,objeto);
                        salida = null;
                        entrada = null;
                    }
                }
            }
            
        });
        
        objeto.setOnMouseDragged(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
                
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    
                    objeto.relocate(event.getSceneX()-70,event.getSceneY()-30);
                    
                    if(!objeto.getMovido()){
                        
                        if(objeto.getTipo() != "FALSE" && objeto.getTipo() != "TRUE"){
                            objeto.setObjetoId(++objetosIds);
                            Compuertas compuerta = circuito.addCompuerta(objeto.getTipo(),objeto.getObjetoId());
                            objeto.setCompuerta(compuerta);
                        }else{
                            System.out.println("Entrada added");
                            entradas.insertFirst(objeto);
                        }
                        addObjeto(objeto.getTipo());
                        objeto.setMovido(true);
                        
                    }
                   
                    
                }
//                else if(event.getButton().equals(MouseButton.SECONDARY)){
////                    destino = objeto;    
//                    drawLines(objeto,event);
//                    salida = objeto;
//                    
//                }
       
                event.consume();
            }
        });
        
        objeto.setOnMouseReleased(new EventHandler <MouseEvent>() {
            
            public void handle(MouseEvent event) {
                
                if(!objeto.getDropped())  {                     
                    if(objeto.getTipo() != "FALSE" && objeto.getTipo() != "TRUE"){
                        addTags(null, objeto);
                        objeto.setDropped(true);
                    }
                }
                
            }
        });        
//        objeto.setOnMouseDragOver(new EventHandler <MouseEvent>() {
//            public void handle(MouseEvent event) {
//                if(drawing && salida != objeto){
//                    System.out.print("Hola");
//                    entrada = objeto;
//                    if(entrada == null){
//                        System.out.print(objeto.getTipo()+"\n");
//                        EliminarLinea();
//                    }else{
//                        circuito.Conectar(salida.getObjetoId(),entrada.getObjetoId());
//                        entrada = null;
//                        System.out.print("Destino null \n");
//                    }
//                }
//            }
//        });
        
    }
    
    
    
    /**
     * 
     * @param salida
     * @param entrada
     * 
     * @see https://www.tutorialspoint.com/javafx/2dshapes_line.htm
     * se saca como utilizar las lineas
     * 
     * @see https://www.geneseo.edu/~baldwin/reference/random.html
     * como utilizar rand
     * 
     * @see http://www.java2s.com/Tutorials/Java/JavaFX/0040__JavaFX_Line.htm
     * algunas propiedades de line
     * 
     * @version 25M09C
     */
    private void drawLines(Objeto salida,Objeto entrada){
        Line line;
//        if(!drawing){
        line = new Line(); 
        drawing = true;

        line.setStartX(salida.getLayoutX()+salida.getWidth()); 
        line.setStartY(salida.getLayoutY()+(salida.getHeight()/2)); 
        line.setStroke(Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        line.setStrokeWidth(3);
         
        root.getChildren().add(line);
        
        line.setEndX(entrada.getLayoutX()); 
        line.setEndY(entrada.getLayoutY()+entrada.getHeight()/2); 

        addTags(entrada,null);
    }
    
    
    public void addTags(Objeto entrada, Objeto salida){
        if(salida == null){
            
            Label i = new Label("i<"+String.valueOf(circuito.getI())+">");
            i.relocate(entrada.getLayoutX()-30,entrada.getLayoutY()+entrada.getHeight()/2);
            root.getChildren().add(i);
        }else{
            Label o = new Label("o<"+String.valueOf(salida.getCompuerta().getId())+">");
            o.relocate(salida.getLayoutX()+salida.getWidth()+5,salida.getLayoutY()+salida.getHeight()/2);
            root.getChildren().add(o);
        }
    }
    
    
    /**
     * 
     * @version 24K09A 
     */
    public class Objeto extends Label{
        
        private String tipo;
        private Boolean movido = false;
        private Boolean dropped = false;
        private int objetoId;
        private Compuertas compuerta;
        
        public Objeto(String tipo){
            this.tipo = tipo;
//            this.objetoId = id;
            
            
            Image image = new Image(getClass().getResourceAsStream("/Imagenes/"+tipo+".png"));
            setBackground(Background.EMPTY);
            setGraphic(new ImageView(image));
            
        }
        
        
        public String getTipo() {
//            System.out.print(tipo);
            return this.tipo;
        }

        public Boolean getMovido() {
            return this.movido;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public void setMovido(Boolean movido) {
            this.movido = movido;
        }

        public int getObjetoId() {
            return objetoId;
        }

        public void setObjetoId(int objetoId) {
            this.objetoId = objetoId;
        }

        public Compuertas getCompuerta() {
            return compuerta;
        }

        public void setCompuerta(Compuertas compuerta) {
            this.compuerta = compuerta;
        }

        public Boolean getDropped() {
            return dropped;
        }

        public void setDropped(Boolean dropped) {
            this.dropped = dropped;
        }
        
        
        
        
        

        
        
        
       
               
    }
    
   
}
