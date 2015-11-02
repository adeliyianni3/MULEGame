package MULE.models;

import javafx.scene.paint.Color;
import org.junit.Test;

/**
 * Created by Antonia on 11/1/2015.
 */
public class ComputeTimerTest {
    @Test
    public void computeTimerTest(){
        PlayerTimer test = new PlayerTimer();
        Player p = new Player("name", "humanoid", Color.AZURE);
        for (int i = 3; i < 15; i++) {
            assert(test.computeTime(p, i) == 50);
        }
        for (int j = 0; j < 3; j++) {
            p.removeFood();
        }
        for (int i = 3; i < 15; i++) {
            assert(test.computeTime(p, i) == 50);
        }
        p.removeFood();
        for (int i = 3; i < 11; i++) {
            assert(test.computeTime(p, i) == 50);
        }
        for (int i = 11; i < 15; i++) {
            assert(test.computeTime(p, i) == 30);
        }
        p.removeFood();
        for (int i = 3; i < 7; i++) {
            assert(test.computeTime(p, i) == 50);
        }
        for (int i = 8; i < 15; i++) {
            assert(test.computeTime(p, i) == 30);
        }
        p.removeFood();
        for (int i = 3; i < 15; i++) {
            assert(test.computeTime(p, i) == 30);
        }
        for (int j = 0; j < 2; j++) {
            p.removeFood();
        }
        for (int i = 3; i < 15; i++) {
            assert(test.computeTime(p, i) == 5);
        }
    }
}
