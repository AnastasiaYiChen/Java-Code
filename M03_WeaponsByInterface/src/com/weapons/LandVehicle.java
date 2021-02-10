package com.weapons;

import java.util.Random;

/**
 * LandVehicle class extends Vehicle
 */

public class LandVehicle extends Vehicle {
    private double levelSpeed = 0; // 50%

    /**
     * LandVehicle
     * @param type  LandVehicle
     * @param name  model
     */

    public LandVehicle(VehicleType type, String name) {
        super(type, name);
        this.setSpeed(levelSpeed);
        Random random = new Random();
        double randomX = random.nextInt(21) - 10;
        double randomY = random.nextInt(21) - 10;
        this.setPosition(new Position(randomX, randomY, 0));
        this.setSteeringWheel(SteeringWheel.CENTER);
        this.setDirection(Direction.STRAIGHT);
        this.initWeapon();
    }

    /**
     * initialize weapon
     */
    private void initWeapon() {
        RearDefenseMineWeapon rearDefenseMine = new RearDefenseMineWeapon(new Size(2, 2, 2), this.getPosition(), 25);
        this.setRearDefenseMine(rearDefenseMine);
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
    @Override
    public void move(Pedal pedal, double gasPedalSpeed, double brakePedalSpeed, double propellerSpeed, SteeringWheel steeringWheel, Direction direction) {
        if (pedal.equals(Pedal.GAS)) {
            double currentSpeed = Utils.add(this.getSpeed(), gasPedalSpeed / 100);
            this.setSpeed(currentSpeed);
        } else if (pedal.equals(Pedal.BRAKE)) {
            double currentSpeed = Utils.sub(this.getSpeed(), brakePedalSpeed / 100);
            currentSpeed = currentSpeed > 0 ? currentSpeed : 0;
            this.setSpeed(currentSpeed);
        }
        this.setPedal(pedal);
        this.setDirection(direction);
        this.setSteeringWheel(steeringWheel);

        if (steeringWheel.equals(SteeringWheel.LEFT)) {
            double x = Utils.sub(this.getPosition().getX(), this.getSpeed() / 100);
            if (x < -10 || x > 10) {
                x = 0;
            }
            this.getPosition().setX(x);
        } else if (steeringWheel.equals(SteeringWheel.CENTER)) {
            double y = Utils.add(this.getPosition().getY(), this.getSpeed() / 100);
            if (y > 100) {
                y = 0;
            }
            this.getPosition().setY(y);
        } else if (steeringWheel.equals(SteeringWheel.RIGHT)) {
            double x = Utils.add(this.getPosition().getX(), this.getSpeed() / 100);
            if (x < -10 || x > 10) {
                x = 0;
            }
            this.getPosition().setX(x);
        }
    }


    /**
     * fire method
     * @param weaponType types size speed position
     */
    @Override
    public void fire(WeaponType weaponType) {
        switch (weaponType) {
            case FIREBULLET:
                FireBulletWeapon fireBullet = new FireBulletWeapon(new Size(3, 2, 2), this.getPosition(), this.getSteeringWheel(), this.getDirection(), 5, 10);
                this.fireFireBullet(fireBullet);
                break;
            case FIRESONICWAVE:
                FireSonicWaveWeapon fireSonicWave = new FireSonicWaveWeapon(new Size(4, 3, 3), this.getPosition(), this.getSteeringWheel(), this.getDirection(), 2, 5);
                this.fireFireSonicWave(fireSonicWave);
                break;
            case INTHEAIRCHIMNEYBLAST:
                InTheAirChimneyBlastWeapon inTheAirChimneyBlast = new InTheAirChimneyBlastWeapon(this.getPosition(), 5, 2, 5);
                this.fireInTheAirChimneyBlast(inTheAirChimneyBlast);
                break;
        }
    }
}
