package vehicle_02;
/**
 * 
 * @author Anastasia Chen
 *
 */

public class Vehicle {
	
	protected int colour;
	public int getColour() {
		
		
		return colour;
	}
/**
 * 
 * @param colour An integer that simulates a color.
 */

	public void setColour(int colour) {
		this.colour = colour;
	}
	
	/**
	 * 
	 * @return A integer number that simulates how fast of the speed.
	 */


	public double getTopSpeed() {
		return topSpeed;
	}
	/**
	 * 
	 * @param topSpeed A double number that simulates the fastest speed.
	 */


	public void setTopSpeed(double topSpeed) {
		this.topSpeed = topSpeed;
	}

	protected double topSpeed;

	public Vehicle() {
		this(0,  0.0);
	}
	
	/**
	 * 
	 * @param colour  An integer that simulates a color.
	 */

	public Vehicle(int colour) {
		this(colour,  0.0);
	}
	/**
	 * 
	 * @param topSpeed A double number that simulates the fastest speed.
	 */
	public Vehicle(double topSpeed) {
		this(0,  topSpeed);
	}
	/**
	 * 
	 * @param colour An integer that simulates a color.
	 * @param topSpeed A double number that simulates the fastest speed.
	 */
	public Vehicle(int colour, int topSpeed) {
		this(colour,  (double) topSpeed);
	}
	/**
	 * 
	 * @param colour An integer that simulates a color.
	 * @param topSpeed A double number that simulates the fastest speed.
	 */
		
	public Vehicle(int colour, double topSpeed) {
		this.colour = colour;
		this.topSpeed = topSpeed;
	}
	/**
	 * @return The double number that simulates the distances of forwarding.
	 */

    public void moveForward() {
    	System.out.println("moveForward() inside Vehicle class"); 
    }
	
	
	
}
