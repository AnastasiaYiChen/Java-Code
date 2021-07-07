package projectile_02;

public class Jucie_Orange extends Projectile_02{

	public String myName = "Juicy Orange Juice: ";
	
	public Jucie_Orange(int explode) {
		super(explode);
		super.myName = myName;
		// TODO Auto-generated constructor stub
	}

	@Override
	public
	void explode() {
		System.out.println("sticky orange juice everywhere!"+  this.explode);
	}

	public void start() {
		// TODO Auto-generated method stub
		super.start();
	}

}
