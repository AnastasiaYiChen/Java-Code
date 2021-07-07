/**
 * Author Yi Chen (Anastasia)
 */

package small_app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class Projectile_02 extends Thread{
	
	double x = 100;
	double y = 100;

	double dx = 0;
	double dy = 0;
	
	
	int count = 0;
	int explode;
	boolean boo = true;
	public String myName = "Projectile: ";

	public Projectile_02(int explode) {
		super();
		this.explode = explode;
	}

	@Override
	public void run() { 
		
		ticToc();
		
		System.out.println("output");
		
	}
	
	
	
	void Paint(Graphics g) {
		Graphics2D gfx = (Graphics2D) g;
		
		Color dotColor= Color.cyan;
		Color lineColor = Color.red;
		Color RoundRectColor = Color.pink;
		
		// Draw new graphic
		gfx.setColor(dotColor);
		int shapeSize = 20;
		gfx.drawRect((int) x, Main.buffer.getHeight()-(int) y - shapeSize, shapeSize, shapeSize);
		gfx.setColor(lineColor);
		gfx.drawLine((int)x, Main.buffer.getHeight()-(int) y - shapeSize, shapeSize, shapeSize);
		gfx.setColor(RoundRectColor);
		gfx.drawRoundRect((int)x, Main.buffer.getHeight()-(int) y - shapeSize, shapeSize, shapeSize, shapeSize, shapeSize);
		
	}
	
	
	public void ticToc() {
        while (boo) {
        	
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	// Move forward
        	x = x + dx;
        	y = y + dy;    
        	
        	if(y <= 0) y = 0;
        	
        	dy = dy -9.832;
        	System.out.println(this);

        	
        	if (++count >= explode || y <= 0) {
        	explode();
//        	System.out.println("test");
        	boo = false;
        		////////////
        	}
        	
        	
        	
        }
    }

	
	abstract void explode();

	public String toString() {
		return myName + "X="+x+"  y="+y;
	}

}
	


