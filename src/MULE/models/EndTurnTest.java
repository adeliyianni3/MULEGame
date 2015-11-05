package MULE.models;

import MULE.Main;
import MULE.controllers.Game;

import MULE.controllers.GameDummy;
import MULE.controllers.ScreenNavigator;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 public int endTurn() {
    ArrayList<Land> plots = currentPlayer().getLand();
        for (Land plot: plots) {
            plot.produce();
        }
    turn = turn % numOfPlayers + 1;
    totalTurns++;
    round = (totalTurns-1) / numOfPlayers;
    if (turn == 1) {
        reorderPlayers();
    }
    System.out.println(round + " " + (round > 14));
    if (round <= 14) {
        timer.startTime();
    } else {
        currentState = State.MAIN; //swap out with display scores later
        ScreenNavigator.instance.loadMain();
    }
    return turn;
 }
 */

//Created by Ethan on 11/1/2015.
@SuppressWarnings("ALL")
public class EndTurnTest {
    /**
     * The test fixture
     */
    GameDummy game1;
    GameDummy game2;
    GameDummy game3;

    /**
     * This method is run before each test
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        Game.instance = game1;
        game1 = new GameDummy();
        Game.instance = game2;
        game2 = new GameDummy();
        Game.instance = game2;
        game3 = new GameDummy();
        Game.instance = game1;
        game1.setNumOfPlayers(1);
        Game.instance = game2;
        game2.setNumOfPlayers(2);
        Game.instance = game3;
        game3.setNumOfPlayers(4);
        Game.instance = game1;
        game1.addPlayer("BUZZITE", Color.RED, "Player 1");
        Game.instance = game2;
        game2.addPlayer("HUMANOID", Color.BLUE, "Pigeon 1");
        game2.addPlayer("HUMANOID", Color.MAGENTA, "Pigeon 2");
        Game.instance = game3;
        game3.addPlayer("FLAPPER", Color.CYAN, "A");
        game3.addPlayer("BONZOID", Color.BROWN, "B");
        game3.addPlayer("UGAITE", Color.PINK, "C");
        game3.addPlayer("BUZZITE", Color.YELLOW, "D");
        System.out.println("Initialized");
        Assert.assertEquals("game1 initialization incorrect", game1.getPlayers().length, 1);
        Assert.assertEquals("game2 initialization incorrect", game2.getPlayers().length, 2);
        Assert.assertEquals("game3 initialization incorrect", game3.getPlayers().length, 4);
        Player p = game1.players[game1.getTurn() - 1];
        Assert.assertNotNull("game1 not properly initialized", p);
        Game.instance = game1;
        //p = Game.instance.players[Game.instance.getTurn() - 1];
        //Assert.assertNotNull("game1 not properly set to Game.instance", p);
    }

    /**
     *
     */
    @Test
    public void testTurnIncrement() {
        Game.instance = game1;
        Assert.assertEquals("Starting turn wrong", 1, game1.getTurn());
        game1.endTurn();
        Assert.assertEquals("Turn wrong after 1 endTurn()", 1, game1.getTurn());
        game1.endTurn();
        Assert.assertEquals("Turn wrong after 2 endTurn()", 1, game1.getTurn());
        game1.endTurn();
        Assert.assertEquals("Turn wrong after 3 endTurn()", 1, game1.getTurn());
        game1.endTurn();
        Assert.assertEquals("Turn wrong after 4 endTurn()", 1, game1.getTurn());

        Game.instance = game2;
        Assert.assertEquals("Starting turn wrong", 1, game2.getTurn());
        game2.endTurn();
        Assert.assertEquals("Turn wrong after 1 endTurn()", 2, game2.getTurn());
        game2.endTurn();
        Assert.assertEquals("Turn wrong after 2 endTurn()", 1, game2.getTurn());
        game2.endTurn();
        Assert.assertEquals("Turn wrong after 3 endTurn()", 2, game2.getTurn());
        game2.endTurn();
        Assert.assertEquals("Turn wrong after 4 endTurn()", 1, game2.getTurn());

        Game.instance = game3;
        Assert.assertEquals("Starting turn wrong", 1, game3.getTurn());
        game3.endTurn();
        Assert.assertEquals("Turn wrong after 1 endTurn()", 2, game3.getTurn());
        game3.endTurn();
        Assert.assertEquals("Turn wrong after 2 endTurn()", 3, game3.getTurn());
        game3.endTurn();
        Assert.assertEquals("Turn wrong after 3 endTurn()", 4, game3.getTurn());
        game3.endTurn();
        Assert.assertEquals("Turn wrong after 4 endTurn()", 1, game3.getTurn());
    }

