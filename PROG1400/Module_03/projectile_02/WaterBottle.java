package projectile_02;


public class WaterBottle extends Projectile_02{

	public String myName = "WaterBottle: ";
	
	public WaterBottle(int explode) {
		super(explode);
		super.myName = myName;
		// TODO Auto-generated constructor stub
	}

	@Override
	public
	void explode() {
		System.out.println("Water Bottle goes Thunk");
	}

	public void start() {
		// TODO Auto-generated method stub
		super.start();
	}

}