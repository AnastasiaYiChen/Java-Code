package com.weapons;

/**
 * weapon interface to set the standard of the weapons
 */

public interface WeaponInterface {
     Position getPosition();
     SteeringWheel getSteeringWheel();
     Direction getDirection();
     double getSpeed();
     double getHealthReduced();
}
