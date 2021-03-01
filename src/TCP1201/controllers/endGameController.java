package TCP1201.controllers;

import TCP1201.Game;
import TCP1201.GameHolder;
import TCP1201.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class endGameController {

    @FXML
    private Label title;

    @FXML
    private void initialize(){
        Game game = GameHolder.getInstance().getGame();
        showWinner(game);
    }

    private void showWinner(Game game){
        ArrayList<Player> players = game.getPlayers();
        String header = players.get(0).getName() + " ";
        if(players.size() == 2)
            header += "and " + players.get(1).getName() + " are ";
        else
            header += "is ";
        header += "the WINNER";
        if(players.size() == 2)
            header += "S";

        header += "!!!";
        title.setText(header);
    }

    @FXML
    private void onRestartGame(MouseEvent mouseEvent) {
    }
}
