package com.weapons;

/**
 * FireBulletWeapon class set
 * bullet goes in same direction as weapons
 * bullet travels fast and is small (you pick speed, size)
 * bullet must collide exactly with other vehicles, to reduce their health by 10%
 */

public class FireBulletWeapon extends Weapon implements WeaponInterface {
    private Size size;
    private Position position;
    private SteeringWheel steeringWheel;
    private Direction direction;
    private double speed;
    private double healthReduced;

    /**
     *
     * @param size  size
     * @param position position
     * @param steeringWheel  x,y
     * @param direction     z,y
     * @param speed   speed
     * @param healthReduced  100 to 0
     */
    public FireBulletWeapon(Size size, Position position, SteeringWheel steeringWheel, Direction direction, double speed, double healthReduced) {
        this.size = size;
        this.position = position;
        this.steeringWheel = steeringWheel;
        this.direction = direction;
        this.speed = speed;
        this.healthReduced = healthReduced;
    }

    /**
     * get size
     * @return size
     */

    public Size getSize() {
        return this.size;
    }

    /**
     * set size
     * @param size  size
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * get position
     * @return position
     */
    @Override
    public Position getPosition() {
        return this.position;
    }

    /**
     * set position
     * @param position position
     */
    public void setPosition(Position position) {
        this.position = position;
    }


    /**
     * get x y
     * @return x,y
     */
    @Override
    public SteeringWheel getSteeringWheel() {
        return this.steeringWheel;
    }

    /**
     * get direction
     * @return direction
     */
    @Override
    public Direction getDirection() {
        return direction;
    }

    /**
     * set direction
     * @param direction  direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * get speed
     * @return speed
     */
    @Override
    public double getSpeed() {
        return speed;
    }

    /**
     * set speed
     * @param speed speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * get health value
     * @return healthReduced
     */
    @Override
    public double getHealthReduced() {
        return healthReduced;
    }

    /**
     * set HealthReduced
     * @param healthReduced HealthReduced
     */
    public void setHealthReduced(double healthReduced) {
        this.healthReduced = healthReduced;
    }
}
