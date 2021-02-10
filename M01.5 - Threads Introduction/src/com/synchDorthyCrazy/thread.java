package com.synchDorthyCrazy;

/**
 * @author Ezra, then Russ
 * @description Try's to change data of a person
 */
public class thread extends Thread {

    /**
     * This copy of data to use to overwrite
     */
    public Dorthy.OZpeople character;
    public Dorthy.OZcolors color;

    /**
     * thread receives person information
     * @param character character
     * @param color color
     */
    public thread(Dorthy.OZpeople character, Dorthy.OZcolors color) {
        this.character = character;
        this.color = color;
    }

    /**
     * Loop setting character, color, etc.. into static area.
     */
    @Override
    public void run() {
        System.out.println("Start thread " + this.character);
        try {
            for (int i = 0; i < 1000000; i++) {
                Dorthy.setStaticThreadperson(this.character, this.color);
                //System.out.println("Loop thread " + i + " "+ this.name);
                Thread.sleep(30);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