    /**
     *
     */
    @Test
    public void testRoundIncrement() {
        Game.instance = game1;
        Assert.assertEquals("Starting round wrong", 1, game1.getRound());
        game1.endTurn();
        Assert.assertEquals("Round wrong after 1 endTurn()", 2, game1.getRound());
        game1.endTurn();
        Assert.assertEquals("Round wrong after 2 endTurn()", 3, game1.getRound());
        game1.endTurn();
        Assert.assertEquals("Round wrong after 3 endTurn()", 4, game1.getRound());
        game1.endTurn();
        Assert.assertEquals("Round wrong after 4 endTurn()", 5, game1.getRound());

        Game.instance = game2;
        Assert.assertEquals("Starting round wrong", 1, game2.getRound());
        game2.endTurn();
        Assert.assertEquals("Round wrong after 1 endTurn()", 1, game2.getRound());
        game2.endTurn();
        Assert.assertEquals("Round wrong after 2 endTurn()", 2, game2.getRound());
        game2.endTurn();
        Assert.assertEquals("Round wrong after 3 endTurn()", 2, game2.getRound());
        game2.endTurn();
        Assert.assertEquals("Round wrong after 4 endTurn()", 3, game2.getRound());

        Game.instance = game3;
        Assert.assertEquals("Starting round wrong", 1, game3.getRound());
        game3.endTurn();
        Assert.assertEquals("Round wrong after 1 endTurn()", 1, game3.getRound());
        game3.endTurn();
        Assert.assertEquals("Round wrong after 2 endTurn()", 1, game3.getRound());
        game3.endTurn();
        Assert.assertEquals("Round wrong after 3 endTurn()", 1, game3.getRound());
        game3.endTurn();
        Assert.assertEquals("Round wrong after 4 endTurn()", 2, game3.getRound());
    }

    /**
     *
     */
    @Test
    public void testTotalTurnsIncrement() {
        Game.instance = game1;
        Assert.assertEquals("Starting totalTurns wrong", 1, game1.getRound());
        game1.endTurn();
        Assert.assertEquals("Round wrong after 1 endTurn()", 2, game1.getRound());
        game1.endTurn();
        Assert.assertEquals("Round wrong after 2 endTurn()", 3, game1.getRound());
        game1.endTurn();
        Assert.assertEquals("Round wrong after 3 endTurn()", 4, game1.getRound());
        game1.endTurn();
        Assert.assertEquals("Round wrong after 4 endTurn()", 5, game1.getRound());

        Game.instance = game2;
        Assert.assertEquals("Starting totalTurns wrong", 1, game2.getRound());
        game2.endTurn();
        Assert.assertEquals("Round wrong after 1 endTurn()", 1, game2.getRound());
        game2.endTurn();
        Assert.assertEquals("Round wrong after 2 endTurn()", 2, game2.getRound());
        game2.endTurn();
        Assert.assertEquals("Round wrong after 3 endTurn()", 2, game2.getRound());
        game2.endTurn();
        Assert.assertEquals("Round wrong after 4 endTurn()", 3, game2.getRound());

        Game.instance = game3;
        Assert.assertEquals("Starting totalTurns wrong", 1, game3.getRound());
        game3.endTurn();
        Assert.assertEquals("Round wrong after 1 endTurn()", 1, game3.getRound());
        game3.endTurn();
        Assert.assertEquals("Round wrong after 2 endTurn()", 1, game3.getRound());
        game3.endTurn();
        Assert.assertEquals("Round wrong after 3 endTurn()", 1, game3.getRound());
        game3.endTurn();
        Assert.assertEquals("Round wrong after 4 endTurn()", 2, game3.getRound());
    }

