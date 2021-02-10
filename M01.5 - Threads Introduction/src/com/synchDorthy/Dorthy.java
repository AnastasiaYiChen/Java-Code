package com.synchDorthy;

/**
 *
 */
public class Dorthy {
    public enum OZpeople {SCARECROW, COWARDLYLION, TINMAN}
    public enum OZcolors {BROWN, YELLOW, SILVER}

    public static OZpeople favoriteCharacter;
    public static OZcolors favoriteColor;

    /**
     * Constructor for static data area. Set a default.
     *
     * @param favoriteCharacter
     * @param favoriteColor
     */
    public Dorthy(OZpeople favoriteCharacter, OZcolors favoriteColor ) {
        Dorthy.favoriteCharacter = favoriteCharacter;
        Dorthy.favoriteColor = favoriteColor;
    }

    /**
     * Get the string version of the data appended. We get all one set of data
     * this way.
     *
     * @return A string which is the data fields appended.
     */
    public synchronized static String getStaticThreadperson() {
        return "favoriteCharacter= " + Dorthy.favoriteCharacter + " favoriteColor= " + Dorthy.favoriteColor;
    }


    /**
     * Set the static fields here.
     *
     * @param favoriteCharacter
     * @param favoriteColor
     */
    public synchronized static void setStaticThreadperson(OZpeople favoriteCharacter, OZcolors favoriteColor) {
        //public synchronized static void setStaticThreadperson(String name, long phone, long cell, String email) {
        Dorthy.favoriteCharacter = favoriteCharacter;
        mySleep(20);
        Dorthy.favoriteColor = favoriteColor;
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