package TCP1201.controllers;

import TCP1201.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.io.IOException;
import java.util.ArrayList;

public class RoundController {
    @FXML private GridPane gridPane1;
    @FXML private GridPane gridPane2;
    @FXML private Label roundTitle;
    @FXML private Button nextRoundBtn;

    private Game game;
    private int roundInt = 1;

    @FXML
    private void initialize(){
        this.game = GameHolder.getInstance().getGame();
        int totalPlayers = game.getPlayers().size();
        int maxRound;
        if(totalPlayers == 3){
            maxRound = 3;
        }else{
            maxRound = 4;
        }
        // Run Initial Round
        showRound();
        roundInt++;
        nextRoundBtn.setOnMouseClicked(e ->{
            if(roundInt <= maxRound){
                showRound();
                roundInt++;
            }else{
                try {
                    game.removeWeakest(); //remove weakest player
                    proceedToNext(maxRound);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    private void showRound(){
        Round round = new Round(game, roundInt);
        roundTitle.setText("Round " + roundInt);
        setUpGrid();
        showCardsAtHand(round);
        PrintCard.showAvailableCards(game,gridPane2);
    }

    private void showCardsAtHand(Round round){
        int i = 0;
        for (Player p : game.getPlayers()) {
            int row = i + 1;
            // Add PlayerName
            Label pName = new Label(p.getName() + " : ");
            gridPane1.add(Utils.styleContent(pName),0, row);

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
            gridPane1.add(hBoxRow,1, row );

            // Add Player Best Point
            Label point = new Label(String.valueOf(round.getPoints().get(i)));
            gridPane1.add(Utils.styleContent(point),2,row);

            // Add Who is Winner for current Round
            if (round.getWinnerIdx().contains(i)){
                Label winWord = new Label("Win");
                gridPane1.add(Utils.styleContent(winWord), 3,row);
            }

            // Add Score
            Label score = new Label(String.valueOf(p.getScore()));
            gridPane1.add(Utils.styleContent(score), 4,row);

            i++;
        }
    }

    private void setUpGrid(){
        gridPane1.getChildren().clear();
        gridPane2.getChildren().clear();
        gridPane1.add(Utils.styleColTitle(new Label("Cards At Hand")),1, 0);
        gridPane1.add(Utils.styleColTitle(new Label("Point")),2, 0);
        gridPane1.add(Utils.styleColTitle(new Label("Score")),4, 0);
    }

    private void proceedToNext(int maxRound) throws IOException {
        if(maxRound == 3)   // 3 players phase
            Main.switchScene("resources/postFirstPhase.fxml");
        else                // 2 players phase
            Main.switchScene("resources/endGame.fxml");
    }

}
