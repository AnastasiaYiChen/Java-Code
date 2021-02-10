package vehicle;

/**
 * LandVehicle class extends Vehicle
 */

public class LandVehicle extends Vehicle {
    private double levelSpeed = 50; // 50%

    /**
     * LandVehicle
     * @param type  LandVehicle
     * @param name  model
     */

    public LandVehicle(String type, String name) {
        super(type, name);
        this.setSpeed(levelSpeed);
    }

    /**
     * move vehicle according to its speed, steering wheel and direction
     * @param pedal GAS BRAKE
     * @param gasPedalSpeed gasPedalSpeed
     * @param brakePedalSpeed brakePedalSpeed
     * @param propellerSpeed propellerSpeed
     * @param steeringWheel LEFT CENTER RIGHT
     * @param direction direction
     */
    @Override
    public void move(Pedal pedal, double gasPedalSpeed, double brakePedalSpeed, double propellerSpeed, SteeringWheel steeringWheel, Direction direction) {
        if (pedal.equals(Pedal.GAS)) {
            this.setSpeed(this.getSpeed() * (1 + gasPedalSpeed / 100));
        } else if (pedal.equals(Pedal.BRAKE)) {
            double currentSpeed = this.getSpeed() * (1 - brakePedalSpeed / 100);
            currentSpeed = currentSpeed > 0 ? currentSpeed : 0;
            this.setSpeed(currentSpeed);
        }
        this.setPedal(pedal);
        this.setDirection(direction);
        this.setSteeringWheel(steeringWheel);

        if (steeringWheel.equals(SteeringWheel.LEFT)) {
            double x = this.getPosition().getX() + (this.getSpeed() / 100) * -1;
            if (x < -10 || x > 10) {
                x = 0;
            }
            this.getPosition().setX(x);
        } else if (steeringWheel.equals(SteeringWheel.CENTER)) {
            double y = this.getPosition().getY() + (this.getSpeed() / 100) * 1;
            if (y > 100) {
                y = 0;
            }
            this.getPosition().setY(y);
        } else if (steeringWheel.equals(SteeringWheel.RIGHT)) {
            double x = this.getPosition().getX() + (this.getSpeed() / 100) * 1;
            if (x < -10 || x > 10) {
                x = 0;
            }
            this.getPosition().setX(x);
        }
    }
}
