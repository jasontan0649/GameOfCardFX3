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

    private GameHolder gameHolder;

    public void initialize(){
        this.gameHolder = GameHolder.getInstance();
        showShuffleCard(gameHolder.getGame());
    }
    public void showShuffleCard(Game game){
        game.dealCards();
        gridPane.getChildren().clear();
        ArrayList<Player> players = game.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            Label pName = new Label(players.get(i).getName() + " : ");
            gridPane.add(Utils.styleContent(pName),0, i);
            int column = 1;
            for (ArrayList<Card> cardPart : players.get(i).getCards()) {
                HBox hBoxRow = Utils.styleHRow(new HBox());
                ImageView[] imageViewsRow = new ImageView[cardPart.size()];
                for (int z = 0; z < cardPart.size(); z++){
                    imageViewsRow[z] = new ImageView();
                    String fileName = "TCP1201/resources/cards/" + cardPart.get(z)+ ".png";
                    imageViewsRow[z].setImage(new Image(fileName, 59, 100, true, true));
                }
                hBoxRow.getChildren().addAll(imageViewsRow);
                gridPane.add(hBoxRow,column, i);
                column++;
            }
        }
    }

    public void onShuffleCard(MouseEvent mouseEvent) {
        showShuffleCard(gameHolder.getGame());
    }

    public void onStartGame(MouseEvent mouseEvent) throws IOException {
        Main.switchScene("resources/round.fxml");
    }
}
