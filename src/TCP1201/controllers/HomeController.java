package TCP1201.controllers;
import TCP1201.Game;
import TCP1201.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;

public class HomeController {
    @FXML private TextField p1Name;
    @FXML private TextField p2Name;
    @FXML private TextField p3Name;

    public void handleButtonAction(ActionEvent actionEvent) throws IOException {
        Game game = new Game(p1Name.getText(),p2Name.getText(),p3Name.getText());
        Main.switchScene("resources/preRound.fxml");

    }
}

