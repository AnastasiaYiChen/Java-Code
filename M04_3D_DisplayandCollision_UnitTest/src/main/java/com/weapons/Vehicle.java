package com.weapons;

import org.lwjglb.engine.items.GameItem;

import java.util.ArrayList;

/**
 * parent weapons class
 */
public class Vehicle extends GameItem {
    private String name;
    private VehicleType type;
    private float health = 100.00f;
    private Pedal pedal;
    private float speed;
    private SteeringWheel steeringWheel;
    private Direction direction;
    private Position position;

    /**
     * Give Vehicle type and name
     * @param type land or Air
     * @param name car model
     */
    public Vehicle(VehicleType type, String name) {
        this.name = name;
        this.type = type;
    }

    /**
     * ge tName
     * @return name
     */
    /*public String getName() {
        return name;
    }*/

    /**
     * get Type
     * @return type
     */
    public VehicleType getType() {
        return type;
    }

    /**
     * get pedal
     * @return pedal
     */

    public Pedal getPedal() {
        return this.pedal;
    }

    /**
     * set Pedal
     * @param pedal land pedal
     */

    public void setPedal(Pedal pedal) {
        this.pedal = pedal;
    }

    /**
     * get position
     * @return position
     */

    /*public Position getPosition() {
        return this.position;
    }*/

    /**
     * set Position
     * @param position  Position
     */

    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * get Speed
     * @return  Speed
     */

    public float getSpeed() {
        return speed;
    }

    /**
     * set Speed
     * @param speed returns the largest (closest to positive infinity) float value that is less than or equal to the argument and is equal to a mathematical integer.
     */

    public void setSpeed(float speed) {
        this.speed = (float)(Math.floor(speed * 100) / 100);
    }

    /**
     * getDirection
     * @return direction
     */

    public Direction getDirection() {
        return direction;
    }

    /**
     * setDirection
     * @param direction  DOWN STRAIGHT UP
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     *  get SteeringWheel
     * @return steeringWheel
     */

    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }

    /**
     * set SteeringWheel
     * @param steeringWheel LEFT CENTER RIGHT
     */
    public void setSteeringWheel(SteeringWheel steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    /**
     * move
     * @param pedal GAS BRAKE
     * @param gasPedalSpeed gasPedalSpeed
     * @param brakePedalSpeed brakePedalSpeed
     * @param propellerSpeed propellerSpeed
     * @param steeringWheel LEFT CENTER RIGHT
     * @param direction direction
     */
    public void move(Pedal pedal, float gasPedalSpeed, float brakePedalSpeed, float propellerSpeed, SteeringWheel steeringWheel, Direction direction) {
    }

    /**
     * string method to print
     * @return string
     */

    @Override
    public String toString() {
        String returnString =
                "x=" + position.getX() +
                ", y=" + position.getY() +
                ", z=" + position.getZ() +
                ", name=" + name;
        returnString += type.equals("LandVehicle") ? ", pedal=" + pedal : "";
        returnString += ", steeringwheel=" + steeringWheel +
                ", speed=" + speed + "%";
        returnString += !type.equals("LandVehicle") ? ", direction=" + direction : "";
        return returnString;
    }
}