    /**
     *
     */
    @Test
    public void testPlayerReordering() {
        Game.instance = game1;
        Assert.assertEquals("game1 Player ordering incorrect", "Player 1", game1.getPlayers()[0].getName());
        game1.endTurn();
        Assert.assertEquals("game1 Player ordering incorrect", "Player 1", game1.getPlayers()[0].getName());

        Game.instance = game2;
        game2.endTurn();
        game2.endTurn();
        Assert.assertTrue("game2 Player ordering incorrect", game2.getPlayers()[0].getScore() <= game2.getPlayers()[1].getScore());
        game2.endTurn();
        game2.endTurn();
        Assert.assertTrue("game2 Player ordering incorrect", game2.getPlayers()[0].getScore() <= game2.getPlayers()[1].getScore());

        Game.instance = game3;
        game3.endTurn();
        game3.endTurn();
        game3.endTurn();
        game3.endTurn();
        Assert.assertTrue("game3 Player ordering incorrect", game3.getPlayers()[0].getScore() <= game3.getPlayers()[1].getScore()
                && game3.getPlayers()[1].getScore() <= game3.getPlayers()[2].getScore()
                && game3.getPlayers()[2].getScore() <= game3.getPlayers()[3].getScore());
        game3.endTurn();
        game3.endTurn();
        game3.endTurn();
        game3.endTurn();
        Assert.assertTrue("game3 Player ordering incorrect", game3.getPlayers()[0].getScore() <= game3.getPlayers()[1].getScore()
                && game3.getPlayers()[1].getScore() <= game3.getPlayers()[2].getScore()
                && game3.getPlayers()[2].getScore() <= game3.getPlayers()[3].getScore());
        game3.endTurn();
        game3.endTurn();
        game3.endTurn();
        game3.endTurn();
        Assert.assertTrue("game3 Player ordering incorrect", game3.getPlayers()[0].getScore() <= game3.getPlayers()[1].getScore()
                && game3.getPlayers()[1].getScore() <= game3.getPlayers()[2].getScore()
                && game3.getPlayers()[2].getScore() <= game3.getPlayers()[3].getScore());
    }

    /**
     *
     */
    @Test
    public void testGameEnd() {
        Game.instance = game1;
        for (int i = 0; i < 13; i++) {
            game1.endTurn();
        }
        Assert.assertTrue("game1 pre-end State incorrect", game1.currentState == Game.State.MAP);
        game1.endTurn();
        Assert.assertTrue("game1 post-end State incorrect", game1.currentState.equals(Game.State.MAIN));

        Game.instance = game2;
        for (int i = 0; i < 13; i++) {
            game2.endTurn();
            game2.endTurn();
        }
        Assert.assertTrue("game2 pre-end State incorrect", game2.currentState.equals(Game.State.MAP));
        game2.endTurn();
        game2.endTurn();
        Assert.assertTrue("game2 post-end State incorrect", game2.currentState.equals(Game.State.MAIN));

        Game.instance = game3;
        for (int i = 0; i < 13; i++) {
            game3.endTurn();
            game3.endTurn();
            game3.endTurn();
            game3.endTurn();
        }
        Assert.assertTrue("game3 pre-end State incorrect", game3.currentState.equals(Game.State.MAP));
        game3.endTurn();
        game3.endTurn();
        game3.endTurn();
        game3.endTurn();
        Assert.assertTrue("game3 post-end State incorrect", game3.currentState.equals(Game.State.MAIN));
    }

