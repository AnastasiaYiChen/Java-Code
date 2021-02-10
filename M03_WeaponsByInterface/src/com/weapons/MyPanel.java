package com.weapons;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * class MyPanel
 */
@SuppressWarnings("serial")
public class MyPanel extends JPanel implements ActionListener {


	/**
	 *  MyPanel constructor
	 */
	public MyPanel() {
		MyVehicle p = new MyVehicle(VehicleType.LANDVEHICLE, "MyVehicle");

		// Set up key-pressed events
		this.addKeyListener(p);

		this.setFocusable(true);
		this.requestFocusInWindow();
	}

	/**
	 * actionPerformed
	 * @param e ActionEvent e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();
		
		//Take focus if we don't have it
		if (!this.isFocusOwner()) {
			this.requestFocusInWindow();
		}

	}
}
