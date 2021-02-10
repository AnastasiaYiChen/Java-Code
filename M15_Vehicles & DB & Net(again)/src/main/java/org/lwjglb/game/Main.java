package org.lwjglb.game;

import org.lwjglb.engine.GameEngine;
import org.lwjglb.engine.IGameLogic;
import org.lwjglb.engine.Window;
import vehicle.*;

import java.sql.*;
import java.util.Random;

/**
 *
 */
public class Main {
    static Connection con;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        // <RS> Added some handy directory and Java info
        System.out.println("Directory = " + System.getProperty("user.dir"));
        System.out.println("Java = " + System.getProperty("java.vendor"));
        System.out.println("Java = " + System.getProperty("java.version"));


        try {
            boolean vSync = true;
            IGameLogic gameLogic = new DummyGame();
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
        //+++++++++++++++++++++++++++++++++++++++++


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Setup jFrame for controls
        GameGUI.guiSetup();

    }

}
