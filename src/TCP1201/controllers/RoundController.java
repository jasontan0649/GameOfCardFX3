package TCP1201.controllers;

import TCP1201.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
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
        int maxRound = 6 - totalPlayers;
        // Run Initial Round
        showRound();
        roundInt++;
        nextRoundBtn.setOnMouseClicked(e -> {
            if(roundInt <= maxRound){ //If not last round
                showRound();
                roundInt++;
                Scene scene = gridPane1.getScene();
                Snapshot.saveAsPng(scene);
                return;
            }
            //After last round
            try {
                game.removeWeakest(); //remove weakest player

                if(maxRound == 3)  // for 3-player phase
                    game.nextPhase();
                else // 2-players phase(last phase), show end game
                    game.showEndGame();

            } catch (IOException ioException) {
                ioException.printStackTrace();
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

            ImageView[] imageViewsRow = PrintCard.createImageViewRow(cardPart, 59, 80);

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

}
