package com.weapons;

/**
 * class InTheAirChimneyBlastWeapon
 *blows a area directly above with a straight up blast
 * blast starts in this vehicles location, going up wit a radius that you choose.
 * blast can collide with other vehicles, reduce their health by 5%
 */
public class InTheAirChimneyBlastWeapon extends Weapon implements WeaponInterface {
    private Position position;
    private double radius;
    private double speed;
    private double healthReduced;

    /**
     * InTheAirChimneyBlastWeapon
     * @param position position
     * @param radius radius
     * @param speed speed
     * @param healthReduced healthReduced
     */
    public InTheAirChimneyBlastWeapon(Position position, double radius, double speed, double healthReduced) {
        this.position = position;
        this.radius = radius;
        this.speed = speed;
        this.healthReduced = healthReduced;
    }

    public double getRadius() {
        return radius;
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
     * get SteeringWheel
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
     * get Position
     * @return this.position
     */
    @Override
    public Position getPosition() {
        return this.position;
    }
    public void setPosition(Position position) {
        this.position = position;
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
     * set HealthReduced
     * @param healthReduced healthReduced
     */
    public void setHealthReduced(double healthReduced) {
        this.healthReduced = healthReduced;
    }
}
