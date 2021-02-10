package com.synchDorthy;

/**
 * Make a few threads compete for a static set of fields.
 * 
 * @author Ezra, then Russ
 * 
 */
public class threadMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        thread a = new thread(Dorthy.OZpeople.TINMAN, Dorthy.OZcolors.SILVER);
        a.start();

        thread b = new thread(Dorthy.OZpeople.SCARECROW, Dorthy.OZcolors.BROWN);
        b.start();

        thread c = new thread(Dorthy.OZpeople.COWARDLYLION, Dorthy.OZcolors.YELLOW);
        c.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
                System.out.println(Dorthy.getStaticThreadperson());
                //String s = Data.getStaticThreadperson();
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        //System.out.println(thread.favoriteCharacter.character + " " + thread.favoriteColor.color + " " );
        }

    }
}
