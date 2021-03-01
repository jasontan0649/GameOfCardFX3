package TCP1201.controllers;

import TCP1201.Game;
import TCP1201.GameHolder;
import TCP1201.Main;
import TCP1201.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class PostFirstPhaseController {
    @FXML
    private Label title;

    @FXML
    private void initialize(){
        Game game = GameHolder.getInstance().getGame();
        ArrayList<Player> players = game.getPlayers();
        String header = players.get(0).getName() + " and " + players.get(1).getName() + " proceed to 2-Player phase ";
        title.setText(header);
    }

    @FXML
    private void onStartPhase(MouseEvent mouseEvent) throws IOException {
        Main.switchScene("resources/preRound.fxml");
    }
}
