package com.dorthy;

import javax.xml.crypto.Data;

public class Dorthy {
    public enum OZpeople {SCARECROW, COWARDLYLION, TINMAN}
    public enum OZcolors {BROWN, YELLOW, SILVER}

    private static OZpeople likes;
    private static OZcolors color;

    /**
     * Constructor for static data area. Set a default.
     *
     * @param favoriteCharacter
     * @param favoriteColor
     */
    public Dorthy(OZpeople favoriteCharacter, OZcolors favoriteColor ) {
        Dorthy.likes = favoriteCharacter;
        Dorthy.color = favoriteColor;
    }

    /**
     * Get the string version of the data appended. We get all one set of data
     * this way.
     *
     * @return A string which is the data fields appended.
     */
    public static String getStaticThreadperson() {
        return "favoriteCharacter= " + Dorthy.likes + " favoriteColor= " + Dorthy.color;
    }


    /**
     * Set the static fields here.
     *
     * @param favoriteCharacter
     * @param favoriteColor
     */
    public static void setStaticThreadperson(OZpeople favoriteCharacter, OZcolors favoriteColor) {
        //public synchronized static void setStaticThreadperson(OZpeople favoriteCharacter, OZcolors favoriteColor) {
        Dorthy.likes = favoriteCharacter;
        mySleep(20);
        Dorthy.color = favoriteColor;
        mySleep(20);
    }

    public static void mySleep(int d) {
        try {
            Thread.sleep(d);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}