package com.weapons;

import org.lwjglb.engine.graph.Mesh;
import org.lwjglb.engine.items.GameItem;

import java.util.Random;

/**
 * LandVehicle class extends Vehicle
 */

public class LandVehicle extends GameItem {
    private float levelSpeed = 0; // 50%

    /**
     * LandVehicle
     * @param type  LandVehicle
     * @param name  model
     */

    public LandVehicle(VehicleType type, String name) {
        // super(type, name);
        this.setVelocity(0.005f, 0.000001f, 0.000001f);
        Random random = new Random();
        this.setSteeringWheel(SteeringWheel.CENTER);
        this.setDirection(Direction.STRAIGHT);
    }

    public void setMeshes(Mesh[] meshes) {
        super.setMeshes(meshes);
    }

    /**
     * move weapons according to its speed, steering wheel and direction
     * @param pedal GAS BRAKE
     * @param gasPedalSpeed gasPedalSpeed
     * @param brakePedalSpeed brakePedalSpeed
     * @param propellerSpeed propellerSpeed
     * @param steeringWheel LEFT CENTER RIGHT
     * @param direction direction
     */
    public void move(Pedal pedal, float gasPedalSpeed, float brakePedalSpeed, float propellerSpeed, SteeringWheel steeringWheel, Direction direction) {
        if (pedal.equals(Pedal.GAS)) {
            this.setPosition(this.getPosition().add(this.getVelocity()));
        } else if (pedal.equals(Pedal.BRAKE)) {
            this.setPosition(this.getPosition().sub(this.getVelocity()));
        }
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
