package com.weapons;
import org.lwjglb.engine.items.GameItem;

import java.util.Random;

/**
 * AirVehicle class extends Vehicle
 */
public class AirVehicle extends GameItem {
    private float levelSpeed = 100;  // 50%
    private float levelHeight = 10; // 10km

    /**
     * AirVehicle  type  name
     * @param type type
     * @param name name
     */

    public AirVehicle(VehicleType type, String name) {
        Random random = new Random();
        this.setSteeringWheel(SteeringWheel.CENTER);
        this.setDirection(Direction.STRAIGHT);
    }

    /**
     * move weapons according to its speed, steering wheel and direction
     * @param pedal GAS BRAKE
     * @param gasPedalSpeed gasPedalSpeed
     * @param brakePedalSpeed brakePedalSpeed
     * @param propellerSpeed propellerSpeed
     * @param steeringWheel LEFT CENTER RIGHT
     * @param direction  direction
     */
    public void move(Pedal pedal, float gasPedalSpeed, float brakePedalSpeed, float propellerSpeed, SteeringWheel steeringWheel, Direction direction) {
        this.setDirection(direction);
        this.setSteeringWheel(steeringWheel);

        if (steeringWheel.equals(SteeringWheel.LEFT)) {
            float x = Utils.sub(this.getPosition().x, this.getVelocity().x);
            this.getPosition().x = x;
        } else if (steeringWheel.equals(SteeringWheel.CENTER)) {
            float y = Utils.add(this.getPosition().y, this.getVelocity().y);
            this.getPosition().y = y;
        } else if (steeringWheel.equals(SteeringWheel.RIGHT)) {
            float x = Utils.add(this.getPosition().x, this.getVelocity().x);

            this.getPosition().x = x;
        }

        if (direction.equals(Direction.UP)) {
            float z = Utils.add(this.getPosition().z, this.getVelocity().z);
            this.getPosition().z = z;
        } else if (direction.equals(Direction.DOWN)) {
            float z = Utils.sub(this.getPosition().z, this.getVelocity().z);
            this.getPosition().z = z;
        }

        this.setRotation(this.getRotation().add(this.getRotationVel()));

        // Keep within bounds
        if (Math.abs(this.getPosition().x) > Math.abs(max.x)) {
            this.getVelocity().x = -this.getVelocity().x;
        }

        if (Math.abs(this.getPosition().y) > Math.abs(max.y)) {
            this.getVelocity().y = -this.getVelocity().y;
        }

        if (Math.abs(this.getPosition().z) > Math.abs(max.z)) {
            this.getVelocity().z = -this.getVelocity().z;
        }
    }
}
