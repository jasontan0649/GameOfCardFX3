package TCP1201.controllers;

import TCP1201.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


import java.util.ArrayList;


public class PreRoundController {

    @FXML
    public BorderPane borderPane;
    public GridPane gridPane;


    public void initialize(){
        showAvailableCard();
    }

    public void showAvailableCard(){

        GameHolder holder = GameHolder.getInstance();
        Game game = holder.getGame();
        game.showShuffleCard();
        ArrayList<Player> players= game.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            int column = 1;
            Label pName = new Label(players.get(i).getName() + ":");
            pName.setMaxWidth(Double.MAX_VALUE);

            gridPane.add(pName,0, i);
            for (ArrayList<Card> cardPart : players.get(i).getCards()) {
              HBox hBoxRow = new HBox();
              ImageView[] imageViewsRow = new ImageView[cardPart.size()];
              for (int z = 0; z < cardPart.size(); z++){
                  imageViewsRow[z] = new ImageView();
                  String fileName = "TCP1201/resources/cards/"+cardPart.get(z)+".png";
                  imageViewsRow[z].setImage(new Image(fileName, 60, 100, false, false));
                }
              hBoxRow.getChildren().addAll(imageViewsRow);
              gridPane.add(hBoxRow,column, i);
              column++;
            }

        }
    }
}
