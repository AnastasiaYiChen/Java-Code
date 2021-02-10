package junit;

import org.joml.Quaternionf;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lwjglb.engine.Scene;
import org.lwjglb.engine.items.GameItem;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LandVehicleTest {
    Scene scene;

    @Before
    public void setUp() throws Exception {
        scene = new Scene();

        GameItem russ_shape_01 = new GameItem();
        russ_shape_01.setPosition(15.00f, 10.000f, .000f);
        russ_shape_01.setVelocity(-0.005f, 0.000001f, 0.000001f);
        russ_shape_01.setRotationVel(new Quaternionf(0.00f, 0.0f, 0.0f, 0.0f));
        russ_shape_01.setScale(1.0f);

        GameItem russ_shape_03 = new GameItem();
        russ_shape_01.setPosition(15.00f, 10.000f, .000f);
        russ_shape_03.setVelocity(0.005f, 0.000001f, 0.000001f);
        russ_shape_03.setRotationVel(new Quaternionf(0.00f, 0.0f, 0.0f, 0.0f));
        russ_shape_03.setScale(0.50f);

        scene.setGameItems(new GameItem[]{russ_shape_01, russ_shape_03});
    }

    @After
    public void tearDown() throws Exception {
        scene = null;
    }

    @Test
    public void doesItCollide() throws Exception {
        List<GameItem> gameItems = scene.getgameItems();
        for (GameItem outer : gameItems) {
            for (GameItem inner : gameItems) {
                if (outer != inner) {
                    boolean collide = inner.DoesItCollide(outer);
                    assertTrue(!collide);
                }
            }
        }
    }
}