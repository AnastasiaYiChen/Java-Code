package com.weapons;


/**
 * class FireSonicWaveWeapon sonic goes in same direction as weapons
 * sonic wave travels slow, and is large (you pick speed, size)
 * sonic wave can collide with other vehicles, reduce their health by 5%
 */
public class FireSonicWaveWeapon extends Weapon implements WeaponInterface {
    private Size size;
    private Position position;
    private SteeringWheel steeringWheel;
    private Direction direction;
    private double speed;
    private double healthReduced;

    /**
     * FireSonicWaveWeapon
     * @param size  size
     * @param position position
     * @param steeringWheel steeringWheel
     * @param direction direction
     * @param speed speed
     * @param healthReduced healthReduced
     */
    public FireSonicWaveWeapon(Size size, Position position, SteeringWheel steeringWheel, Direction direction, double speed, double healthReduced) {
        this.size = size;
        this.position = position;
        this.steeringWheel = steeringWheel;
        this.direction = direction;
        this.speed = speed;
        this.healthReduced = healthReduced;
    }

    /**
     * get Size
     * @return  Size
     */
    public Size getSize() {
        return this.size;
    }

    /**
     * setSize
     * @param size size
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * get Position
     * @return Position
     */
    @Override
    public Position getPosition() {
        return this.position;
    }

    /**
     * set Position
     * @param position Position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * get SteeringWheel
     * @return SteeringWheel
     */
    @Override
    public SteeringWheel getSteeringWheel() {
        return this.steeringWheel;
    }


    /**
     * get Direction
     * @return Direction
     */
    @Override
    public Direction getDirection() {
        return direction;
    }

    /**
     * set Direction
     * @param direction Direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * get Speed
     * @return Speed
     */
    @Override
    public double getSpeed() {
        return speed;
    }

    /**
     * set Speed
     * @param speed Speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * getHealthReduced
     * @return healthReduced
     */
    @Override
    public double getHealthReduced() {
        return healthReduced;
    }

    /**
     *  set HealthReduced
     * @param healthReduced healthReduced
     */
    public void setHealthReduced(double healthReduced) {
        this.healthReduced = healthReduced;
    }
}
