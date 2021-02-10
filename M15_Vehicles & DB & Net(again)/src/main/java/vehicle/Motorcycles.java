package vehicle;

public class Motorcycles extends LandVehicle{
    private double levelSpeed = 50;
    double radius = 50;      // Motorcycles' radius
    double x;                // Motorcycles' center (x,y)
    double y;
    double speedX;           // Motorcycles' speed
    double speedY;
    private double ax, ay, az = 0; // acceleration from different axis

    /**
     * LandVehicle
     *
     * @param type LandVehicle
     * @param name model
     */
    public Motorcycles(String type, String name) {
        super(type, name);
        this.setSpeed(levelSpeed);
    }


    public void stopWhenCollisionDetection(Box box) {

        // Get new (x,y) position
        x += speedX;
        y += speedY;

        // Add acceleration to speed
        speedX += ax;
        speedY += ay;

        // Detect collision and react
        if (x + radius > box.xMax) {
            speedX = 0;
            x = box.xMax - radius;
        } else if (x - radius < box.xMin) {
            speedX = -speedX;
            x = box.xMin + radius;
        }
        if (y + radius > box.yMax) {
            speedY = -speedY;
            y = box.yMax - radius;
        } else if (y - radius < box.yMin) {
            speedY = -speedY;
            y = box.yMin + radius;
        }
    }

}
