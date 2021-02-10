package com.vehicle;

/**
 * AirVehicle class extends Vehicle
 */
public class AirVehicle extends Vehicle {
    private double levelSpeed = 50;  // 50%
    private double levelHeight = 10; // 10km

    /**
     * AirVehicle  type  name
     * @param type type
     * @param name name
     */

    public AirVehicle(String type, String name) {
        super(type, name);
        this.getPosition().setZ(levelHeight);
        this.setSpeed(levelSpeed);
    }

    /**
     * move vehicle according to its speed, steering wheel and direction
     * @param pedal GAS BRAKE
     * @param gasPedalSpeed gasPedalSpeed
     * @param brakePedalSpeed brakePedalSpeed
     * @param propellerSpeed propellerSpeed
     * @param steeringWheel LEFT CENTER RIGHT
     * @param direction  direction
     */
    @Override
    public void move(Pedal pedal, double gasPedalSpeed, double brakePedalSpeed, double propellerSpeed, SteeringWheel steeringWheel, Direction direction) {
        this.setSpeed(this.getSpeed() * (1 + propellerSpeed / 100));
        this.setDirection(direction);
        this.setSteeringWheel(steeringWheel);

        if (steeringWheel.equals(SteeringWheel.LEFT)) {
            double x = this.getPosition().getX() + (this.getSpeed() / 100) * -1;
            this.getPosition().setX(x);
        } else if (steeringWheel.equals(SteeringWheel.CENTER)) {
            double y = this.getPosition().getY() + (this.getSpeed() / 100) * 1;
            this.getPosition().setY(y);
        } else if (steeringWheel.equals(SteeringWheel.RIGHT)) {
            double x = this.getPosition().getX() + (this.getSpeed() / 100) * 1;
            this.getPosition().setX(x);
        }

        if (direction.equals(Direction.UP)) {
            double z = this.getPosition().getZ() + (this.getSpeed() / 100) * 1;
            this.getPosition().setZ(z);
        } else if (direction.equals(Direction.DOWN)) {
            double z = this.getPosition().getZ() + (this.getSpeed() / 100) * -1;
            this.getPosition().setZ(z);
        }
    }
}
