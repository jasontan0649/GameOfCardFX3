package TCP1201.controllers;

import TCP1201.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class RoundController {
    public BorderPane root;
    public GridPane gridPane;
    public Label roundTitle;
    public Button nextRoundBtn;


    private Game game;
    private int roundInt = 1;

    public void initialize(){
        this.game = GameHolder.getInstance().getGame();
        int totalPlayers = game.getPlayers().size();
        int maxRound;
        if(totalPlayers == 3){
            maxRound = 3;
        }else{
            maxRound = 4;
        }
        // Initial Run
        showRound();
        roundInt++;
        nextRoundBtn.setOnMouseClicked(e ->{
            if(roundInt <= maxRound){
                showRound();
                roundInt++;
            }
        });
    }

    public void showRound(){
        Round round = new Round(game, roundInt);
        roundTitle.setText("Round " + roundInt);
        setUpGrid();
        showCardsAtHand(round);
//          round.showScore();
//          game.showAvailableCard();
    }

    public void showCardsAtHand(Round round){
        int i = 0;
        for (Player p : game.getPlayers()) {
            int row = i + 1;
            // Add PlayerName
            Label pName = new Label(p.getName() + " : ");
            gridPane.add(Utils.styleContent(pName),0, row);

            // Add Cards At Hand
            ArrayList<Card> cardPart = round.getCards().get(i);
            HBox hBoxRow = Utils.styleHRow(new HBox());
            ImageView[] imageViewsRow = new ImageView[cardPart.size()];
            for (int j = 0; j < cardPart.size(); j++){
                imageViewsRow[j] = new ImageView();
                String fileName = "TCP1201/resources/cards/" + cardPart.get(j)+ ".png";
                imageViewsRow[j].setImage(new Image(fileName, 59, 80, true, true));
            }
            hBoxRow.getChildren().addAll(imageViewsRow);
            gridPane.add(hBoxRow,1, row );

            // Add Player Best Point
            Label point = new Label(String.valueOf(round.getPoints().get(i)));
            gridPane.add(Utils.styleContent(point),2,row);

            // Add Who is Winner for current Round
            if (round.getWinnerIdx().contains(i)){
                Label winWord = new Label("Win");
                gridPane.add(Utils.styleContent(winWord), 3,row);
            }
            i++;
        }
    }
    public void setUpGrid(){
        gridPane.getChildren().clear();
        gridPane.add(Utils.styleColTitle(new Label("Cards At Hand")),1, 0);
        gridPane.add(Utils.styleColTitle(new Label("Point")),2, 0);
        gridPane.setPadding(new Insets(0,200,0,200));
    }

}
