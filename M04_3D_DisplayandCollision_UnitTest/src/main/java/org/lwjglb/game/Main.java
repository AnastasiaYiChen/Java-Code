package org.lwjglb.game;

import com.weapons.*;
import org.lwjglb.engine.GameEngine;
import org.lwjglb.engine.IGameLogic;
import org.lwjglb.engine.Window;
import org.lwjglb.engine.items.GameItem;

import java.util.ArrayList;

/**
 * Original code
 * URL:    https://lwjglgamedev.gitbooks.io/3d-game-development-with-lwjgl/content/
 * Author: Antonio Hernández Bejarano
 * <p>
 * Update Author:  Russ
 * Dec 9, 2018:  I started making the code easier for students to update and include their own shapes.
 * Goto DummyGame class to see how to add your own shapes.
 *
 */
public class Main {

    public static void main(String[] args) {

        // <RS> Added some handy directory and Java info
        System.out.println("Directory = " + System.getProperty("user.dir"));
        System.out.println("Java = " + System.getProperty("java.vendor"));
        System.out.println("Java = " + System.getProperty("java.version"));

        ArrayList<GameItem> vehicles = new ArrayList<>();
        GameItem vehicleToyota = new LandVehicle(VehicleType.LANDVEHICLE, "Toyota");
        GameItem vehicleVolkswagen = new LandVehicle(VehicleType.LANDVEHICLE, "Volkswagen");
        GameItem vehicleFord = new LandVehicle(VehicleType.LANDVEHICLE, "Ford");
        GameItem vehicleBoeing = new AirVehicle(VehicleType.AIRVEHICLE, "Boeing");
        GameItem vehicleAirbus = new AirVehicle(VehicleType.AIRVEHICLE, "Airbus");
        GameItem vehicleBombardier = new AirVehicle(VehicleType.AIRVEHICLE, "Bombardier");
        vehicles.add(vehicleToyota);
        vehicles.add(vehicleVolkswagen);
        vehicles.add(vehicleFord);
        vehicles.add(vehicleBoeing);
        vehicles.add(vehicleAirbus);
        vehicles.add(vehicleBombardier);
        com.weapons.Main mainVehicle = new com.weapons.Main();
        for (GameItem vehicle: vehicles) {
            mainVehicle.scheduleMove(vehicle);
        }

        try {
            boolean vSync = true;
            IGameLogic gameLogic = new DummyGame(vehicles);
            Window.WindowOptions opts = new Window.WindowOptions();
            opts.cullFace = false;
            opts.showFps = true;
            opts.compatibleProfile = true;
            opts.antialiasing = true;
            opts.frustumCulling = false;
            GameEngine gameEng = new GameEngine("GAME", vSync, opts, gameLogic);
            gameEng.start();
        } catch (Exception excp) {
            excp.printStackTrace();
            System.exit(-1);
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Setup jFrame for controls
        GameGUI.guiSetup();

    }
}
