package com.weapons;

import java.util.ArrayList;

/**
 * parent weapons class
 */
public class Vehicle {
    private String name;
    private VehicleType type;
    private double health = 100.00;
    private Pedal pedal;
    private double speed;
    private SteeringWheel steeringWheel;
    private Direction direction;
    private Position position;
    private RearDefenseMineWeapon rearDefenseMine;
    private ArrayList<FireBulletWeapon> fireBulletList = new ArrayList();
    private ArrayList<FireSonicWaveWeapon> fireSonicWaveList = new ArrayList();
    private ArrayList<InTheAirChimneyBlastWeapon> inTheAirChimneyBlastList = new ArrayList();

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
    public String getName() {
        return name;
    }

    /**
     * get Type
     * @return type
     */
    public VehicleType getType() {
        return type;
    }

    /**
     * get Health
     * @return health
     */
    public double getHealth() {
        return health;
    }

    /**
     * set Health
     * @param health Health
     */
    public void setHealth(double health) {
        this.health = health;
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

    public Position getPosition() {
        return this.position;
    }

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

    public double getSpeed() {
        return speed;
    }

    /**
     * set Speed
     * @param speed returns the largest (closest to positive infinity) double value that is less than or equal to the argument and is equal to a mathematical integer.
     */

    public void setSpeed(double speed) {
        this.speed = Math.floor(speed * 100) / 100;
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
    public void move(Pedal pedal, double gasPedalSpeed, double brakePedalSpeed, double propellerSpeed, SteeringWheel steeringWheel, Direction direction) {
    }

    /**
     * fire
     * @param weaponType weaponType
     */
    public void fire(WeaponType weaponType) {
    }

    /**
     * getRearDefenseMine
     * @return rearDefenseMine
     */
    public RearDefenseMineWeapon getRearDefenseMine() {
        return this.rearDefenseMine;
    }

    /**
     * setRearDefenseMine
     * @param rearDefenseMine rearDefenseMine
     */
    public void setRearDefenseMine(RearDefenseMineWeapon rearDefenseMine) {
        this.rearDefenseMine = rearDefenseMine;
    }

    /**
     * getFireBulletList
     * @return fireBulletList
     */
    public ArrayList<FireBulletWeapon> getFireBulletList() {
        return this.fireBulletList;
    }

    /**
     * fireFireBullet
     * @param fireBullet  fireBullet
     */
    public void fireFireBullet(FireBulletWeapon fireBullet) {
        fireBullet.setName(this.name + "FB" + this.fireBulletList.size());
        fireBullet.setVehicle(this);
        this.fireBulletList.add(fireBullet);
    }

    /**
     * getFireSonicWaveList
     * @return fireSonicWaveList
     */
    public ArrayList<FireSonicWaveWeapon> getFireSonicWaveList() {
        return this.fireSonicWaveList;
    }

    /***
     * fireFireSonicWave
     * @param fireSonicWave fireSonicWave
     */
    public void fireFireSonicWave(FireSonicWaveWeapon fireSonicWave) {
        fireSonicWave.setVehicle(this);
        this.fireSonicWaveList.add(fireSonicWave);
    }

    /**
     * get InTheAirChimneyBlastList
     * @return inTheAirChimneyBlastList
     */
    public ArrayList<InTheAirChimneyBlastWeapon> getInTheAirChimneyBlastList() {
        return this.inTheAirChimneyBlastList;
    }

    /**
     * fireInTheAirChimneyBlast
     * @param inTheAirChimneyBlast inTheAirChimneyBlast
     */
    public void fireInTheAirChimneyBlast(InTheAirChimneyBlastWeapon inTheAirChimneyBlast) {
        inTheAirChimneyBlast.setVehicle(this);
        this.inTheAirChimneyBlastList.add(inTheAirChimneyBlast);
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
