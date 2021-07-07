/**
 * author: Yi Chen
 */

package small_app;


import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Imports are listed in full to show what's being used
 * could just import javax.swing.* and java.awt.* etc..
 */



public class DrawHere  extends JPanel implements ActionListener{
	
	public void paintComponent(Graphics g) {

	Main.paint(g);	
}	
	/**
	 * This method is called when the timer fires
	 * The Timer sets off an "actionPerformed" event
	 * every so many milliseconds.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();

		System.out.print("bang-bang");
		
		//Take focus if we don't have it
		if (!this.isFocusOwner()) {
			this.requestFocusInWindow();
		}
	}
}
