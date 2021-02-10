package com.weapons;

/**
 * class Weapon collect all weapons
 */
public class Weapon {
    private String name;
    private Vehicle vehicle;

    /**
     * getName
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setName
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getVehicle
     * @return weapons
     */
    public Vehicle getVehicle() {
        return this.vehicle;
    }

    /**
     * set Vehicle
     * @param vehicle weapons
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
