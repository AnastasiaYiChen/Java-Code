package projectile_02;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		class gun {
			
			private Projectile_02 temp;
			
			public gun(Projectile_02 proj) {
				this.temp = proj;
			}
			
			public void fire() {
				temp.start();
			}
		}
		
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an double: ");
    	double number = input.nextDouble();
    
    	
    	gun myGun = new gun(new WaterBottle(10));
    	myGun.fire();
    	myGun = new gun(new Water_Bomb(10));
    	myGun.fire();
    	
		// get dx, dy from user
		//
		Random rnd = new Random();
		int dRandom = rnd.nextInt(30);

		// start WaterBottle with proper dx, dy
		WaterBottle o1 = new WaterBottle(10);
		o1.dy= number;
		o1.dx= number;
//		o1.ticToc();
		o1.start();
		Water_Bomb o2 = new Water_Bomb(10);
//		o2.ticToc();
		o2.start();
		Jucie_Orange o3 = new Jucie_Orange(dRandom);
//		o3.ticToc();
		o3.start();
		
		while(o1.isAlive() && o2.isAlive() && o3.isAlive()) {}
		
//		o1.explode();
//		o2.explode();
//		o3.explode();
		

	}

}
