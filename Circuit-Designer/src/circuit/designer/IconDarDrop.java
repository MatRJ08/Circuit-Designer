package circuit.designer;

import java.awt.Container;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.TransferHandler;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javafx.scene.layout.Pane;

public class IconDarDrop extends JFrame {

    public IconDarDrop() {

        initUI();
    }

    private void initUI() {

        ImageIcon icon1 = new ImageIcon("src/resources/sad.png");
        ImageIcon icon2 = new ImageIcon("src/resources/plain.png");
        ImageIcon icon3 = new ImageIcon("src/resources/smile.png");

        JLabel label1 = new JLabel(icon1, JLabel.CENTER);
        JLabel label2 = new JLabel(icon2, JLabel.CENTER);
        JLabel label3 = new JLabel(icon3, JLabel.CENTER);

        DragMouseAdapter listener = new DragMouseAdapter();
        label1.addMouseListener(listener);
        label2.addMouseListener(listener);
        label3.addMouseListener(listener);

        JButton button = new JButton(icon2);
        button.setFocusable(false);

        label1.setTransferHandler(new TransferHandler("icon"));
        label2.setTransferHandler(new TransferHandler("icon"));
        label3.setTransferHandler(new TransferHandler("icon"));
        button.setTransferHandler(new TransferHandler("icon"));

        createLayout(label1, label2, label3, button);

        setTitle("Icon Drag & Drop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private class DragMouseAdapter extends MouseAdapter {

        public void mousePressed(MouseEvent e) {

            JComponent c = (JComponent) e.getSource();
            TransferHandler handler = c.getTransferHandler();
            handler.exportAsDrag(c, e, TransferHandler.COPY);
        }
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[0])
                        .addGap(30)
                        .addComponent(arg[1])
                        .addGap(30)
                        .addComponent(arg[2])
                )
                .addComponent(arg[3], GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE, Integer.MAX_VALUE)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1])
                        .addComponent(arg[2]))
                .addGap(30)
                .addComponent(arg[3])
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            IconDarDrop ex = new IconDarDrop();
            ex.setVisible(true);
        });
    }
}