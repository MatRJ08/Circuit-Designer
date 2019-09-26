package circuit.designer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javafx.scene.shape.Line;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javafx.event.EventHandler;

import javax.swing.*;

public class DragAndDropExample{
	
    
    public static void main(String[] args) {

        Ven v = new Ven();
        v.setVisible(true);

    } 
       
        
        
//       java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DragAndDropExample().setVisible(true);
//            }
//        });
    
    }


class Ven extends javax.swing.JFrame{
    
    LinePanel panel = new LinePanel();

//    JFrame V2 = new JFrame();
//    JPanel P2 = new JPanel();

    JButton simular = new JButton("Simular");
    JButton entradas = new JButton("Agregar entradas");

    Boolean canDraw = false;
    Boolean panelCreado = false;

    int cont=0;
    int[] coords = null;
    int tempX; int tempY;
//    Lista lineas = new Lista();
    Graphics2D g2d;
    
//    Listas[] Entradas = new Listas[100];

    public Ven() {
        setBounds(0, 0, 1300, 725);
        setTitle("Circuit Designer");

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        setLayout(null);
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);



        simular.setBounds(50,575,100,25);
        entradas.setBounds(180,575,160,25);

        
        
        entradas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            
                Entradas();
                cont++;
            
            }
        });
        
        addObjeto("AND");
        addObjeto("OR");
        addObjeto("NOT");
        addObjeto("NAND");
        addObjeto("NOR");
        addObjeto("XOR");
        addObjeto("XNOR");
        addObjeto("ADD");
        panel.add(simular);
        panel.add(entradas);
//        Line line2 = new Line(200,100,300,100);
        add(panel);
        
    }


    void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.blue);
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(3,
            BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));

        g2d.drawLine(coords[0]+100, coords[1]+50, coords[2], coords[3]+50);
//        g2d.draw(new Line2D.Double(59.2d, 99.8d, 419.1d, 99.8d));

//        g2d.draw(new Line2D.Float(21.50f, 132.50f, 459.50f, 132.50f));
        canDraw= false;
        coords = null;
//        Line line = new Line(coords[0],coords[1],coords[2],coords[3]);
//        System.out.print(coords[0]+coords[1]+coords[2]+coords[3]);
        canDraw= false;
        coords = null;

    }



    public void addObjeto(String tipo){

        Objeto objeto   = new Objeto("/Imagenes/"+tipo+".png",tipo);
        if(tipo.equals("ADD")){
            objeto.addMouseListener(new MouseAdapter(){

                @Override
                public void mouseClicked(MouseEvent e) {                    
                    int x=e.getX();
                    int y=e.getY();
                    System.out.println(x+","+y);//
                }

//                @Override
//                public void mousePressed(MouseEvent e) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
                @Override
                public void mouseReleased(MouseEvent e) {                   
                    setCoords();
                    panel.remove(objeto);
//                    panel.repaint(objeto.getBounds().x, objeto.getBounds().y, objeto.getBounds().width, objeto.getBounds().height);
                    panel.repaint();
                }
            });
        }else{
            objeto.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e) {
                    tempX = objeto.getBounds().x;
                    tempY = objeto.getBounds().y;
                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
            });
        }
        if(tipo.equals("OR")){
            objeto.setBounds(1150,190,120,100);
        }
        else if(tipo.equals("AND")){
            objeto.setBounds(1150,10,120,100);
        }
        else if(tipo.equals("NAND")){
            objeto.setBounds(1150,100,120,100);
        }
        else if(tipo.equals("NOT")){
            objeto.setBounds(1150,280,120,100);
        }
        else if(tipo.equals("NOR")){
            objeto.setBounds(1150,370,120,100);
        }
        else if(tipo.equals("XOR")){
            objeto.setBounds(1150,460,120,100);
        }
        else if(tipo.equals("XNOR")){
            objeto.setBounds(1150,550,120,100);
        }
        else if(tipo.equals("ADD")){
            objeto.setBounds(350,550,120,100);
        }
        panel.add(objeto);            
        System.out.print("Nuevo "+tipo+" creado \n");
}


    public void setCoords(){
        if(coords != null){
            coords[2] = tempX;
            coords[3] = tempY;
            System.out.println(tempX+","+tempY);//
            canDraw = true;
//            drawLines();
        }else{
            coords = new int[4];
            coords[0] = tempX;
            coords[1] = tempY;
            System.out.println(tempX+","+tempY);//
        }
    }
    
    
//    public void Simular(JPanel P2,JFrame V2) {
//        this.V2=V2;
//        this.P2=P2;
//        V2.setBounds(400,225,500,200);
//        V2.setTitle("Resultado");
//        P2.setBackground(Color.WHITE);
//        P2.setLayout(null);
//        V2.setVisible(true);
//        V2.add(P2);		
//    }
	
    
    public void Entradas()  {
        mouse  tf=new mouse();
        tf.setBounds(10,10,40,30);
        tf.setBackground(Color.white);
        panel.add(tf);
        tf.addItem("0");
        tf.addItem("1");
        tf.setSelectedIndex(0);
        tf.setVisible(true);
        panel.repaint();	
    }
	
    
     class mouse extends JComboBox implements  MouseMotionListener, ItemListener{
         
        public mouse(){
            
            JComboBox tf=new JComboBox();
//            Entradas[cont]=new Listas(tf);
            tf.addItemListener(this);
            addMouseMotionListener(this);
        
        }
        
//        public Listas[] getEntradas() {
//        
//            return Entradas;
//        
//        }
        
        @Override
        public void mouseDragged(MouseEvent e) {
        
            setLocation(this.getX()+e.getX()-this.getWidth()/2, this.getY()+e.getY()-this.getHeight()/2 );	
        
        }
        
        @Override
        public void mouseMoved(MouseEvent e) {}
        @Override
        public void itemStateChanged(ItemEvent e) {}
        
    }
	

    class Objeto extends JLabel implements MouseMotionListener{
        
        Boolean movido = false;
        String tipo;
        
	public Objeto(String ubic,String tipo) {
        
            this.tipo = tipo;
            ImageIcon icon= new ImageIcon(getClass().getResource(ubic));
            setIcon(icon);
            setBackground(null);
            addMouseMotionListener(this);
	
        }
        
	@Override
	public void mouseDragged(MouseEvent e) {
            
            if(!movido){
                
                movido = true;
                addObjeto(tipo);
            
            }
            
            setLocation(this.getX()+e.getX()-this.getWidth()/2, this.getY()+e.getY()-this.getHeight()/2 );
            
	}
        	
	@Override
	public void mouseMoved(MouseEvent e) {	
            
	}
        
    }
    
    
    class LinePanel extends JPanel {
      

        public LinePanel() {   
        }
        @Override
        public void paintComponent(Graphics g) {
            
            super.paintComponent(g);      
            
            if(panelCreado){
            }else{
                g2d = (Graphics2D) g; 
                panelCreado = false;
            }
            
            if(canDraw){            
                drawLines(g);            
            }
//            
        }
    }
}

