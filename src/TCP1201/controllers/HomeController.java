package TCP1201.controllers;
import TCP1201.Game;
import TCP1201.GameHolder;
import TCP1201.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class HomeController {
    @FXML private TextField p1Name;
    @FXML private TextField p2Name;
    @FXML private TextField p3Name;

    @FXML
    private void onClickHandler(MouseEvent mouseEvent) throws IOException {
        GameHolder holder = GameHolder.getInstance();
        Game game = new Game(p1Name.getText(), p2Name.getText(), p3Name.getText());
        holder.setGame(game);
        Main.switchScene("resources/preRound.fxml");
    }
}

