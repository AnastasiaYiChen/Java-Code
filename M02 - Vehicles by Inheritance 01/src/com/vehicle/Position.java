package com.vehicle;

/**
 * current position for vehicle
 */
public class Position {
    private double x, y, z;

    /**
     * empty constructor
     */
    public Position() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    /**
     * get x position
     * @return x position
     */
    public double getX() {
        return x;
    }

    /**
     * set x position
     * @param x position
     */
    public void setX(double x) {
        this.x = Math.floor(x * 100) / 100;
    }

    /**
     * get y position
     * @return y position
     */
    public double getY() {
        return y;
    }

    /**
     * set y position
     * @param y position
     */
    public void setY(double y) {
        this.y = Math.floor(y * 100) / 100;;
    }

    /**
     * get z position
     * @return z position
     */
    public double getZ() {
        return z;
    }

    /**
     * set z position
     * @param z position
     */
    public void setZ(double z) {
        this.z = Math.floor(z * 100) / 100;;
    }

    /**
     * to string
     * @return vehicle info
     */
    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