    /**
     *
     */
    @Test
    public void testLandProduction() {
        Mule smithoreMule = new Mule(new SmithOre());

        Game.instance = game1;
        game1.landClicked("etc00", new Rectangle(), new Rectangle());
        game1.landClicked("etc01", new Rectangle(), new Rectangle());
        game1.buyPhaseSkip();
        game1.getPlayers()[0].giveMule(smithoreMule);
        int game11Smithore = game1.getPlayers()[0].getSmithore();
        game1.currentState = GameDummy.State.MULE_PLACING;
        game1.landClicked("etc00", new Rectangle(), new Rectangle());
        game1.endTurn();
        Assert.assertNotEquals("game1 production incorrect", game11Smithore, game1.getPlayers()[0].getSmithore());

        Game.instance = game2;
        game2.landClicked("etc00", new Rectangle(), new Rectangle());
        game2.landClicked("etc01", new Rectangle(), new Rectangle());
        game2.landClicked("etc10", new Rectangle(), new Rectangle());
        game2.landClicked("etc11", new Rectangle(), new Rectangle());
        game2.buyPhaseSkip();
        game2.buyPhaseSkip();
        game2.getPlayers()[0].giveMule(smithoreMule);
        game2.getPlayers()[1].giveMule(smithoreMule);
        int game21Smithore = game2.getPlayers()[0].getSmithore();
        game2.currentState = GameDummy.State.MULE_PLACING;
        game2.landClicked("etc00", new Rectangle(), new Rectangle());
        game2.endTurn();
        Assert.assertNotEquals("game2 production incorrect", game21Smithore, game2.getPlayers()[0].getSmithore());
        int game22Smithore = game2.getPlayers()[1].getSmithore();
        game2.currentState = GameDummy.State.MULE_PLACING;
        game2.landClicked("etc01", new Rectangle(), new Rectangle());
        game2.endTurn();
        Assert.assertNotEquals("game2 production incorrect", game22Smithore, game2.getPlayers()[1].getSmithore());

        Game.instance = game3;
        game3.landClicked("etc00", new Rectangle(), new Rectangle());
        game3.landClicked("etc01", new Rectangle(), new Rectangle());
        game3.landClicked("etc10", new Rectangle(), new Rectangle());
        game3.landClicked("etc11", new Rectangle(), new Rectangle());
        game3.landClicked("etc20", new Rectangle(), new Rectangle());
        game3.landClicked("etc21", new Rectangle(), new Rectangle());
        game3.landClicked("etc30", new Rectangle(), new Rectangle());
        game3.landClicked("etc31", new Rectangle(), new Rectangle());
        game3.buyPhaseSkip();
        game3.buyPhaseSkip();
        game3.buyPhaseSkip();
        game3.buyPhaseSkip();
        game3.getPlayers()[0].giveMule(smithoreMule);
        game3.getPlayers()[1].giveMule(smithoreMule);
        game3.getPlayers()[2].giveMule(smithoreMule);
        game3.getPlayers()[3].giveMule(smithoreMule);
        int game31Smithore = game3.getPlayers()[0].getSmithore();
        game3.currentState = GameDummy.State.MULE_PLACING;
        game3.landClicked("etc01", new Rectangle(), new Rectangle());
        game3.endTurn();
        Assert.assertNotEquals("game3 production incorrect", game31Smithore, game3.getPlayers()[0].getSmithore());
        int game32Smithore = game3.getPlayers()[1].getSmithore();
        game3.currentState = GameDummy.State.MULE_PLACING;
        game3.landClicked("etc10", new Rectangle(), new Rectangle());
        game3.endTurn();
        Assert.assertNotEquals("game3 production incorrect", game32Smithore, game3.getPlayers()[1].getSmithore());
        int game33Smithore = game3.getPlayers()[2].getSmithore();
        game3.currentState = GameDummy.State.MULE_PLACING;
        game3.landClicked("etc11", new Rectangle(), new Rectangle());
        game3.endTurn();
        Assert.assertNotEquals("game3 production incorrect", game33Smithore, game3.getPlayers()[2].getSmithore());
        int game34Smithore = game3.getPlayers()[3].getSmithore();
        game3.currentState = GameDummy.State.MULE_PLACING;
        game3.landClicked("etc00", new Rectangle(), new Rectangle());
        game3.endTurn();
        Assert.assertNotEquals("game3 production incorrect", game34Smithore, game3.getPlayers()[3].getSmithore());

    }

}
