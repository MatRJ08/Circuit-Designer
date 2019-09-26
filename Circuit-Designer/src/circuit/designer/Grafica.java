package circuit.designer;

import com.sun.org.apache.bcel.internal.util.SecuritySupport;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import javafx.scene.shape.StrokeLineCap;

/**
 *
 * @author Mat
 * @version 25M09A
 */

public class Grafica extends Application{
    
    Group root = new Group();
    Scene scene = new Scene(root, 1300, 725, Color.WHITE);
    Lista lineas =  new Lista();
    int lineasIds = 0;
    int objetosIds = 0;
    Random rand = new Random();
    
    Circuito circuito = new Circuito();
    boolean drawing = false;
    Objeto entrada = null;
    Objeto salida = null;
    
    @Override
    /**
     * @see https://docs.oracle.com/javafx/2/scenegraph/jfxpub-scenegraph.htm 
     * @see https://docs.oracle.com/javafx/2/ui_controls/label.htm
    */
     public void start(Stage stage){
         
        stage.setTitle("Circuit Designer");
        stage.setScene(scene);
        
        stage.show();
        
        addObjeto("AND");
        addObjeto("OR");
        addObjeto("NOT");
        addObjeto("NAND");
        addObjeto("NOR");
        addObjeto("XOR");
        addObjeto("XNOR");
        
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
    * 
    * @verion 24K09C 
    */
    public void addObjeto(String tipo){
        Objeto objeto = new Objeto(tipo,++objetosIds);
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
                    System.out.print("hola");
                    if(salida == null){
                        salida = objeto;
                    }
                    else{
                        entrada=objeto;
                        drawLines(salida,objeto);
                        circuito.Conectar(salida.getObjetoId(),entrada.getObjetoId());
                    }
                }
            }
            
        });
        
        objeto.setOnMouseDragged(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
                
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    
                    objeto.relocate(event.getSceneX()-70,event.getSceneY()-30);
                    if(!objeto.getMovido()){
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
        
//        objeto.setOnMouseReleased(new EventHandler <MouseEvent>() {
//            
//            public void handle(MouseEvent event) {
//                if(drawing){
//                    
//                    drawing = false;
//                    salida = objeto;
//
//                    event.consume();
//                    
//                }
//                             
//            }
//            
//        });        
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
        Linea line;
        if(!drawing){
            line = new Linea(); 
            drawing = true;
            
            line.setStartX(salida.getLayoutX()+salida.getWidth()); 
            line.setStartY(salida.getLayoutY()+(salida.getHeight()/2)); 
            line.setStroke(Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            line.setStrokeLineCap(StrokeLineCap.ROUND);
            line.setStrokeWidth(3);
            
            lineas.insertFirst(line);            
            root.getChildren().add(line);
        }else{
            line = ObtenerLinea();
        }

        //Setting the properties to a line 
        line.setEndX(entrada.getLayoutX()); 
        line.setEndY(entrada.getLayoutY()+entrada.getHeight()/2); 
    }
    
    
    /**
     * 
     * @version 24K09A 
     */
    public class Objeto extends Label{
        private String tipo;
        private Boolean movido = false;
        private int objetoId;
        
        public Objeto(String tipo, int id){
            this.tipo = tipo;
            this.objetoId = id;
            
            circuito.addCompuerta(tipo);
            
            Image image = new Image(getClass().getResourceAsStream("/Imagenes/"+tipo+".png"));
            setBackground(Background.EMPTY);
            setGraphic(new ImageView(image));
            
        }
        
        
        public String getTipo() {
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

        
        
        
       
               
    }
    
    /**
     * 
     * @author Mat
     * @version 24K09B
     */
    private class Linea extends Line{
        int lineaId;
        public Linea(){
            this.lineaId = ++lineasIds;
        }

        public int getLineaId() {
            return lineaId;
        }

        public void setLineaId(int lineaId) {
            this.lineaId = lineaId;
        }
        
       
        
    }
    
    /**
     * @since 25M09A
     * @return 
     */
    private Linea ObtenerLinea(){
        Nodo current = lineas.getHead();
        Linea linea;
        while(current != null){
            linea = (Linea)current.getData();
            if(linea.getLineaId() == lineasIds){
                return linea;
            }
            current = current.getNext();
        }
        return null;
    }
    
    /**
     * @since 25M09A
     * @return 
     */
    private void EliminarLinea(){
        lineas.deleteFirst();
    }
}
