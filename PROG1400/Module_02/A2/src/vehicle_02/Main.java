package vehicle_02;

/**
 * 
 * 
 * @author Anastasia Chen
 * 
 */

import vehicle_01.Car;

import vehicle_01.Vehicle;

public class Main {
	/**
	 * 
	 * @param args contains the supplied command-line arguments as an array of String objects.
	 */

	public static void main(String[] args) {
		// Vehicle Mainline
		
		Vehicle v1 = new Vehicle(12, 220.3);
		System.out.println("v1 Colour=" + v1.getColour() + "  v1 Top Speed=" + v1.getTopSpeed());

		Car c1 = new Car(12, 220.3, 5, "old");
		System.out.println("c1 Colour=" + c1.getColour() + "  c1 Top Speed=" + c1.getTopSpeed() +
				"  c1 Passenger = " + c1.getPassenger() + "  c1 Radio = " + c1.getRadio());

		Airplane a1 = new Airplane(12, 2200.3, 30003.6);
		System.out.println("a1 Colour=" + a1.getColour() + "  a1 Top Speed=" + a1.getTopSpeed() + "  a1.maxHeight="
				+ a1.getMaxHeight());

	}

}

