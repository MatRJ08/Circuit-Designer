package circuit.designer;

/**
 *
 * @author Keons
 */
import java.awt.Graphics;

import javax.swing.JComboBox;

public class Listas {
	int x1;
	int y1;
	int x2;
	int y2;
	int cont=0;
	JComboBox tf;
	public Listas(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	
	public void setX2(int x2) {
		this.x2 = x2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public void dibujar(Graphics g) {
		g.drawLine(x1, y1, x2, y2);
	}
	public Listas(JComboBox tf) {
		this.tf=tf;
	}
	public void imp(Listas[] L, int i) {
		int c=0;
		while(c<i) {
			System.out.println(L[c]);
			c++;
		}
	}

}
