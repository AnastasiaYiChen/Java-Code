package com.vehicle;
/**
 * @author Yi Chen
 */
import java.util.Random;

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
        System.out.println("---------------------------------------------------------------------------------------");
        main.moveLandVehicle("Toyota");
        System.out.println("---------------------------------------------------------------------------------------");
        main.moveLandVehicle("Volkswagen");
        System.out.println("---------------------------------------------------------------------------------------");
        main.moveLandVehicle("Ford");
        System.out.println("---------------------------------------------------------------------------------------");
        main.moveAirVehicle("Boeing");
        System.out.println("---------------------------------------------------------------------------------------");
        main.moveAirVehicle("Airbus");
        System.out.println("---------------------------------------------------------------------------------------");
        main.moveAirVehicle("Bombardier");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    /**
     * move LandVihicle for 10 actions
     * @param name give name
     */
    public void moveLandVehicle(String name) {
        Vehicle vehicle = new LandVehicle("LandVehicle", name);
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            double randomGasPedalSpeed = random.nextInt(10);
            double randomBrakePedalSpeed = random.nextInt(10);
            int randomPedal = new Random().nextInt(Pedal.values().length);
            Pedal pedal = Pedal.values()[randomPedal];
            int randomSteeringWheel = new Random().nextInt(SteeringWheel.values().length);
            SteeringWheel steeringWheel = SteeringWheel.values()[randomSteeringWheel];
            vehicle.move(pedal, randomGasPedalSpeed, randomBrakePedalSpeed, 0, steeringWheel, Direction.STRAIGHT);
            System.out.println(vehicle.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * move AirVihicle for 10 actions
     * @param name give name
     */
    public void moveAirVehicle(String name) {
        Vehicle vehicle = new AirVehicle("AirVehicle", name);
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            double propellerSpeed = random.nextInt(20) - 10;
            int randomSteeringWheel = new Random().nextInt(SteeringWheel.values().length);
            SteeringWheel steeringWheel = SteeringWheel.values()[randomSteeringWheel];
            int randomDirection = new Random().nextInt(Direction.values().length);
            Direction direction = Direction.values()[randomDirection];
            vehicle.move(null, 0, 0, propellerSpeed, steeringWheel, direction);
            System.out.println(vehicle.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}