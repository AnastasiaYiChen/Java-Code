package vehicle;

public class SAMs extends AirVehicle {

    private double levelSpeed = 100;  // 50%
    private double levelHeight = 10; // 10km
    /**
     * AirVehicle  type  name
     *
     * @param type type
     * @param name name
     */
    public SAMs(String type, String name) {
        super(type, name);
    }

    public void move(Direction direction) {
        this.setDirection(direction);
        for (int i = 0; i < 10; i++) {
            if (direction.equals(Direction.UP)) {
                double z = this.getPosition().getZ() + (this.getSpeed() / 100) * 1;
                if (z < 5 || z > 15) {
                    z = levelHeight;
                }
                this.getPosition().setZ(z);
            } else if (direction.equals(Direction.DOWN)) {
                double z = this.getPosition().getZ() + (this.getSpeed() / 100) * -1;
                if (z < 5 || z > 15) {
                    z = levelHeight;
                }
                this.getPosition().setZ(z);
            }
        }
    }

}
