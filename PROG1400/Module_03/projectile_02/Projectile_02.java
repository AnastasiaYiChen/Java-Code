package projectile_02;


public abstract class Projectile_02 extends Thread{
	
	double x = 0;
	double y = 0;

	double dx = 1;
	double dy = 50;
	int n = 7;
	
	int count = 0;
	int explode;
	boolean boo = true;
	public String myName = "Projectile: ";

	public Projectile_02(int explode) {
		super();
		this.explode = explode;
	}

	@Override
	public void run() { 
		
		ticToc();
		
	}
	
	public void ticToc() {
        while (boo) {
        	
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	// Move forward
        	x = x + dx;
        	y = y + dy;     
        	
        	dy = dy -9.832;
        	System.out.println(this);
//        	if (y >= 28) {
//        		
//        		y = y - n;
//        		
//        	}
        	
//        	System.out.println("y = " + y);
        	if (++count >= explode || y <= 0) {
        	explode();
//        	System.out.println("test");
        	boo = false;
        		////////////
        	}
        	
        }
    }

	
	abstract void explode();

	public String toString() {
		return myName + "X="+x+"  y="+y;
	}

}
	


