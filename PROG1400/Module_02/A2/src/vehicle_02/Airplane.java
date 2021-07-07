package vehicle_02;

/**
 * 
 * @author Anastasia Chen
 *
 */

public class Airplane extends Vehicle 
{
	/**
	 * @param maxHeight A double number that simulate the maxHeight
	 */
	
	double maxHeight = 0;
	/**
	 * 
	 * @param colour An integer that simulates a color.
	 * @param topSpeed A double number that simulate how fast of the speed
	 * @param maxHeight A double number that simulate the maxHeight
	 */
	public Airplane(int colour, double topSpeed, double maxHeight) {
		this.colour = colour;
		this.topSpeed = topSpeed;
		this.maxHeight = maxHeight;
	}
	
	/**
	 * 
	 * @return The number of maxHeight
	 */

	public double getMaxHeight() {
		return maxHeight;
	}
	
	/**
	 * 
	 * @param maxHeight A double number that simulate the maxHeight
	 */

	public void setMaxHeight(double maxHeight) {
		this.maxHeight = maxHeight;
	}


}
