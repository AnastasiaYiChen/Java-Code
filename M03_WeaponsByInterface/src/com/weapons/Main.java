package com.weapons;
/**
 * @author Yi Chen
 */
import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

/**
 * main class
 *
 */
public class Main {
    static MyPanel myPanel = new MyPanel();
    /**
     * main method
     * @param args to call the main function in java. The main method is called if it’s formal parameter matches that of an array of Strings.
     */
    public static void main(String[] args) {
        Main main = new Main();
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Vehicle myVehicle = new MyVehicle(VehicleType.LANDVEHICLE, "MyVehicle");
        Vehicle vehicleToyota = new LandVehicle(VehicleType.LANDVEHICLE, "Toyota");
        Vehicle vehicleVolkswagen = new LandVehicle(VehicleType.LANDVEHICLE, "Volkswagen");
        Vehicle vehicleFord = new LandVehicle(VehicleType.LANDVEHICLE, "Ford");
        Vehicle vehicleBoeing = new AirVehicle(VehicleType.AIRVEHICLE, "Boeing");
        Vehicle vehicleAirbus = new AirVehicle(VehicleType.AIRVEHICLE, "Airbus");
        Vehicle vehicleBombardier = new AirVehicle(VehicleType.AIRVEHICLE, "Bombardier");
        vehicles.add(myVehicle);
        vehicles.add(vehicleToyota);
        vehicles.add(vehicleVolkswagen);
        vehicles.add(vehicleFord);
        vehicles.add(vehicleBoeing);
        vehicles.add(vehicleAirbus);
        vehicles.add(vehicleBombardier);
        for (Vehicle vehicle: vehicles) {
            if (!vehicle.getName().equals("MyVehicle")) {
                main.scheduleFire(vehicle);
            }
            main.scheduleMove(vehicle);
        }

        ArrayList<String> noHealthVehicles = new ArrayList<>();
        main.scheduleCheckingCollision(vehicles, noHealthVehicles);

        // Set up jFrame window for drawing
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 750);
        frame.setContentPane(myPanel);
        frame.getRootPane().setBackground(Color.LIGHT_GRAY);
        JLabel label = new JLabel("M03 - Weapons by Interface ");
        frame.getContentPane().add(label);
        frame.setVisible(true);
    }

    /**
     * start thread to check any collision among all vehicles and their weapsons every 1s
     * @param vehicles
     * @param noHealthVehicles
     */
    public void scheduleCheckingCollision(ArrayList<Vehicle> vehicles, ArrayList<String> noHealthVehicles) {
        final long timeInterval = 5000;
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    // count position for weapons
                    for (Vehicle vehicle : vehicles) {
                        ArrayList<FireBulletWeapon> fireBulletList = vehicle.getFireBulletList();
                        for (FireBulletWeapon fireBulletWeapon : fireBulletList) {
                            countPositionsForWeapons(fireBulletWeapon.getSteeringWheel(), fireBulletWeapon.getDirection(), fireBulletWeapon.getPosition(), fireBulletWeapon.getSpeed());
                        }

                        ArrayList<FireSonicWaveWeapon> fireSonicWaveList = vehicle.getFireSonicWaveList();
                        for (FireSonicWaveWeapon fireSonicWaveWeapon : fireSonicWaveList) {
                            countPositionsForWeapons(fireSonicWaveWeapon.getSteeringWheel(), fireSonicWaveWeapon.getDirection(), fireSonicWaveWeapon.getPosition(), fireSonicWaveWeapon.getSpeed());
                        }

                        ArrayList<InTheAirChimneyBlastWeapon> inTheAirChimneyBlastWeaponList = vehicle.getInTheAirChimneyBlastList();
                        for (InTheAirChimneyBlastWeapon inTheAirChimneyBlastWeapon : inTheAirChimneyBlastWeaponList) {
                            countPositionsForWeapons(null, Direction.UP, inTheAirChimneyBlastWeapon.getPosition(), inTheAirChimneyBlastWeapon.getSpeed());
                        }
                    }

                    // count health for vehicles
                    countHealthForVehicles(vehicles);

                    for (Vehicle vehicle : vehicles) {
                        /*if (!noHealthVehicles.contains(vehicle.getName())) {
                            System.out.println(vehicle.getType().toString() + " " + vehicle.getName() + "'s health: " + vehicle.getHealth());
                        }*/
                        if (vehicle.getHealth() <= 0) {
                            noHealthVehicles.add(vehicle.getName());
                        }
                    }

                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    /**
     * count health for vehicles
     * @param vehicles
     */
    private void countHealthForVehicles(ArrayList<Vehicle> vehicles) {
        ArrayList<RearDefenseMineWeapon> rearDefenseMineList = new ArrayList();
        for (Vehicle vehicle : vehicles) {
            RearDefenseMineWeapon rearDefenseMineWeapon = vehicle.getRearDefenseMine();
            rearDefenseMineWeapon.setVehicle(vehicle);
            rearDefenseMineList.add(rearDefenseMineWeapon);
        }
        for (Vehicle vehicle : vehicles) {
            ArrayList<FireBulletWeapon> fireBulletList = vehicle.getFireBulletList();
            for (FireBulletWeapon fireBulletWeapon : fireBulletList) {
                if (!vehicle.equals(fireBulletWeapon.getVehicle())) {
                    if ((vehicle.getPosition().getX() >= fireBulletWeapon.getPosition().getX() - fireBulletWeapon.getSize().getX() / 2)
                            && (vehicle.getPosition().getX() <= fireBulletWeapon.getPosition().getX() + fireBulletWeapon.getSize().getX() / 2)
                            && (vehicle.getPosition().getY() <= fireBulletWeapon.getPosition().getY() + fireBulletWeapon.getSize().getY() / 2)
                            && (vehicle.getPosition().getY() <= fireBulletWeapon.getPosition().getY() + fireBulletWeapon.getSize().getY() / 2)
                            && (vehicle.getPosition().getZ() <= fireBulletWeapon.getPosition().getZ() + fireBulletWeapon.getSize().getZ() / 2)
                            && (vehicle.getPosition().getZ() <= fireBulletWeapon.getPosition().getY() + fireBulletWeapon.getSize().getZ() / 2)) {
                        double health = Math.floor(vehicle.getHealth() * (1 - fireBulletWeapon.getHealthReduced() / 100) * 100) / 100;
                        vehicle.setHealth(health);
                        System.out.println("Vehicle " + vehicle.getName() + " and a fire bullet from vehicle " + fireBulletWeapon.getVehicle().getName() + " collide at position : " + vehicle.getPosition() + " vehicle health: " + health);
                    }
                }
            }
            ArrayList<FireSonicWaveWeapon> fireSonicWaveList = vehicle.getFireSonicWaveList();
            for (FireSonicWaveWeapon fireSonicWaveWeapon : fireSonicWaveList) {
                if (!vehicle.equals(fireSonicWaveWeapon.getVehicle())) {
                    if ((vehicle.getPosition().getX() >= fireSonicWaveWeapon.getPosition().getX() - fireSonicWaveWeapon.getSize().getX() / 2)
                            && (vehicle.getPosition().getX() <= fireSonicWaveWeapon.getPosition().getX() + fireSonicWaveWeapon.getSize().getX() / 2)
                            && (vehicle.getPosition().getY() <= fireSonicWaveWeapon.getPosition().getY() + fireSonicWaveWeapon.getSize().getY() / 2)
                            && (vehicle.getPosition().getY() <= fireSonicWaveWeapon.getPosition().getY() + fireSonicWaveWeapon.getSize().getY() / 2)
                            && (vehicle.getPosition().getZ() <= fireSonicWaveWeapon.getPosition().getZ() + fireSonicWaveWeapon.getSize().getZ() / 2)
                            && (vehicle.getPosition().getZ() <= fireSonicWaveWeapon.getPosition().getY() + fireSonicWaveWeapon.getSize().getZ() / 2)) {
                        double health = Math.floor(vehicle.getHealth() * (1 - fireSonicWaveWeapon.getHealthReduced() / 100) * 100) / 100;
                        vehicle.setHealth(health);
                        System.out.println("Vehicle " + vehicle.getName() + " and a sonic wave from vehicle " + fireSonicWaveWeapon.getVehicle().getName() + " collide at position : " + vehicle.getPosition() + " vehicle health: " + health);
                    }
                }
            }
            ArrayList<InTheAirChimneyBlastWeapon> inTheAirChimneyBlastList = vehicle.getInTheAirChimneyBlastList();
            for (InTheAirChimneyBlastWeapon inTheAirChimneyBlastWeapon : inTheAirChimneyBlastList) {
                if (!vehicle.equals(inTheAirChimneyBlastWeapon.getVehicle())) {
                    if ((vehicle.getPosition().getX() >= inTheAirChimneyBlastWeapon.getPosition().getX() - inTheAirChimneyBlastWeapon.getRadius() / 2)
                            && (vehicle.getPosition().getX() <= inTheAirChimneyBlastWeapon.getPosition().getX() + inTheAirChimneyBlastWeapon.getRadius() / 2)
                            && (vehicle.getPosition().getY() <= inTheAirChimneyBlastWeapon.getPosition().getY() + inTheAirChimneyBlastWeapon.getRadius() / 2)
                            && (vehicle.getPosition().getY() <= inTheAirChimneyBlastWeapon.getPosition().getY() + inTheAirChimneyBlastWeapon.getRadius() / 2)
                            && (vehicle.getPosition().getZ() == inTheAirChimneyBlastWeapon.getPosition().getZ())) {
                        double health = Math.floor(vehicle.getHealth() * (1 - inTheAirChimneyBlastWeapon.getHealthReduced() / 100) * 100) / 100;
                        vehicle.setHealth(health);
                        System.out.println("Vehicle " + vehicle.getName() + " and a chimney blast from vehicle " + inTheAirChimneyBlastWeapon.getVehicle().getName() + " collide at position : " + vehicle.getPosition() + " vehicle health: " + health);
                    }
                }
            }
            ArrayList<RearDefenseMineWeapon> rearDefenseMineWeaponList = rearDefenseMineList;
            for (RearDefenseMineWeapon rearDefenseMineWeapon : rearDefenseMineWeaponList) {
                if (!vehicle.equals(rearDefenseMineWeapon.getVehicle())) {
                    if ((vehicle.getPosition().getX() >= rearDefenseMineWeapon.getPosition().getX() - rearDefenseMineWeapon.getSize().getX() / 2)
                            && (vehicle.getPosition().getX() <= rearDefenseMineWeapon.getPosition().getX() + rearDefenseMineWeapon.getSize().getX() / 2)
                            && (vehicle.getPosition().getY() <= rearDefenseMineWeapon.getPosition().getY() + rearDefenseMineWeapon.getSize().getY() / 2)
                            && (vehicle.getPosition().getY() <= rearDefenseMineWeapon.getPosition().getY() + rearDefenseMineWeapon.getSize().getY() / 2)
                            && (vehicle.getPosition().getZ() <= rearDefenseMineWeapon.getPosition().getZ() + rearDefenseMineWeapon.getSize().getZ() / 2)
                            && (vehicle.getPosition().getZ() <= rearDefenseMineWeapon.getPosition().getY() + rearDefenseMineWeapon.getSize().getZ() / 2)) {
                        double health = Math.floor(vehicle.getHealth() * (1 - rearDefenseMineWeapon.getHealthReduced() / 100) * 100) / 100;
                        vehicle.setHealth(health);
                        System.out.println("Vehicle " + vehicle.getName() + " and a rear defense mine from vehicle " + rearDefenseMineWeapon.getVehicle().getName() + " collide at position : " + vehicle.getPosition() + " vehicle health: " + health);
                    }
                }
            }
        }
    }

    /**
     * count positions for weapons
     * @param steeringWheel steeringWheel
     * @param direction direction
     * @param position position
     * @param speed speed
     */
    public void countPositionsForWeapons(SteeringWheel steeringWheel, Direction direction, Position position, double speed) {
        if (direction.equals(Direction.STRAIGHT)) {
            if (steeringWheel.equals(SteeringWheel.LEFT)) {
                double x = Utils.sub(position.getX(), speed / 100);
                if (x < -10 || x > 10) {
                    x = 0;
                }
                position.setX(x);
            } else if (steeringWheel.equals(SteeringWheel.CENTER)) {
                double y = Utils.add(position.getY(), speed / 100);
                if (y > 100) {
                    y = 0;
                }
                position.setY(y);
            } else if (steeringWheel.equals(SteeringWheel.RIGHT)) {
                double x = Utils.add(position.getX(), speed / 100);
                if (x < -10 || x > 10) {
                    x = 0;
                }
                position.setX(x);
            }
        } else if (direction.equals(Direction.UP)) {
            double z = Utils.add(position.getZ(), speed / 100);
            if (z < 5 || z > 15) {
                z = 10;
            }
            position.setZ(z);
        } else if (direction.equals(Direction.DOWN)) {
            double z = Utils.sub(position.getZ(), speed / 100);
            if (z < 5 || z > 15) {
                z = 10;
            }
            position.setZ(z);
        }
    }

    /**
     * start thread to fire a weapon every 2s
     * @param vehicle  vehicle
     */
    public void scheduleFire(Vehicle vehicle) {
        final long timeInterval = 2000;
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    int randomWeaponType = new Random().nextInt(WeaponType.values().length);
                    WeaponType weaponType = WeaponType.values()[randomWeaponType];
                    vehicle.fire(weaponType);
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    /**
     * start a thread to move weapons every 5s
     * @param vehicle
     */
    public void scheduleMove(Vehicle vehicle) {
        final long timeInterval = 5000;
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    switch (vehicle.getType()) {
                        case LANDVEHICLE:
                            if (vehicle.getHealth() > 0) {
                                moveLandVehicle(vehicle);
                            }
                            break;
                        case AIRVEHICLE:
                            if (vehicle.getHealth() > 0) {
                                moveAirVehicle(vehicle);
                            }
                            break;
                    }
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    /**
     * move LandVihicle
     * @param vehicle give name
     */
    public void moveLandVehicle(Vehicle vehicle) {
        Random random = new Random();
        double randomGasPedalSpeed = random.nextInt(40);
        double randomBrakePedalSpeed = random.nextInt(40);
        int randomPedal = new Random().nextInt(Pedal.values().length);
        Pedal pedal = Pedal.values()[randomPedal];
        int randomSteeringWheel = new Random().nextInt(SteeringWheel.values().length);
        SteeringWheel steeringWheel = SteeringWheel.values()[randomSteeringWheel];
        vehicle.move(pedal, randomGasPedalSpeed, randomBrakePedalSpeed, 0, steeringWheel, Direction.STRAIGHT);
        System.out.println(vehicle.toString());
    }

    /**
     * move AirVihicle
     * @param vehicle give name
     */
    public void moveAirVehicle(Vehicle vehicle) {
        Random random = new Random();
        double propellerSpeed = random.nextInt(20) - 10;
        int randomSteeringWheel = new Random().nextInt(SteeringWheel.values().length);
        SteeringWheel steeringWheel = SteeringWheel.values()[randomSteeringWheel];
        // int randomDirection = new Random().nextInt(Direction.values().length);
        int randomDirection = random.nextInt(3);
        Direction direction = Direction.values()[randomDirection];
        vehicle.move(null, 0, 0, propellerSpeed, steeringWheel, direction);
        System.out.println(vehicle.toString());
    }
}