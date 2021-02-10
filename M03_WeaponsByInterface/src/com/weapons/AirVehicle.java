package com.weapons;
import java.util.Random;

/**
 * AirVehicle class extends Vehicle
 */
public class AirVehicle extends Vehicle {
    private double levelSpeed = 100;  // 50%
    private double levelHeight = 10; // 10km

    /**
     * AirVehicle  type  name
     * @param type type
     * @param name name
     */

    public AirVehicle(VehicleType type, String name) {
        super(type, name);
        this.setSpeed(levelSpeed);
        Random random = new Random();
        double randomX = random.nextInt(21) - 10;
        double randomY = random.nextInt(21) - 10;
        this.setPosition(new Position(randomX, randomY, levelHeight));
        this.setSteeringWheel(SteeringWheel.CENTER);
        this.setDirection(Direction.STRAIGHT);
        this.initWeapon();
    }

    /**
     * init weapon
     */
    private void initWeapon() {
        RearDefenseMineWeapon rearDefenseMine = new RearDefenseMineWeapon(new Size(1, 1, 1), this.getPosition(), 25);
        this.setRearDefenseMine(rearDefenseMine);
    }

    /**
     * move weapons according to its speed, steering wheel and direction
     * @param pedal GAS BRAKE
     * @param gasPedalSpeed gasPedalSpeed
     * @param brakePedalSpeed brakePedalSpeed
     * @param propellerSpeed propellerSpeed
     * @param steeringWheel LEFT CENTER RIGHT
     * @param direction  direction
     */
    @Override
    public void move(Pedal pedal, double gasPedalSpeed, double brakePedalSpeed, double propellerSpeed, SteeringWheel steeringWheel, Direction direction) {
        double currentSpeed = Utils.add(this.getSpeed(), propellerSpeed / 100);
        this.setSpeed(currentSpeed);
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

        if (direction.equals(Direction.UP)) {
            double z = Utils.add(this.getPosition().getZ(), this.getSpeed() / 100);
            if (z < 5 || z > 15) {
                z = levelHeight;
            }
            this.getPosition().setZ(z);
        } else if (direction.equals(Direction.DOWN)) {
            double z = Utils.sub(this.getPosition().getZ(), this.getSpeed() / 100);
            if (z < 5 || z > 15) {
                z = levelHeight;
            }
            this.getPosition().setZ(z);
        }
    }

    /**
     * fire method
     * @param weaponType type
     */
    @Override
    public void fire(WeaponType weaponType) {
        switch (weaponType) {
            case FIREBULLET:
                FireBulletWeapon fireBullet = new FireBulletWeapon(new Size(0.5, 0.2, 0.2), this.getPosition(), this.getSteeringWheel(), this.getDirection(), 5, 10);
                this.fireFireBullet(fireBullet);
                break;
            case FIRESONICWAVE:
                FireSonicWaveWeapon fireSonicWave = new FireSonicWaveWeapon(new Size(1, 0.5, 0.5), this.getPosition(), this.getSteeringWheel(), this.getDirection(), 2, 5);
                this.fireFireSonicWave(fireSonicWave);
                break;
            case INTHEAIRCHIMNEYBLAST:
                InTheAirChimneyBlastWeapon inTheAirChimneyBlast = new InTheAirChimneyBlastWeapon(this.getPosition(), 2, 2, 5);
                this.fireInTheAirChimneyBlast(inTheAirChimneyBlast);
                break;
        }
    }
}
