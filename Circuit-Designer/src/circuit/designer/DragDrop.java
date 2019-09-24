package circuit.designer;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javafx.scene.shape.Line;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author Keons
 */
public class DragDrop extends javax.swing.JFrame {

    
    int[] coords = null;
    int tempX; int tempY;
    
    public DragDrop() {
        initComponents();
        setLocationRelativeTo(null);
        setBounds(0, 0, 1300, 725);
        setTitle("Circuit Designer");

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        
        addObjeto("AND");
        addObjeto("OR");
        addObjeto("NOT");
        addObjeto("NAND");
        addObjeto("NOR");
        addObjeto("XOR");
        addObjeto("XNOR");
        addObjeto("ADD");
        
        Line line = new Line(200,50,300,50);
    }
    
    void drawLines() {
        
//        Line line = new Line(coords[0],coords[1],coords[2],coords[3]);
        System.out.print(coords[0]+coords[1]+coords[2]+coords[3]);
//        canDraw= false;
        coords = null;

    }



    public void addObjeto(String tipo){

        DragDrop.Objeto objeto   = new DragDrop.Objeto("/Imagenes/"+tipo+".png",tipo);
        if(tipo.equals("ADD")){
            objeto.addMouseListener(new MouseAdapter(){

//                @Override
//                public void mouseClicked(MouseEvent e) {                    
//                    int x=e.getX();
//                    int y=e.getY();
//                    System.out.println(x+","+y);//
//                }

//                @Override
//                public void mousePressed(MouseEvent e) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
                @Override
                public void mouseReleased(MouseEvent e) {                   
                    setCoords();
                    remove(objeto);
//                    panel.repaint(objeto.getBounds().x, objeto.getBounds().y, objeto.getBounds().width, objeto.getBounds().height);
                    repaint();
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
        add(objeto);            
        System.out.print("Nuevo "+tipo+" creado \n");
}


    public void setCoords(){
        if(coords != null){
            coords[2] = tempX;
            coords[3] = tempY;
            System.out.println(tempX+","+tempY);//
            drawLines();
        }else{
            coords = new int[4];
            coords[0] = tempX;
            coords[1] = tempY;
            System.out.println(tempX+","+tempY);//
        }
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


        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jTextField1.setText("jTextField1");
        jTextField1.setDragEnabled(true);
        jTextField1.setDropMode(javax.swing.DropMode.INSERT);
        jTextField1.setEnabled(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AND.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(264, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DragDrop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DragDrop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DragDrop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DragDrop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DragDrop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
