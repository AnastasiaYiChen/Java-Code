package projectile_02;

//import projectile.Projectile_01;

public class Water_Bomb extends Projectile_02{

	public String myName = "Water Bomb: ";
	
	public Water_Bomb(int explode) {
		super(explode);
		super.myName = myName;
		// TODO Auto-generated constructor stub
	}

	@Override
	public
	void explode() {
		System.out.println("water bomb goes squish");
	}

	public void start() {
		// TODO Auto-generated method stub
		super.start();
	}

}