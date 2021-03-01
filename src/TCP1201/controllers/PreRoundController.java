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
    public GridPane gridPane;
    public Label title;

    private Game game;

    public void initialize(){
        this.game = GameHolder.getInstance().getGame();
        int totalPlayers = game.getPlayers().size();
        String header = "Pre Game of ";
        if(totalPlayers == 3){
            header += "3-Player Phase";
        }else{
            header += "2-Player Phase";
        }
        title.setText(header);
        showShuffleCard();
    }
    public void showShuffleCard(){
        game.dealCards();
        gridPane.getChildren().clear();
        PrintCard.showAvailableCards(game,gridPane);
    }

    public void onShuffleCard(MouseEvent mouseEvent) {
        showShuffleCard();
    }

    public void onStartGame(MouseEvent mouseEvent) throws IOException {
        Main.switchScene("resources/round.fxml");
    }
}
