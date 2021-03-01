package TCP1201.controllers;

import TCP1201.*;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


import java.io.IOException;
import java.util.ArrayList;

public class PreRoundController {
    @FXML
    public GridPane gridPane;

    private GameHolder holder;

    public void initialize(){
        this.holder = GameHolder.getInstance();
        holder.showShuffleCard(gridPane);
    }

    public void onShuffleCard(MouseEvent mouseEvent) {
        holder.showShuffleCard(gridPane);
    }

    public void onStartGame(MouseEvent mouseEvent) throws IOException {
        Main.switchScene("resources/round.fxml");
    }
}
