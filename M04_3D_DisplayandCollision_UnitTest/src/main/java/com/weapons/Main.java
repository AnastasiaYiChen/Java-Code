package com.weapons;
/**
 * @author Yi Chen
 */
import org.lwjglb.engine.items.GameItem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static com.weapons.VehicleType.AIRVEHICLE;
import static com.weapons.VehicleType.LANDVEHICLE;

/**
 * main class
 *
 */
public class Main {
    /**
     * main method
     * @param args to call the main function in java. The main method is called if it’s formal parameter matches that of an array of Strings.
     */
    public static void main(String[] args) {
        Main main = new Main();
        ArrayList<GameItem> vehicles = new ArrayList<>();
        GameItem vehicleToyota = new LandVehicle(LANDVEHICLE, "Toyota");
        GameItem vehicleVolkswagen = new LandVehicle(LANDVEHICLE, "Volkswagen");
        GameItem vehicleFord = new LandVehicle(LANDVEHICLE, "Ford");
        GameItem vehicleBoeing = new AirVehicle(AIRVEHICLE, "Boeing");
        GameItem vehicleAirbus = new AirVehicle(AIRVEHICLE, "Airbus");
        GameItem vehicleBombardier = new AirVehicle(AIRVEHICLE, "Bombardier");
        vehicles.add(vehicleToyota);
        vehicles.add(vehicleVolkswagen);
        vehicles.add(vehicleFord);
        vehicles.add(vehicleBoeing);
        vehicles.add(vehicleAirbus);
        vehicles.add(vehicleBombardier);
        for (GameItem vehicle: vehicles) {
            main.scheduleMove(vehicle);
        }
    }

    /**
     * start a thread to move weapons every 5s
     * @param vehicle
     */
    public void scheduleMove(GameItem vehicle) {
        final long timeInterval = 5000;
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    if (vehicle instanceof LandVehicle) {
                        moveLandVehicle((LandVehicle)vehicle);
                    } else if (vehicle instanceof AirVehicle) {
                        moveAirVehicle((AirVehicle)vehicle);
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
    public void moveLandVehicle(LandVehicle vehicle) {
        Random random = new Random();
        float randomGasPedalSpeed = random.nextInt(40);
        float randomBrakePedalSpeed = random.nextInt(40);
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
    public void moveAirVehicle(AirVehicle vehicle) {
        Random random = new Random();
        float propellerSpeed = random.nextInt(20) - 10;
        int randomSteeringWheel = new Random().nextInt(SteeringWheel.values().length);
        SteeringWheel steeringWheel = SteeringWheel.values()[randomSteeringWheel];
        // int randomDirection = new Random().nextInt(Direction.values().length);
        int randomDirection = random.nextInt(3);
        Direction direction = Direction.values()[randomDirection];
        vehicle.move(null, 0, 0, propellerSpeed, steeringWheel, direction);
        System.out.println(vehicle.toString());
    }
}