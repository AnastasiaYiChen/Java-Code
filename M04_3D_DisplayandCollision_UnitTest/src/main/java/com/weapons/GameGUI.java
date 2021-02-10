package com.weapons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI {
    private JPanel panelMain;

    private JButton clearButton;
    private JButton resetButton;
    private JButton addLandVehicleButton;
    private JButton addAirVehicleButton;


    private static Boolean clearCommand = false;
    private static Boolean resetCommand = false;
    private static Boolean addLandVehicleCommand = false;
    private static Boolean addAirVehicleCommand = false;


    public GameGUI() {

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearCommand = true;
                System.out.println(" Clear Button");
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetCommand = true;
            }
        });

        addLandVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addLandVehicleCommand = true;
            }
        });

        addAirVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAirVehicleCommand = true;
            }
        });

    }


    public static void guiSetup() {
        JFrame frame = new JFrame("GameGUI");
        frame.setContentPane(new GameGUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(150, 150);  //so it isn't at very top left
        frame.setVisible(true);
    }

    // Force that when reset vaue is read back as true, it is reset to false
    // so that we don't get a studder of multiple resets.
    // Also, DO NOT include a setter for this field as that would defeat the design.
    public static Boolean getClearCommand() {
        boolean returnValue = false;
        if (clearCommand == true) {
            clearCommand = false;
            returnValue = true;
        }
        return returnValue;
    }

    public static Boolean getResetCommand() {
        boolean returnValue = false;
        if (resetCommand == true) {
            resetCommand = false;
            returnValue = true;
        }
        return returnValue;
    }

    public static Boolean getAddLandVehicleCommand() {
        boolean returnValue = false;
        if (addLandVehicleCommand == true) {
            addLandVehicleCommand = false;
            returnValue = true;
        }
        return returnValue;
    }

    public static Boolean getAddAirVehicleCommand() {
        boolean returnValue = false;
        if (addAirVehicleCommand == true) {
            addAirVehicleCommand = false;
            returnValue = true;
        }
        return returnValue;
    }
}
