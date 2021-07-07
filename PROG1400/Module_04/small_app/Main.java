/**
 * author: Yi Chen
 */

package small_app;

/**
 * 
 * Simple Drawing:
 *   Just a simple drawing program
 *
 *Try:
 *  1) Run the program
 *  2) DrawHere -> line 24 to 34 ...draw other stuff on the screen
 *  
 *
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
	
	
	public static JPanel buffer = new DrawHere();
	static WaterBottle o1 = new WaterBottle(30);
	static Water_Bomb o2 = new Water_Bomb(30);
	static Jucie_Orange o3 = new Jucie_Orange(30);
	
	public static void main(String[] args) {
		
		System.out.println("A");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);
        frame.setContentPane(buffer);
    	System.out.println("B");
		
		

		Random rnd = new Random();
		int dRandom = rnd.nextInt(5);

		// start WaterBottle with proper dx, dy
		o1.dy= Math.random()* 50;
		o1.dx= Math.random()* 50;

		o1.start();

		
		Graphics g = buffer.getGraphics();
		while(o1.isAlive()) {
			
			o1.Paint(g);
			buffer.repaint();
			
			o2.Paint(g);
			buffer.repaint();
			
			o3.Paint(g);
			buffer.repaint();
			
		}
		
		// Set up Timer
				Timer timer = new Timer(5000, (ActionListener) buffer); // Set time, and this object gets event
				timer.setInitialDelay(100); //
				timer.setCoalesce(true); // Don't stack up events
				timer.start(); // Start the timer object

				System.out.println("crushed");
		

	}
	
	public static void paint(Graphics g) {
		
		o1.Paint(g);
		buffer.repaint();
		
		o2.Paint(g);
		buffer.repaint();
		
		o3.Paint(g);
		buffer.repaint();
	}

}
