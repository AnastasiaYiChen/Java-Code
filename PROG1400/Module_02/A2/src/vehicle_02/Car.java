package vehicle_02;

/**
 * 
 * @author Anastasia Chen
 *
 */

public class Car extends Vehicle {
	
	int passengers = 0;
	String radio;
	
	public Car(int colour, double topSpeed, int passenger, String radio) {
		
		this.colour = colour;
		this.topSpeed = topSpeed;
		this.passengers = passenger;
		this.radio = radio;
	}
	/**
	 * 
	 * @return The integer numbers of passenger 
	 */
	public int getPassenger() {
		
		return passengers;
	}
	/**
	 * 
	 * @return The string name of the radio
	 */
	public String getRadio() {
		return radio;
	}


}
