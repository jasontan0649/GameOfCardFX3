package TCP1201.controllers;
import TCP1201.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.io.IOException;


public class unluckyDrawController {
    @FXML private Label title;
    @FXML private Button startDrawBtn;
    @FXML private Button nextPhaseBtn;

    private Game game;

    @FXML
    private void initialize(){
       this.game = GameHolder.getInstance().getGame();
    }

    @FXML
    private void onStartUnluckyDraw(MouseEvent mouseEvent) {
        Player unluckyPlayer = game.unluckyDraw(game.getWeakPlayers());
        String header = "The unlucky player is " + unluckyPlayer.getName();
        title.setText(header);
        startDrawBtn.setDisable(true);
        nextPhaseBtn.setVisible(true);
        Scene scene = title.getScene();
        Snapshot.saveAsPng(scene);
    }

    @FXML
    private void onStartPhase(MouseEvent mouseEvent) throws IOException {
        Main.switchScene("resources/postFirstPhase.fxml");
    }
}
