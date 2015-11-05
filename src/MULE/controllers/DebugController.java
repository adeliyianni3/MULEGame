package MULE.controllers;

import java.net.URL;

import MULE.models.Player;
import javafx.animation.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ResourceBundle;

// Created by Ethan on 9/29/2015.

//http://stackoverflow.com/questions/13227809/displaying-changing-values-in-javafx-label
public class DebugController implements Initializable {

    @FXML
    private Rectangle currentColor;
    @FXML
    private Label turn;
    @FXML
    private Label totalTurn;
    @FXML
    private Label round;
    @FXML
    private Label phase;
    @FXML
    private Label firstPlace;
    @FXML
    private Label secondPlace;
    @FXML
    private Label thirdPlace;
    @FXML
    private Label fourthPlace;
    @FXML
    private Label player1;
    @FXML
    private Label player2;
    @FXML
    private Label player3;
    @FXML
    private Label player4;
    @FXML
    private Label firstScore;
    @FXML
    private Label secondScore;
    @FXML
    private Label thirdScore;
    @FXML
    private Label fourthScore;
    @FXML
    private Label money1;
    @FXML
    private Label money2;
    @FXML
    private Label money3;
    @FXML
    private Label money4;
    @FXML
    private Label land1;
    @FXML
    private Label land2;
    @FXML
    private Label land3;
    @FXML
    private Label land4;
    @FXML
    private Label food1;
    @FXML
    private Label food2;
    @FXML
    private Label food3;
    @FXML
    private Label food4;
    @FXML
    private Label smithore1;
    @FXML
    private Label smithore2;
    @FXML
    private Label smithore3;
    @FXML
    private Label smithore4;
    @FXML
    private Label energy1;
    @FXML
    private Label energy2;
    @FXML
    private Label energy3;
    @FXML
    private Label energy4;
    @FXML
    private Label timer;
    @FXML
    private Label currentPlayer;
    @FXML
    private Label lastEvent;
    //private Player[] p;
    //private Player[] op;


    private void bindToTime() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        new EventHandler<ActionEvent>() {
                            @Override public void handle(ActionEvent actionEvent) {
                                Player[] p = Game.instance.getPlayers();
                                Player[] op = Game.instance.getOriginalPlayers();
                                //p = Game.instance.getPlayers();
                                //op = Game.instance.getOriginalPlayers();
                                turn.setText("" + Game.instance.getTurn());
                                if (p.length > 0 && p[Game.instance.getTurn() - 1] != null) {
                                    currentPlayer.setText(p[Game.instance.getTurn() - 1].getName());
                                    currentColor.setFill(Game.instance.currentPlayer().getColor());
                                }
                                totalTurn.setText("" + Game.instance.getTotalTurns());
                                lastEvent.setText(Game.instance.getLastEvent());
                                round.setText("" + Game.instance.getRound());
                                phase.setText("" + Game.instance.getPhase().name());
                                //Player[] p = Game.instance.getPlayers();
                                //Player[] op = Game.instance.getOriginalPlayers();
                                if (p.length > 0 && p[0] != null) {
                                    firstPlace.setText("" + p[0].getName());
                                    firstScore.setText("" + p[0].getScore());

                                }
                                if (p.length > 1 && p[1] != null) {
                                    secondPlace.setText("" + p[1].getName());
                                    secondScore.setText("" + p[1].getScore());

                                }
                                if (p.length > 2 && p[2] != null) {
                                    thirdPlace.setText("" + p[2].getName());
                                    thirdScore.setText("" + p[2].getScore());

                                }
                                if (p.length > 3 && p[3] != null) {
                                    fourthPlace.setText("" + p[3].getName());
                                    fourthScore.setText("" + p[3].getScore());

                                }


                                if (op.length > 0 && op[0] != null) {
                                    player1.setText("" + op[0].getName());
                                    money1.setText("" + op[0].getMoney());
                                    land1.setText("" + op[0].getNumOfLands());
                                    food1.setText("" + op[0].getFood());
                                    smithore1.setText("" + op[0].getSmithore());
                                    energy1.setText("" + op[0].getEnergy());

                                }
                                if (op.length > 1 && op[1] != null) {
                                    player2.setText("" + op[1].getName());
                                    money2.setText("" + op[1].getMoney());
                                    land2.setText("" + op[1].getNumOfLands());
                                    food2.setText("" + op[1].getFood());
                                    smithore2.setText("" + op[1].getSmithore());
                                    energy2.setText("" + op[1].getEnergy());

                                }
                                if (op.length > 2 && op[2] != null) {
                                    player3.setText("" + op[2].getName());
                                    money3.setText("" + op[2].getMoney());
                                    land3.setText("" + op[2].getNumOfLands());
                                    food3.setText("" + op[2].getFood());
                                    smithore3.setText("" + op[2].getSmithore());
                                    energy3.setText("" + op[2].getEnergy());

                                }
                                if (op.length > 3 && op[3] != null) {
                                    player4.setText("" + op[3].getName());
                                    money4.setText("" + op[3].getMoney());
                                    land4.setText("" + op[3].getNumOfLands());
                                    food4.setText("" + op[3].getFood());
                                    smithore4.setText("" + op[3].getSmithore());
                                    energy4.setText("" + op[3].getEnergy());

                                }






                                timer.setText("" + Game.instance.timer.getTime()); //TODO



                            }
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bindToTime();
    }
}
