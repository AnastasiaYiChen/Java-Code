package com.weapons;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * class MyVehicle
 * Connect one weapons to the keyboard and/or mouse for firing weapons (or get weapons to fire at random times)
 * process a weapons strike on a weapons ... decrements health, changes directions, whatever you want.
 */
public class MyVehicle extends Vehicle implements KeyListener {
    private double levelSpeed = 50; // 50%

    /**
     * Give Vehicle type and name
     *
     * @param type land or Air
     * @param name car model
     */
    public MyVehicle(VehicleType type, String name) {
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
     * init Weapon
     */
    private void initWeapon() {
        RearDefenseMineWeapon rearDefenseMine = new RearDefenseMineWeapon(new Size(2, 2, 2), this.getPosition(), 25);
        this.setRearDefenseMine(rearDefenseMine);
    }

    /**
     * move method
     * @param pedal GAS BRAKE
     * @param gasPedalSpeed gasPedalSpeed
     * @param brakePedalSpeed brakePedalSpeed
     * @param propellerSpeed propellerSpeed
     * @param steeringWheel LEFT CENTER RIGHT
     * @param direction direction
     */
    @Override
    public void move(Pedal pedal, double gasPedalSpeed, double brakePedalSpeed, double propellerSpeed, SteeringWheel steeringWheel, Direction direction) {
        this.setSteeringWheel(steeringWheel);
        if (pedal.equals(Pedal.GAS)) {
            this.setSpeed(this.getSpeed() * (1 + gasPedalSpeed / 100));
        } else if (pedal.equals(Pedal.BRAKE)) {
            double currentSpeed = this.getSpeed() * (1 - brakePedalSpeed / 100);
            currentSpeed = currentSpeed > 0 ? currentSpeed : 0;
            this.setSpeed(currentSpeed);
        }
        this.setPedal(pedal);
        this.setDirection(direction);
        this.setSteeringWheel(steeringWheel);

        if (steeringWheel.equals(SteeringWheel.LEFT)) {
            double x = this.getPosition().getX() + (this.getSpeed() / 100) * -1;
            if (x < -10 || x > 10) {
                x = 0;
            }
            this.getPosition().setX(x);
        } else if (steeringWheel.equals(SteeringWheel.CENTER)) {
            double y = this.getPosition().getY() + (this.getSpeed() / 100) * 1;
            if (y > 100) {
                y = 0;
            }
            this.getPosition().setY(y);
        } else if (steeringWheel.equals(SteeringWheel.RIGHT)) {
            double x = this.getPosition().getX() + (this.getSpeed() / 100) * 1;
            if (x < -10 || x > 10) {
                x = 0;
            }
            this.getPosition().setX(x);
        }
    }

    /**
     * fire
     * @param weaponType Type
     */
    @Override
    public void fire(WeaponType weaponType) {
        switch (weaponType) {
            case FIREBULLET:
                FireBulletWeapon fireBullet = new FireBulletWeapon(new Size(1, 0.4, 0.4), this.getPosition(), this.getSteeringWheel(), this.getDirection(), 5, 10);
                this.fireFireBullet(fireBullet);
                break;
            case FIRESONICWAVE:
                FireSonicWaveWeapon fireSonicWave = new FireSonicWaveWeapon(new Size(2, 1, 1), this.getPosition(), this.getSteeringWheel(), this.getDirection(), 2, 5);
                this.fireFireSonicWave(fireSonicWave);
                break;
            case INTHEAIRCHIMNEYBLAST:
                InTheAirChimneyBlastWeapon inTheAirChimneyBlast = new InTheAirChimneyBlastWeapon(this.getPosition(), 2, 2, 5);
                this.fireInTheAirChimneyBlast(inTheAirChimneyBlast);
                break;
        }
    }

    /**
     * keyTyped
     * @param e KeyEvent
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * keyPressed
     * @param e KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int ch = e.getKeyCode();
        switch (ch) {
            case KeyEvent.VK_SPACE:
                this.fire(WeaponType.FIREBULLET);
                System.out.println("MyVehicle fired a bullet");
                break;
        }
    }

    /**
     * keyReleased
     * @param e KeyEvent
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}


