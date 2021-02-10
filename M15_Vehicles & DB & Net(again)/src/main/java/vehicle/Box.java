package vehicle;

public class Box {

    int xMin, xMax, yMin, yMax;

    public void set(int x, int y, int width, int height) {
        xMin = x;
        xMax = x + width - 1;
        yMin = y;
        yMax = y + height - 1;

    }


}
