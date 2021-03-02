package TCP1201.controllers;

import TCP1201.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.io.IOException;

public class PreRoundController {
    @FXML private GridPane gridPane;
    @FXML private Label title;
    @FXML private Game game;

    @FXML
    private void initialize(){
        this.game = GameHolder.getInstance().getGame();
        int totalPlayers = game.getPlayers().size();
        String header = "Pre Game of " + totalPlayers + "-Player Phase";
        title.setText(header);
        showShuffleCard();
    }

    private void showShuffleCard(){
        gridPane.getChildren().clear();
        game.dealCards();
        PrintCard.showAvailableCards(game,gridPane);
    }

    @FXML
    private void onShuffleCard(MouseEvent mouseEvent) {
        showShuffleCard();
        Scene scene = gridPane.getScene();
        Snapshot.saveAsPng(scene);
    }

    @FXML
    private void onStartGame(MouseEvent mouseEvent) throws IOException {
        Main.switchScene("resources/round.fxml");
    }
}
