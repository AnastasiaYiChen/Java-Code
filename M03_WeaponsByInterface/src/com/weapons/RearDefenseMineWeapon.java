package com.weapons;

/**
 * class RearDefenseMineWeapon
 * mine is stationary, at the place weapons left it.
 * mine is large (you pick size)
 * mine can collide with other vehicles, reduce their health by 25%
 */
public class RearDefenseMineWeapon extends Weapon implements WeaponInterface {
    private Size size;
    private Position position;
    private double healthReduced;

    /**
     * RearDefenseMineWeapon
     * @param size size
     * @param position position
     * @param healthReduced healthReduced
     */
    public RearDefenseMineWeapon(Size size, Position position, double healthReduced) {
        this.size = size;
        this.position = position;
        this.healthReduced = healthReduced;
    }

    /**
     * get Size
     * @return size
     */
    public Size getSize() {
        return this.size;
    }

    /**
     * set Size
     * @param size size
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * get Position
     * @return position
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * getSteeringWheel
     * @return null
     */
    @Override
    public SteeringWheel getSteeringWheel() {
        return null;
    }

    /**
     * get Direction
     * @return null
     */
    @Override
    public Direction getDirection() {
        return null;
    }

    /**
     * get Speed
     * @return 0
     */
    @Override
    public double getSpeed() {
        return 0;
    }

    /**
     * set Position
     * @param position position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * get HealthReduced
     * @return healthReduced
     */
    @Override
    public double getHealthReduced() {
        return healthReduced;
    }

    /**
     * set HealthReduced
     * @param healthReduced healthReduced
     */
    public void setHealthReduced(double healthReduced) {
        this.healthReduced = healthReduced;
    }
}
