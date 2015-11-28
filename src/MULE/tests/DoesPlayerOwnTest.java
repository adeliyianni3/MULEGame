package MULE.tests;

import MULE.controllers.Diffuculty;
import MULE.controllers.Game;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import MULE.models.Player;
import javafx.scene.paint.Color;

// Created by Aaron on 11/4/2015.
public class DoesPlayerOwnTest {
    @Test
    public void doesPlayerOwnTest() {
        Game game = new Game();
        Player p = new Player("Aaron", "humanoid", Color.BLUE, Diffuculty.BEGGINER.getPlayerFood(), Diffuculty.BEGGINER.getPlayerEnergy());
        for (int i = 0; i < 4; i++) {
            p.addLand(game.getTheMap().whatLand(i,2*i));
        }
        assert(p.getLand().size() == 4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 9; j++) {
                if ((2 * i) == j)
                    assertTrue(game.doesPlayerOwn(p, game.getTheMap().whatLand(i, j)));
                else
                    assertFalse(game.doesPlayerOwn(p, game.getTheMap().whatLand(i, j)));
            }
        }
    }

}
