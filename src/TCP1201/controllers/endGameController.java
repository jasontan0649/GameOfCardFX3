package TCP1201.controllers;

import TCP1201.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
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
    private void onRestartGame(MouseEvent mouseEvent) throws IOException {
        Snapshot.clearList();
        Snapshot.setCount(1);
        Main.startGame();
    }

    public void onOpenHistory(ActionEvent actionEvent) throws IOException {
        Main.openHistory();
    }
}
