package MULE.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

// Created by David on 10/16/2015.
public class ErrorController {
    @FXML
    public void back(ActionEvent event) {
        ScreenNavigator.instance.loadPlayer();
    }
}
